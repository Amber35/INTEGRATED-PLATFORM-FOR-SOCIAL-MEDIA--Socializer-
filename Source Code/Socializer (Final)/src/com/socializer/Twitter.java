package com.socializer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Twitter extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tt);
		WebView tt=(WebView)findViewById(R.id.twitter);
		tt.getSettings().setJavaScriptEnabled(true);
	tt.setWebViewClient(new WebViewClient());
		tt.loadUrl("https://mobile.twitter.com/session/new");
	}
	 public void showgp(View view) {
		 Intent i = new Intent(Twitter.this, Google_plus.class);
			startActivity(i);
	 }
	 public void showfb(View view) {
		 Intent i = new Intent(Twitter.this, Facebook.class);
			startActivity(i);
	 }
	 public void showtt(View view) {
		 Intent i = new Intent(Twitter.this, Twitter.class);
			startActivity(i);
}
}
