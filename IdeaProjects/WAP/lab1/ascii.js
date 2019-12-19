function load() {

    let start = document.getElementById("start");
    let stop = document.getElementById("stop");
    let animation = document.getElementById("animation");
    let size = document.getElementById("fontsize");
    let speed = document.getElementById("turbo");
    let displayArea = document.getElementById("text-area");
    let id;
    stop.disabled = true;
    start.onclick = startAnimation;
    stop.onclick = stopAnimation;

    function stopAnimation() {
        stop.disabled = true;
        start.disabled = false;
        animation.disabled = false;
        clearTimeout(id);
        displayArea.innerHTML='';
    }
    function startAnimation() {
        let animationValue = animation.options[animation.selectedIndex].value;
        if(animationValue=="Blank"){
            return alert("Please Select an animation to start!!");
        }
        stop.disabled = false;
        start.disabled = true;
        animation.disabled = true;

        let components = ANIMATIONS[animationValue].split('=====\n');
            let key = 0;
            let delay = 250;
            function frame() {
                if(key>=components.length){
                    key=0;
                }
                displayArea.style.fontSize = size.value;

                displayArea.innerHTML = components[key];
                key++;
                if(speed.checked){
                    delay = 50;
                }
                else{
                    delay = 250;
                }
                //using setTimeout to dynamically change interval
                // id = setInterval(frame, delay);
                id = setTimeout(frame,delay);
            }
            frame();
        }

}
window.onload = load;
