var StatusBar = function() {};

StatusBar.prototype.goStatusBar = function(message, successCallback, errorCallback) {
        return cordova.exec(successCallback, errorCallback, 'StatusBar', 'goStatusBar', [message]);
 };

 var statusBar = new StatusBar();
 