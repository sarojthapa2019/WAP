<%--
  Created by IntelliJ IDEA.
  User: rXing
  Date: 4/18/2019
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"
            type="text/javascript"></script>
    <title>Insert title here</title>
</head>
<body>
<h2>Create Object from JSON String</h2>
<script type="text/javascript">
    var jsonString = '{"window" : {"title" : "Sample Widget","width" : 500, "height" : 500},"image" : {"src" : "images/logo.png","coords" : [ 250, 150, 350, 400 ],"alignment" : "center"},"messages" : [ {"text" : "Save","offset" : [ 10, 30 ]}, {"text" : "Help","offset" : [ 0, 50 ]}, {"text" : "Quit","offset" : [ 30, 10 ]}],"debug" : "true"}';
    var data = JSON.parse(jsonString);

    var title = data.window.title;
    console.log("title: " + title);
    var coord = data.image.coords[2];
    console.log("coord: " + coord);
    var len = data.messages.length;
    console.log("len: " + len);
    var y = data.messages[len - 1].offset[1];
    console.log("y: " + y);

    var jsonObj = {
        "window" : {
            "title" : "Sample Widget",
            "width" : 500,
            "height" : 500
        },
        "image" : {
            "src" : "images/logo.png",
            "coords" : [ 250, 150, 350, 400 ],
            "alignment" : "center"
        },
        "messages" : [ {
            "text" : "Save",
            "offset" : [ 10, 30 ]
        }, {
            "text" : "Help",
            "offset" : [ 0, 50 ]
        }, {
            "text" : "Quit",
            "offset" : [ 30, 10 ]
        } ],
        "debug" : "true"
    };

    var jsonstring2 = JSON.stringify(jsonObj);
    alert(jsonstring2);
</script>
<p></p>
</body>
</html>