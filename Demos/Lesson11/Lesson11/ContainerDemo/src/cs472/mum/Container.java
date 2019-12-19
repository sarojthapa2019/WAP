package cs472.mum;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

class Container {
    private String secret = "Shhh!";
    private Hashtable<String, Mylet> mylets = new Hashtable<String, Mylet>();

    /* static class data/methods */
    public static void main(String[] a) {
        new Container();
    }

    public Container() {
        try {
//            FileOutputStream fos = new FileOutputStream("test.bin");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(this);
//            oos.close();
            int port = 8090;

            ServerSocket ss = new ServerSocket(port);
            System.out.println(String.format("Container started. Listening on port %d\r\n", port));
            while (true) // listen for requests on port 8090
            {
                Socket s = ss.accept();
                System.out.println("Accepted connection");
                handleHTTPRequest(s);  // process the request
            }
        } catch (Throwable ex) {
            System.out.format("container exception:  ***");
            System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());
        }
    }

    // process GET or POST request from a browser
    public void handleHTTPRequest(Socket s) throws Exception {
        // these are used to encapsulate the HTTP request and response
        Hashtable<String, String> requestHeaders = new Hashtable<String, String>();
        Hashtable<String, String> formParameters = new Hashtable<String, String>();
        Hashtable<String, String> responseHeaders = new Hashtable<String, String>();
        StringBuilder responseContent = new StringBuilder();
        Pattern p = null;
        Matcher m = null;
        byte[] b = null;
        FileInputStream fis = null;
        Mylet mylet = null; // will hold reference to Mylet named
        String method = null;
        String myletName = null;
        try {
            InputStream is = new BufferedInputStream(s.getInputStream());
            s.setSoTimeout(2000);      // block on read for this many milliseconds

            String requestLine = readLine(is);
            p = Pattern.compile("^(\\w+)\\s+/([^\\s]+)");
            m = p.matcher(requestLine);
            if (m.find()) {
                method = m.group(1).toLowerCase();
                myletName = m.group(2);
                mylet = getMylet(myletName);
                System.out.println("mylet: " + mylet);
            } else
                throw new Exception(String.format("Something wrong with %s\r\n", requestLine));

            StringBuilder sb = new StringBuilder();
            String line = null;
            int contentLength = -1;
            // read headers and save them in a Hashtable
            while ((line = readLine(is)).length() > 0) {
                if (line.toLowerCase().startsWith("content-length")) {
                    // Remember length of the content.
                    p = Pattern.compile("\\d+$");
                    m = p.matcher(line);
                    if (m.find()) {
                        contentLength = Integer.parseInt(m.group());
                    }
                }
                String header[] = line.split(":");
                requestHeaders.put(header[0].trim(), header[1].trim());      // save header in a hash table
            }

            // Save parameters in a hash table—will be in body if it is a post (get params ignored?)
            if (contentLength != -1) {
                b = new byte[contentLength];
                is.read(b);
                String params = new String(b, "UTF-8");
                String fields[] = params.split("&"); // params = name1=value1;name2=value2;name3=value3&...
                for (String field : fields) {
                    String nv[] = field.split("=");// field is name=value
                    formParameters.put(nv[0], nv[1]);// name-->value
                }
            }

            // invoke service method of mylet, passing in encapsulated HTTP request & response
            // Should run this in its own thread!
            mylet.service(method, requestHeaders, formParameters, responseHeaders, responseContent);
            StringBuilder httpResponse = new StringBuilder();
            // httpResponse.append(status line): should be able to set status
            // httpResponse.append(headers in responseHeaders): should set headers
            OutputStream os = s.getOutputStream();
            os.write(responseContent.toString().getBytes("UTF-8"));
        } catch (Exception ex) {
            System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());
        } finally {
            s.close();
            fis.close();
        }
    }

    // Use reflection to instantiate named Mylet or reuse an already existing one
    private Mylet getMylet(String name) throws Exception {
        Mylet mylet = mylets.get(name);
        if (mylet == null)  // if first time anybody has asked for this servlet since last
        {                   // time that the container was started.
            Class c = Class.forName("cs472.mum." + name);
            mylet = (Mylet) c.newInstance();  //need reflection because containers won’t know servlet names in advance
            mylets.put(name, mylet);  // save reference in hashtable so it can be reused
            mylet.init();
        }
        return mylet;
    }

    // read socket until \r\n found. If stream ends before this is found return null, else return
// bytes up to but not including \r\n
    private static String readLine(InputStream is) throws Exception {
        int ch = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();
        while (true) {
            ch = is.read();
            if (ch == -1) {
                return null;
            }      // shouldn't happen with HTTP headers
            if (ch == '\r') {
                ch = is.read();
                break;
            } else {
                a.add(ch);
            }
        }

        int len = a.size();
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[i] = (byte) ((Integer) a.get(i)).intValue();
        }

        return new String(b, 0, b.length, "UTF-8");
    }
}

