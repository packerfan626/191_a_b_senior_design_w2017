function growDiv(element, but)
{
    var growDiv = document.getElementById(element);
    var button = document.getElementById(but);
    var arrow = document.getElementById(but+'Arrow');
    if (growDiv.clientHeight)
    {
        button.style.backgroundColor = "#e2e2e2";
        button.style.borderColor = "inherit";
        arrow.style.transform="rotate(1800deg)";
        growDiv.style.height = 0;
    }else{
        var wrapper = document.querySelector('.measuringWrapper');
        button.style.backgroundColor = "#fbb919";
        growDiv.style.height = wrapper.clientHeight + "px";
        arrow.style.transform="rotate(90deg)";
    }
}

window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("topBtn").style.display = "block";
    } else {
        document.getElementById("topBtn").style.display = "none";
    }
}


function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}