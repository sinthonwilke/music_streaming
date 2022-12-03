window.onload = function() {
    homePage()
    document.getElementById("likeButton").innerHTML = 'none';
    document.getElementById("likeButton").innerHTML = '<button class="transparent">Like</button>';
    document.getElementById("prevSong").innerHTML = '<button class="transparent"> << </button>';
    document.getElementById("nextSong").innerHTML = '<button class="transparent"> >> </button>';
    document.getElementById("songName").innerHTML = '<p>Nothing is playing.</p>';
    document.getElementById("a2pl").innerHTML = "<button id='add2PlaylistButton' onclick='add2PlaylistAction()' class='dropbtn'>+2Playlist</button>";
    document.getElementById("a2pl").classList.add("transparent");
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
        var songName = "";

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
                        songName = music[i].artist.name + " - " + music[i].name;
                        out += '<a onclick="playAudio(' + music[i].id + ',' + "'" + songName + "'" + ')">' + songName + '</a>';
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
        var songName = '';

        var albumList = JSON.parse(load("/albums=" + id));
        for(var i = 0; i < albumList.length; i++) {
            songName = albumList[i].music.artist.name + " - " + albumList[i].music.name;
            out += '<a class="dropbtn" onclick="playAudio(' + albumList[i].music.id + ',' + "'" + songName + "'" + ')">' + songName + '</a>';
        }

        document.getElementById("myDropdown").innerHTML = out;
        listPop();
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
        var songName = '';
        var favList = JSON.parse(load("/library_fav"));

        if(favList.length > 0) {
            for(var i = 0; i < favList.length; i++) {
                songName = favList[i].music.artist.name + " - " + favList[i].music.name;
                out += '<a class="dropbtn" onclick="playAudio(' + favList[i].music.id + ',' + "'" + songName + "'" +')">' + songName + '</a>';
            }
        }
        else {
            out += "<a>Songs you like will appear here</a>";
        }
        document.getElementById("myDropdown").innerHTML = out;
        listPop();
    }

    function playlists() {
        var out = '';
        var playlist = JSON.parse(load("/library_playlist"));
        for(var i = 0; i < playlist.length; i++) {
            out += '<button onclick="showlists(' + playlist[i].id + ')" class="dropbtn">' + playlist[i].name + '</button>'
            out += '<button onclick="renamePlaylistPop(' + playlist[i].id + "," + "'" + playlist[i].name + "'" + ')" class="dropbtn">Rename</button>'
            out += '<button onclick="deleteList(' + playlist[i].id + ')" class="dropbtn">Delete</button><br>'
        }
        document.getElementById("playlist").innerHTML = out;
    }

    function showlists(id) {
        var out = '';
        var songName = '';
        var list = JSON.parse(load("/playlists=" + id));

        if(list.length > 0) {

            for(var i = 0; i < list.length; i++) {
                songName = list[i].music.artist.name + " - " + list[i].music.name;
                out += '<a class="dropbtn" onclick="playAudio(' + list[i].music.id + ',' + "'" + songName + "'" + ')">' + songName + '</a>';
            }
        }
        else {
            out += '<a>No music in this playlist.</a>';
        }
        
        document.getElementById("myDropdown").innerHTML = out;
        listPop();
    }

    function renamePlaylistPop(playlistID, playlistName) {
        document.getElementById("myOverlay2").style.display = "block";
        document.getElementById("bg").classList.add("bgLock");
        document.getElementById("renamePlaylist").value = playlistName;
        document.getElementById("renamePlaylistID").value = playlistID;
        window.onclick = function(event) {
            if (event.target == document.getElementById("myOverlay2")) {
                document.getElementById("myOverlay2").style.display = "none";
                document.getElementById("bg").classList.remove("bgLock");
                document.getElementById("renamePlaylist").value = null;
                document.getElementById("renamePlaylistID").value = null;
            }
        }
    }

    function renamePlaylistLoad(form) {
        load("/renamePlaylist=" + form.renamePlaylistID.value + "&" + form.renamePlaylist.value);
        libraryPage();
        document.getElementById("myOverlay2").style.display = "none";
        document.getElementById("bg").classList.remove("bgLock");
        document.getElementById("renamePlaylist").value = null;

    }

    function addPlaylistPop() {
        document.getElementById("myOverlay").style.display = "block";
        document.getElementById("bg").classList.add("bgLock");
    
        window.onclick = function(event) {
            if (event.target == document.getElementById("myOverlay")) {
                document.getElementById("myOverlay").style.display = "none";
                document.getElementById("bg").classList.remove("bgLock");
                document.getElementById("playlistName").value = null;
            }
        }
    }
    
    function addPlaylist(form) {
        load("/addPlaylist=" + form.playlistName.value);
        libraryPage();
        document.getElementById("myOverlay").style.display = "none";
        document.getElementById("bg").classList.remove("bgLock");
        document.getElementById("playlistName").value = null;
    }

    function deleteList(id) {
        load("/dellist=" + id);
        libraryPage();
    }

