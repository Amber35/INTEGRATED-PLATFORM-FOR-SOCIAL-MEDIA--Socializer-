package com.test2;

import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Facebook fb;
	ImageView pic, button;
	SharedPreferences sp;
	TextView welcome,post;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String APP_ID = getString(R.string.APP_ID);
		fb = new Facebook(APP_ID);
		//pic = (ImageView) findViewById(R.id.picture_pic);
		button = (ImageView) findViewById(R.id.login);
		welcome = (TextView) findViewById(R.id.welcome);
	post = (TextView) findViewById(R.id.post);

		sp = getPreferences(MODE_PRIVATE);
		String access_token = sp.getString("access_token", null);
		long expires = sp.getLong("access_expires", 0);
		if (access_token != null) {
			fb.setAccessToken("access_token");
		}
		if (expires != 0) {
			fb.setAccessExpires(expires);
		}
		button.setOnClickListener(this);
		updateButtonImage();
	}

	private void updateButtonImage() {
		// TODO Auto-generated method stub
		if (fb.isSessionValid()) {
			button.setImageResource(R.drawable.logout_button);
			pic.setVisibility(ImageView.VISIBLE);
			JSONObject obj, obj1 = null;
			//JSONArray feed = null;

			//URL img_url = null;

			try {
				String JSONUser = fb.request("me");
				obj = Util.parseJson(JSONUser);
				//String id = obj.optString("id");
				//String name = obj.optString("name");
				String newsfeed = fb.request("me/home");
				obj1 = Util.parseJson(newsfeed);
				//feed=obj1.getJSONArray("data");	
				//JSONObject jsonObject = feed.getJSONObject(1);
				welcome.setText("welcome," + obj.optString("name"));
				//JSONObject jo=jsonObject.getJSONObject("from");
				
				
				//post.setText(jo.optString("name"));
				//img_url = new URL("http://graph.facebook.com/" + id
					//	+ "/picture?type=normal");
				//Bitmap bmp = BitmapFactory.decodeStream(img_url
					//	.openConnection().getInputStream());
				//pic.setImageBitmap(bmp);
				//welcome.setText("welcome," + newsfeed);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FacebookError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			button.setImageResource(R.drawable.login_button);
			welcome.setText("");

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (fb.isSessionValid()) {
			// logout
			try {
				fb.logout(getApplicationContext());
				updateButtonImage();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// login
			fb.authorize(MainActivity.this, new String[] { "read_stream" },
					new DialogListener() {

						@Override
						public void onFacebookError(FacebookError e) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this, "on fb error",
									Toast.LENGTH_SHORT).show();
						}

						@Override
						public void onError(DialogError e) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,
									"on dialog error", Toast.LENGTH_SHORT)
									.show();
						}

						@Override
						public void onComplete(Bundle values) {
							// TODO Auto-generated method stub
							Editor editor = sp.edit();
							editor.putString("access_token",
									fb.getAccessToken());
							editor.putLong("access_expires",
									fb.getAccessExpires());
							editor.commit();
							updateButtonImage();
						}

						@Override
						public void onCancel() {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this, "on cancel",
									Toast.LENGTH_SHORT).show();
						}
					});
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		fb.authorizeCallback(requestCode, resultCode, data);
	}

}
