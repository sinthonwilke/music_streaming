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
    document.getElementById("searchResult").innerHTML = document.getElementById("defualtResult").innerHTML;
}

    function searchResult() {
        var str = document.getElementById("searchBox").value;
        var out = "";
        var music = JSON.parse(load("/search_results=" + str));
        var album = JSON.parse(load("/search_albums=" + str));

        out += "<div class='vertical-menu'>";
        if(str.length > 0) {
            if(music.length > 0) {
                for(var i = 0; i < music.length; i++) {
                    out += '<a onclick="playAudio(' + music[i].id + ')">' + music[i].artist.name + " - " + music[i].name + '</a>';
                }
            } else {
                out += '<a>No music results found</a>';
            }
            out += "</div>";

        out += "<div class='scrollmenu'>";
            if(album.length > 0) {
                for(var i = 0; i < album.length; i++) {
                    out += '<a class="dropbtn" onclick="showAlbum(' + album[i].id + ')">' + album[i].name + " (" + album[i].artist.name + ")";
                }
            } else {
                out += '<a>No album results found</a>';
            }
            out += "</div>";
        document.getElementById("searchResult").innerHTML = out;
        } else {
            document.getElementById("searchResult").innerHTML = document.getElementById("defualtResult").innerHTML;
        }
    }

    function showAlbum(id) {
        var out = '';
        out = "<a> test1 </a>" + "<a> test2 </a>" + "<a> test3 </a>";

        // var albumList = JSON.parse(load("/album=" + id));
        // var albumList = load("/album=" + id);
        // out += albumList
        // no message, error 404
        document.getElementById("myDropdown").innerHTML = out;
        listPop();
    }

    function listPop() {
        document.getElementById("myDropdown").classList.toggle("show");
        window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
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