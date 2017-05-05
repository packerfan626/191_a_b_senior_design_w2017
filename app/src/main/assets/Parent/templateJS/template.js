function growDiv(element)
{
    var growDiv = document.getElementById(element);
    if (growDiv.clientHeight)
    {
        growDiv.style.height = 0;
    }else{
        var wrapper = document.querySelector('.measuringWrapper');
        growDiv.style.height = wrapper.clientHeight + "px";
    }
}