window.onload = function() {
    homePage()
};

function homePage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/home", false);
    xhttp.send();
}

function searchPage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/search", false);
    xhttp.send();
    document.getElementById("result").innerHTML = document.getElementById("defualtResult").innerHTML;
}

    function searchResult() {

        var delayInMilliseconds = 0;
        setTimeout(function() {
            var str = document.getElementById("searchBox").value;
            var url = "/search_results=" + str;
            var out = "";
            if(str.length > 0) {
                var music = JSON.parse(load(url));
                for(var i = 0; i < music.length; i++) {
                    out += '<button type="button" onclick="playAudio(' + music[i].id + ')">' + music[i].artist.name + " - " + music[i].name + '</button><br>';
                }
            }
            else {
                out = document.getElementById("defualtResult").innerHTML;
            }
            document.getElementById("result").innerHTML = out;
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

function libraryPage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/library", false);
    xhttp.send();
}

function accountPage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/account", false);
    xhttp.send();
}

function playAudio(id) {
    var audio = document.getElementById("audio");
    audio.src="assets/musics/" + id + ".wav";
    audio.volume = 0.25;
    audio.play();
}
