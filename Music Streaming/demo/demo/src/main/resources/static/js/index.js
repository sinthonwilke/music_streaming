window.onload = function() {
    homePage()
    document.getElementById("likeButton").innerHTML = 'none';
    document.getElementById("likeButton").innerHTML = '<button class="transparent">none</button>';
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

        if(str.length > 0) {

            var music = JSON.parse(load("/search_results=" + str));
            var album = JSON.parse(load("/search_albums=" + str));

            if(music.length == 0 && album.length == 0) {
                out += '<p>No results found for "' + str + '"<br>Try searching for something else.</p>';
            }
            else {

                out += "<div class='vertical-menu'>";
                if(music.length > 0) {
                    for(var i = 0; i < music.length; i++) {
                        out += '<a onclick="playAudio(' + music[i].id + ')">' + music[i].artist.name + " - " + music[i].name + '</a>';
                    }
                }
                else {
                    out += '<a>No music results found</a>';
                }
                out += "</div>";

                out += "<div class='scrollmenu'>";
                if(album.length > 0) {
                    for(var i = 0; i < album.length; i++) {
                        out += '<a class="dropbtn" onclick="showAlbum(' + album[i].id + ')">' + album[i].name + " (" + album[i].artist.name + ")";
                    }
                }
                else {
                    out += '<a>No album results found</a>';
                }
                out += "</div>";

            }

            document.getElementById("searchResult").innerHTML = out;
        } 
        else {
            document.getElementById("searchResult").innerHTML = document.getElementById("defualtResult").innerHTML;
        }
    }

    function showAlbum(id) {
        var out = '';

        var albumList = JSON.parse(load("/albums=" + id));
        for(var i = 0; i < albumList.length; i++) {
            out += '<a class="dropbtn" onclick="playAudio(' + albumList[i].music.id + ')">' + albumList[i].music.artist.name + " - " + albumList[i].music.name + '</a>';
        }

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
    
function libraryPage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/library", false);
    xhttp.send();
    playlists();
}

    function favList() {
        var out = '';

        var favList = JSON.parse(load("/library_fav"));
        for(var i = 0; i < favList.length; i++) {
            out += '<a class="dropbtn" onclick="playAudio(' + favList[i].music.id + ')">' + favList[i].music.artist.name + " - " + favList[i].music.name + '</a>';
        }

        document.getElementById("myDropdown").innerHTML = out;
        listPop();
    }

    function playlists() {
        var out = '';
        var playlist = JSON.parse(load("/library_playlist"));
        for(var i = 0; i < playlist.length; i++) {
            out += '<button onclick="showlists(' + playlist[i].id + ')" class="dropbtn">' + playlist[i].name + '</button><br>'
        }

        document.getElementById("playlist").innerHTML = out;
        listPop();
    }

    function showlists(id) {
        var out = '';

        var list = JSON.parse(load("/playlists=" + id));
        for(var i = 0; i < list.length; i++) {
            out += '<a class="dropbtn" onclick="playAudio(' + list[i].music.id + ')">' + list[i].music.artist.name + " - " + list[i].music.name + '</a>';
        }
        
        document.getElementById("myDropdown").innerHTML = out;
        listPop();
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
    audio.value = id;
    audio.volume = 0.75;
    audio.play();
    checklike(id);
}

function checklike(id) {
    var fav = JSON.parse(load("/library_fav"));
    var likeButton = document.getElementById("likeButton");

    if(fav.length != 0) {
        for(var i = 0; i < fav.length; i++) {
            if(fav[i].music.id == id) {
                likeButton.innerHTML = '<button id="likeButton" onclick="likeSong()">Liked</button>';
                likeButton.value = true;
                break;
            }
            else {
                likeButton.innerHTML = '<button id="likeButton" onclick="likeSong()">Like</button>';
                likeButton.value = false;
            }
        }
    }   
    else {
        likeButton.innerHTML = '<button id="likeButton" onclick="likeSong()">Like</button>';
        likeButton.value = false;
    }
}

function likeSong() {
    var likeButton = document.getElementById("likeButton");
    var id = document.getElementById("audio").value;

    if (likeButton.value == true) {
        load("/delFavorite=" + id);
    }
    else {
        load("/addFavorite=" + id);
    }
    checklike(id);
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

// function post(url, data) {
//     const xhttp = new XMLHttpRequest();
//     xhttp.open("POST", url, false);
//     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     xhttp.send("data="+data);

//     //http.csrf().disable();
// }
  