window.onload = function() {
    homePage()
  };

function homePage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/home");
    xhttp.send();
}

function searchPage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/search");
    xhttp.send();
}

    function searchResult() {

        var delayInMilliseconds = 0;
        setTimeout(function() {
            var str = document.getElementById("searchBox").value;
            var url = "/search_results=" + str;

            showMusic(load(url))

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
        var music = JSON.parse(musics);
        var out = "";
        for(var i = 0; i < music.length; i++) {
            out += '<button type="button" onclick="playMusic(music[i].id)">' + music[i].artist.name + " - " +music[i].name + '</button>';
        }
        document.getElementById("result").innerHTML = out;
    }

function libraryPage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/library");
    xhttp.send();
}

function accountPage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/account");
    xhttp.send();
}

function playAudio(id) {
    var audio = document.getElementById("audio");
    audio.src="assets/musics/" + id + ".wav";
    audio.volume = 0.25;
    audio.play();
}
