var Utils = require('./Utils')

function showInstallPrompt(/*String postInstallIntent, int requestCode, String referrer*/) {
	return Utils.exec('showInstallPrompt', [/*postInstallIntent , requestCode, referrer*/])
}

module.exports = {
	showInstallPrompt: showInstallPrompt,
};