function accountPage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/account", false);
    xhttp.send();
}

var songHistoryName = [];
var songHistory = [];
var historyIndex;

function updateIndex(musicID, musicName) {

    if(historyIndex != songHistory.length - 1 && historyIndex != null) {
        songHistory.splice(historyIndex + 1, 0, musicID);
        songHistoryName.splice(historyIndex + 1, 0, musicName);
        historyIndex++;
    }
    else {
        songHistory.push(musicID);
        songHistoryName.push(musicName);
        historyIndex = songHistory.length - 1;
    }
    updateHistory();
}

function updateHistory() {
    // prev
    if(songHistory.length > 1 && historyIndex > 0) {
        document.getElementById("prevSong").innerHTML = '<button onclick="playPrev()"> << </button>';
    }
    else {
        document.getElementById("prevSong").innerHTML = '<button class="transparent"> << </button>';
    }

    // next
    if(songHistory.length - 1 > historyIndex) {
        document.getElementById("nextSong").innerHTML = '<button onclick="playNext()"> >> </button>';
    }
    else {
        document.getElementById("nextSong").innerHTML = '<button class="transparent"> >> </button>';
    }
}

function playAudio(musicID, musicName) {
    document.getElementById("songName").innerHTML = musicName;
    var audio = document.getElementById("audio");
    audio.src="assets/musics/" + musicID + ".wav";
    audio.value = musicID;
    audio.volume = 0.75;
    audio.play();
    checklike(musicID);
    updateIndex(musicID, musicName);
    document.getElementById("add2PlaylistButton").value = musicID;
    document.getElementById("a2pl").classList.remove("transparent");
}

function playPrev() {
    historyIndex--;
    updateHistory();
    document.getElementById("songName").innerHTML = songHistoryName[historyIndex];
    id = songHistory[historyIndex];
    var audio = document.getElementById("audio");
    audio.src="assets/musics/" + id + ".wav";
    audio.value = id;
    audio.volume = 0.75;
    audio.play();
    checklike(id);
    document.getElementById("add2PlaylistButton").value = musicID;
    document.getElementById("a2pl").classList.remove("transparent");
}

function playNext() {
    historyIndex++;
    updateHistory();
    document.getElementById("songName").innerHTML = songHistoryName[historyIndex];
    id = songHistory[historyIndex];
    var audio = document.getElementById("audio");
    audio.src="assets/musics/" + id + ".wav";
    audio.value = id;
    audio.volume = 0.75;
    audio.play();
    checklike(id);
    document.getElementById("add2PlaylistButton").value = musicID;
    document.getElementById("a2pl").classList.remove("transparent");

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

function listPop() {
    document.getElementById("myDropdown").classList.toggle("show");
    document.getElementById("bg").classList.add("bgLock");
    window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                    document.getElementById("bg").classList.remove("bgLock");
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

function add2PlaylistAction() {
    var musicID = document.getElementById("add2PlaylistButton").value;
    var out = '';
    var playlist = JSON.parse(load("/library_playlist"));
    if(playlist.length != 0) {
        for(var i = 0; i < playlist.length; i++) {
                out += '<a class="dropbtn" onclick="add2Playlist('+ musicID + "," + playlist[i].id +')">' + playlist[i].name + '</a>';
        }
    }
    else {
        out = '<a>You don\'t have any playlist yet.</a>';        
    }
    document.getElementById("myDropdown").innerHTML = out;
    listPop();
}

function add2Playlist(musicID, playlistID) {
    listPop();
    document.getElementById("bg").classList.remove("bgLock");
    load("/addMusicToPlaylist=" + musicID + "&" + playlistID);
    popupMessage("Added to playlist");
}

function popupMessage(msg) {
    var popup = document.getElementById("myPopup");
    document.getElementById("myPopup").innerHTML = msg;
    popup.classList.toggle("show");
    setTimeout(() => {
        popup.classList.toggle("show");
    }, 3000);
}