var exec = require('cordova/exec');

exports.coolMethod = function (options, success, error) {
    var arg0;
    if (options) {
        arg0 = [options.message, options.position];
    } else {
        arg0 = [];
    }
    exec(success, error, 'PluginDemoToast', 'coolMethod', arg0);
};
