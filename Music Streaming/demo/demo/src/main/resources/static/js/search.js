function searchResult() {

    var delayInMilliseconds = 0;
    setTimeout(function() {
        var str = document.getElementById("searchBox").value;
        var url = "/search_results=" + str;

        showMusic(load(url))

        document.getElementById("test1").innerHTML = load(url);
    }, delayInMilliseconds);

}

function load(url) {
    const xhttp = new XMLHttpRequest();
    var res;
    xhttp.onload = function() {
        res = this.response;
    }
    xhttp.open("GET", url, false);
    xhttp.send();
    return res;
}

function showMusic(musics) {
    var out;
    for(var music in musics) {
        out += music;
    }
    document.getElementById("result").innerHTML = out;
}