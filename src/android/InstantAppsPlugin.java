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
	
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
	}
	
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
		if(action.equals("showInstallPrompt")) {
			Intent postInstallIntent = null; //new Intent(cordova.getActivity().getApplicationContext(), cordova.getActivity()); //args.getString(0);
			int requestCode = 7; //args.getInt(1);
			String referrer = "InstantApps"; //args.getString(2);
			return this.showInstallPrompt(postInstallIntent, requestCode, referrer, callbackContext);
		}
		
        return false;
    }
	
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
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
	*/
}
