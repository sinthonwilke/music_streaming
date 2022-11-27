function searchResult() {

    var delayInMilliseconds = 500;
    setTimeout(function() {
        var str = document.getElementById("searchBox").value;
        var url = "/search_results=" + str;
    
        var music = JSON.parse(load(url));
        document.getElementById("result").innerHTML = music;
    }, delayInMilliseconds);
}

function load(url) {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("result").innerHTML = this.response;
    }
    xhttp.open("GET", url);
    xhttp.send();
    return xhttp.onload;
}