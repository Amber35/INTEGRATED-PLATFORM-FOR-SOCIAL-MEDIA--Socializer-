package com.socializer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Google_plus extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gp);
		WebView gp=(WebView)findViewById(R.id.gplus);
	gp.getSettings().setJavaScriptEnabled(true);
		gp.setWebViewClient(new WebViewClient());
		gp.loadUrl("http:/plus.google.com");
	}
	 public void showgp(View view) {
		 Intent i = new Intent(Google_plus.this, Google_plus.class);
			startActivity(i);
	 }
	 public void showfb(View view) {
		 Intent i = new Intent(Google_plus.this, Facebook.class);
			startActivity(i);
	 }
	 public void showtt(View view) {
		 Intent i = new Intent(Google_plus.this, Twitter.class);
			startActivity(i);
	 }
}