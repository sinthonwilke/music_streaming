window.onload = function() {
    page();
    homePage()
    document.getElementById("likeButton").innerHTML = 'none';
    document.getElementById("likeButton").innerHTML = '<button class="transparent">Like</button>';
    document.getElementById("prevSong").innerHTML = '<button class="transparent"> << </button>';
    document.getElementById("nextSong").innerHTML = '<button class="transparent"> >> </button>';
    document.getElementById("songName").innerHTML = '<p>Nothing is playing.</p>';
    document.getElementById("a2pl").innerHTML = "<button id='add2PlaylistButton' onclick='add2PlaylistAction()' class='dropbtn'>Add to playlist</button>";
    document.getElementById("a2pl").classList.add("transparent");
};

function page() {
    document.getElementById("homePageId").style.color = "Black";
    document.getElementById("searchPageId").style.color = "Black";
    document.getElementById("libraryPageId").style.color = "Black";
    document.getElementById("accountPageId").style.color = "Black";

}

function homePage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/home", false);
    xhttp.send();
    page();
    document.getElementById("homePageId").style.color = "Pink";
    recommendLoad();
    genreLoad();
    yourPlaylistLoad();
}
    // first time random
    var randomList = JSON.parse(load("/recommend=rand"));
    var list2020 = JSON.parse(load("/recommend=2020"));
    var list2021 = JSON.parse(load("/recommend=2021"));
    var list2022 = JSON.parse(load("/recommend=2022"));
    var poplist = JSON.parse(load("/genreRecommend=Pop"));
    var hiphoplist = JSON.parse(load("/genreRecommend=Hip Hop"));
    var rocklist = JSON.parse(load("/genreRecommend=Rock"));

    function recommendLoad() {
        var out = '';
        var list = ['rand', '2022', '2021', '2020']
        var listProperName = ['Random List', 'Songs in 2022', 'Songs in 2021', 'Songs in 2020']
        for(var i = 0; i < list.length; i++) {
            out += '<button onclick="showRecLists(' + "'" + list[i] + "'" + ')" class="dropbtn">' + listProperName[i] + '</button>'
        }
        document.getElementById("recommendPlaylist").innerHTML = out;
    }

    function genreLoad() {
        var out = '';
        var list = ['Pop', 'Hip Hop', 'Rock']
        for(var i = 0; i < list.length; i++) {
            out += '<button onclick="showGenreList(' + "'" + list[i] + "'" + ')" class="dropbtn">' + list[i] + '</button>'
        }
        document.getElementById("genrePlaylist").innerHTML = out;
    }

    function showGenreList(str) {
        var out = '';
        var songName = '';
        var recList = [];
        if (str == 'Pop') {recList = poplist;}
        else if (str == 'Hip Hop') {recList = hiphoplist;}
        else if (str == 'Rock') {recList = rocklist;}
    
        var musicIdList = "";
        var musicNameList = "";
        for(var i = 0; i < recList.length; i++) {
            musicIdList += recList[i].id + ";sep;";
            musicNameList += recList[i].artist.name + " - " + recList[i].name + ";sep;";
        }

        for(var i = 0; i < recList.length; i++) {
            songName = recList[i].artist.name + " - " + recList[i].name;
            out += '<a class="dropbtn" onclick="playAudio(' + recList[i].id + ',' + "'" + songName + "'" + '); audioHistory(' + "'" + musicIdList + "'" + ',' + "'" + musicNameList + "'" + ',' + i +')">' + songName + '</a>';
        }
        
        document.getElementById("myDropdown").innerHTML = out;
        listPop();
    }

    function showRecLists(str) {
        var out = '';
        var songName = '';
        var recList = [];
        if(str == 'rand') {recList = randomList;} 
        else if (str == '2020') {recList = list2020;}
        else if (str == '2021') {recList = list2021;}
        else if (str == '2022') {recList = list2022;}

        var musicIdList = "";
        var musicNameList = "";
        for(var i = 0; i < recList.length; i++) {
            musicIdList += recList[i].id + ";sep;";
            musicNameList += recList[i].artist.name + " - " + recList[i].name + ";sep;";
        }

        for(var i = 0; i < recList.length; i++) {
            songName = recList[i].artist.name + " - " + recList[i].name;
            out += '<a class="dropbtn" onclick="playAudio(' + recList[i].id + ',' + "'" + songName + "'" + '); audioHistory(' + "'" + musicIdList + "'" + ',' + "'" + musicNameList + "'" + ',' + i +')">' + songName + '</a>';
        }
        
        document.getElementById("myDropdown").innerHTML = out;
        listPop();
    }

    function yourPlaylistLoad() {
        var out = '';
        var playlist = JSON.parse(load("/library_playlist"));
        if(playlist.length != 0) {
            for(var i = 0; i < playlist.length; i++) {
                out += '<button onclick="showlists(' + playlist[i].id + ')" class="dropbtn">' + playlist[i].name + '</button>'
            }
        }
        else {
            out = "<a>You don't have any playlist yet.</a>"
        }
        document.getElementById("yourPlaylist").innerHTML = out;
    }

