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
        var str = document.getElementById("searchBox").value;
        var musicOut = "";
        var albumOut = "";
        var music = JSON.parse(load("/search_results=" + str));
        var album = JSON.parse(load("/search_albums=" + str));

        if(str.length > 0) {
            if(music.length > 0) {
                for(var i = 0; i < music.length; i++) {
                    // div?
                    musicOut += '<a onclick="playAudio(' + music[i].id + ')">' + music[i].artist.name + " - " + music[i].name + '</a>';
                }
            } else {
                musicOut = "No music results found";
            }
        document.getElementById("resultMusic").innerHTML = musicOut;

        if(album.length > 0) {
            for(var i = 0; i < album.length; i++) {
                albumOut += '<a>' + album[i].name + " (" + album[i].artist.name + ")" +'</a>';
            }
            } else {
                albumOut = "No album results found";
            }
        document.getElementById("resultAlbum").innerHTML = albumOut;
        }
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