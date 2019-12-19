window.onload = function () {
            document.getElementById("clickme").onclick = function () {
            //    this.className = "highlighted";
                var divElem = document.getElementById("div1");
                
                var currentClass = divElem.className;

                if(currentClass.indexOf("show") > -1){
                    // remove show  add hide
                    currentClass = currentClass.substring(0, currentClass.indexOf("show"));
                    currentClass += "hide";
                    console.log(currentClass);
                    divElem.className = currentClass;

                } else{
                     currentClass = currentClass.substring(0, currentClass.indexOf("hide"));
                    currentClass += "show";
                    console.log(currentClass);
                    divElem.className = currentClass;
                }


            };
        };