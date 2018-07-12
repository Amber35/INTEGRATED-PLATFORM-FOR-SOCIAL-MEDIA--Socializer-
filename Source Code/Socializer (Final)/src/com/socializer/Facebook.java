package com.socializer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Facebook extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fb);
		WebView fb=(WebView)findViewById(R.id.fbook);
		fb.getSettings().setJavaScriptEnabled(true);
		fb.setWebViewClient(new WebViewClient());
		fb.loadUrl("http://m.facebook.com");
	}
	 public void showgp(View view) {
		 Intent i = new Intent(Facebook.this, Google_plus.class);
			startActivity(i);
	 }
	 public void showfb(View view) {
		 Intent i = new Intent(Facebook.this, Facebook.class);
			startActivity(i);
	 }
	 public void showtt(View view) {
		 Intent i = new Intent(Facebook.this, Twitter.class);
			startActivity(i);
}
}