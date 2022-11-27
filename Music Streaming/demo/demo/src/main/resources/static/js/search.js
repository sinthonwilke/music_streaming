function searchResult() {

    var delayInMilliseconds = 0;
    setTimeout(function() {
        var str = document.getElementById("searchBox").value;
        var url = "/search_results=" + str;

        showTable(load(url))

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

function showTable(musics) {
    var out;

}