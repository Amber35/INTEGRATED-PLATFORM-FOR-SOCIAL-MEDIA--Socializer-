package com.socializer;

import java.security.PublicKey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				}

	 public void showgp(View view) {
		 Intent i = new Intent(MainActivity.this, Google_plus.class);
			startActivity(i);
	 }
	 public void showfb(View view) {
		 Intent i = new Intent(MainActivity.this, Facebook.class);
			startActivity(i);
	 }
	 public void showtt(View view) {
		 Intent i = new Intent(MainActivity.this, Twitter.class);
			startActivity(i);
	 }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}





}