function searchPage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/search", false);
    xhttp.send();
    page();
    document.getElementById("searchPageId").style.color = "Pink";
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
                        out += '<a onclick="playAudio(' + music[i].id + ',' + "'" + songName + "'" + '); resetHistory();">' + songName + '</a>';
                    }
                }
                else {
                    out += '<a>No music results found.</a>';
                }
                out += "</div>";

                out += "<div class='scrollmenu'>";
                if(album.length > 0) {
                    for(var i = 0; i < album.length; i++) {
                        out += '<a class="dropbtn" onclick="showAlbum(' + album[i].id + ')">' + album[i].name + " (" + album[i].artist.name + ")";
                    }
                }
                else {
                    out += '<a>No album results found.</a>';
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
        var musicIdList = "";
        var musicNameList = "";
        for(var i = 0; i < albumList.length; i++) {
            musicIdList += albumList[i].music.id + ";sep;";
            musicNameList += albumList[i].music.artist.name + " - " + albumList[i].music.name + ";sep;";
        }

        for(var i = 0; i < albumList.length; i++) {
            songName = albumList[i].music.artist.name + " - " + albumList[i].music.name;
            out += '<a class="dropbtn" onclick="playAudio(' + albumList[i].music.id + ',' + "'" + songName + "'" + '); audioHistory(' + "'" + musicIdList + "'" + ',' + "'" + musicNameList + "'" + ',' + i +')">' + songName + '</a>';
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
    page();
    document.getElementById("libraryPageId").style.color = "Pink";
    playlists();
}

    function favList() {
        var out = '';
        var songName = '';
        var favList = JSON.parse(load("/library_fav"));

        if(favList.length > 0) {
            var musicIdList = "";
            var musicNameList = "";
            for(var i = 0; i < favList.length; i++) {
                musicIdList += favList[i].music.id + ";sep;";
                musicNameList += favList[i].music.artist.name + " - " + favList[i].music.name + ";sep;";
            }

            for(var i = 0; i < favList.length; i++) {
                songName = favList[i].music.artist.name + " - " + favList[i].music.name;
                out += '<a class="dropbtn" onclick="playAudio(' + favList[i].music.id + ',' + "'" + songName + "'" +'); audioHistory(' + "'" + musicIdList + "'" + ',' + "'" + musicNameList + "'" + ',' + i +')">' + songName + '</a>';
                out += '<a class="dropbtn" onclick="deleteFav(' + favList[i].music.id + ')"> >>Unlike<< </a>';
            }
        }
        else {
            out += "<a>Songs you like will appear here</a>";
        }
        document.getElementById("myDropdown").innerHTML = out;
        listPop();
    }

    function deleteFav(id) {
        load("/delFavorite=" + id);
        listPop();
        document.getElementById("bg").classList.remove("bgLock");
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
            var musicIdList = "";
            var musicNameList = "";
            for(var i = 0; i < list.length; i++) {
                musicIdList += list[i].music.id + ";sep;";
                musicNameList += list[i].music.artist.name + " - " + list[i].music.name + ";sep;";
            }

            for(var i = 0; i < list.length; i++) {
                songName = list[i].music.artist.name + " - " + list[i].music.name;
                out += '<a class="dropbtn" onclick="playAudio(' + list[i].music.id + ',' + "'" + songName + "'" + '); audioHistory(' + "'" + musicIdList + "'" + ',' + "'" + musicNameList + "'" + ',' + i +')">' + songName + '</a>';
                out += '<a class="dropbtn" onclick="deleteListMusic(' + id + ',' + list[i].music.id + ')"> >>Remove<< </a>';            }
        }
        else {
            out += '<a>No music in this playlist.</a>';
        }
        
        document.getElementById("myDropdown").innerHTML = out;
        listPop();
    }

    function deleteListMusic(playlistID, musicID) {
        load("/delMusicFromPlaylist=" + playlistID + "&" + musicID);
        listPop();
        document.getElementById("bg").classList.remove("bgLock");
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
    page();
    document.getElementById("accountPageId").style.color = "Pink";
}

var songHistoryName = [];
var songHistory = [];
var historyIndex;

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

function playAudio(musicID, musicName) {
    var src = "assets/musics/" + musicID + ".wav";
    audioControl(src, musicID, musicName);
}

function playPrev() {
    historyIndex--;
    if(songHistory.length > 1 && historyIndex > 0) {
        document.getElementById("prevSong").innerHTML = '<button onclick="playPrev()"> << </button>';
    }
    else {
        document.getElementById("prevSong").innerHTML = '<button class="transparent"> << </button>';
    }

    var musicName = songHistoryName[historyIndex];
    var musicID = songHistory[historyIndex];
    var src = "assets/musics/" + musicID + ".wav";

    audioControl(src, musicID, musicName);
}

function playNext() {
    historyIndex++;
    if(songHistory.length - 1 > historyIndex) {
        document.getElementById("nextSong").innerHTML = '<button onclick="playNext()"> >> </button>';
    }
    else {
        document.getElementById("nextSong").innerHTML = '<button class="transparent"> >> </button>';
    }
    
    var musicName = songHistoryName[historyIndex];
    var musicID = songHistory[historyIndex];
    var src = "assets/musics/" + musicID + ".wav";

    audioControl(src, musicID, musicName);
}

function audioControl(src, musicID, musicName) {
    // like
    checklike(musicID);

    // element
    document.getElementById("songName").innerHTML = musicName;
    document.getElementById("add2PlaylistButton").value = musicID;
    document.getElementById("a2pl").classList.remove("transparent");

    // audio control
    var audio = document.getElementById("audio");
    audio.src = src;
    audio.value = musicID;
    audio.volume = 0.75;
    audio.play();
    audio.addEventListener("ended", function() {
        if(songHistory.length - 1 > historyIndex) {
            playNext();
        }
    });

    // update history
    updateHistory();
}

function audioHistory(musicId, musicName, index) {
    var musicIdList = musicId.split(';sep;');
    var musicNameList = musicName.split(';sep;');
    musicIdList.pop();
    musicNameList.pop();

    songHistoryName = musicNameList
    songHistory = musicIdList
    historyIndex = index;

    updateHistory();
}

function resetHistory() {
    songHistory = [];
    songHistoryName = [];
    historyIndex = 0;
    updateHistory();
}