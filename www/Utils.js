var cordovaExec = require('cordova/exec');

function exec(method, args) {
	return new Promise((resolve, reject) => {
		cordovaExec(resolve, reject, 'InstantAppsPlugin', method, args)
	})
}

module.exports = {
	exec : exec,
};