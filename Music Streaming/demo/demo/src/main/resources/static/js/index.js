window.onload = function() {
    home()
  };

  
function home() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/home");
    xhttp.send();
}

function search() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/search");
    xhttp.send();
}

function library() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/library");
    xhttp.send();
}

function account() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("demo").innerHTML = this.response;
    }
    xhttp.open("GET", "/account");
    xhttp.send();
}