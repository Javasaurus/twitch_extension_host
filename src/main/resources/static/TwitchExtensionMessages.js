var port = 9754;
var ip = 'localhost';

var stompClient = null;
var target = 'incoming';
var websocket_address = 'http://' + ip + ':' + port + '/extension_socket';

window.onload = connect;
window.onunload = disconnect;

function setConnected(connected) {
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS(websocket_address);
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/' + target, function (extensionMessage) {
        showResponse(JSON.parse(extensionMessage.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessageToServer() {
    stompClient.send("/extension/" + target, {}, JSON.stringify(
            {
                'text': $("#request").val(),
                'userID': "DrJavaSaurus"}
    ));
}

function showResponse(message) {
       $("#greetings").html(message);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#send").click(function () {
        sendMessageToServer();
    });
});