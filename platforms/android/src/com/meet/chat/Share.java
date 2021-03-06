package com.meet.chat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

public class Share extends CordovaPlugin {

	public boolean execute(String arg0, JSONArray args, CallbackContext callbackContext) {
		try {
			JSONObject jo = args.getJSONObject(0);
			doSendIntent(jo.getString("subject"), jo.getString("text")); 
			PluginResult res = new PluginResult(PluginResult.Status.OK);
			callbackContext.sendPluginResult(res);
			return true;
		} catch (JSONException e) {
			PluginResult res = new PluginResult(PluginResult.Status.JSON_EXCEPTION);
			callbackContext.sendPluginResult(res);
			return false;
		}
	}
	
	private void doSendIntent(String subject, String text) {
		Intent sendIntent = new Intent(android.content.Intent.ACTION_SEND);
		sendIntent.setType("text/plain");
		sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
		this.cordova.startActivityForResult(this, sendIntent, 0);
	}

}
