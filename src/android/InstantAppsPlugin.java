package com.cordova.plugin.instantapps;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;

import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.app.Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.instantapps.InstantApps;

/**
 * This class echoes a string called from JavaScript.
 */
public class InstantAppsPlugin extends CordovaPlugin {
	
	/**
	* Called when initializing the plugin
	*
	* @param cordova TODO
	* @param webView TODO
	*/
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
	}
	
	/**
	* Called when executing an action from the JS code
	*
	* @param action A string naming the action
	* @param args JSON array containing all the arguments the action was called with
	* @param callbackContext TODO
	* @return true if success, false otherwise
	*/
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
		if(action.equals("showInstallPrompt")) {
			// TODO
			//PackageManager packageManager = context.getPackageManager();
			//Intent postInstallIntent = packageManager.getLaunchIntentForPackage(context.getPackageName());
			//Intent postInstallIntent = new Intent(cordova.getActivity().getApplicationContext(), Intent.ACTION_MAIN); //args.getString(0);
			Intent postInstallIntent = new Intent("android.intent.action.MAIN");
			int requestCode = 7; //args.getInt(1);
			String referrer = "InstantApps"; //args.getString(2);
			return this.showInstallPrompt(postInstallIntent, requestCode, referrer, callbackContext);
		}
		
        return false;
    }
	
	/**
	* Opens a full app installation dialog
	*
	* @param postInstallIntent TODO
	* @param requestCode An integer value containing the request code
	* @param referrer A string containing the referrer
	* @param callbackContext TODO
	* @return true if success, false otherwise
	*/
	private boolean showInstallPrompt(Intent postInstallIntent, int requestCode, String referrer, CallbackContext callbackContext) {
		if(InstantApps.showInstallPrompt(cordova.getActivity(), postInstallIntent, requestCode, referrer))
		{
			callbackContext.success();
			return true;
		}
		else
		{
			callbackContext.error("Something went wrong!");
			return false;
		}
	}

	/*
    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0)
            callbackContext.success(message);
    }
	*/
}
