package com.example.myproject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class signin_page extends ActionBarActivity {
	EditText user,addr,no,mail,pass;
	Button b;
	String user1,addr1,no1,mail1,pass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_page);
        user=(EditText)findViewById(R.id.editText1);
        addr=(EditText)findViewById(R.id.editText2);
        no=(EditText)findViewById(R.id.editText3);
        mail=(EditText)findViewById(R.id.editText4);
        pass=(EditText)findViewById(R.id.editText5);
        b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				user1=user.getText().toString();
				addr1=addr.getText().toString();
				no1=no.getText().toString();
				mail1=mail.getText().toString();
				pass1=pass.getText().toString();
				try
				{
					user1=URLEncoder.encode(user1,"UTF-8");
					addr1=URLEncoder.encode(addr1,"UTF-8");
					no1=URLEncoder.encode(no1,"UTF-8");
					mail1=URLEncoder.encode(mail1,"UTF-8");
					pass1=URLEncoder.encode(pass1,"UTF-8");
					String url="http://10.100.9.156/udetails.php?Name="
							+ user1.trim() + "&Address="
							+ addr1.trim() + "&Contactno=" + no1.trim() + "&Mailid=" + mail1.trim() + "&Password=" + pass1.trim();
					System.out.println(url);
					pass_value_to_db get = new pass_value_to_db();
					get.execute(new String[] { url });
					Toast.makeText(getApplicationContext(),"Register Sucessful", Toast.LENGTH_LONG).show();
					Intent i=new Intent(signin_page.this,MainActivity.class);
					startActivity(i);

				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

     
    }
    private class pass_value_to_db extends AsyncTask<String, Void, String>{
    	ProgressDialog dialog;


		@Override
		protected void onPreExecute() { //  TODO Auto-generated method stub
			dialog = new ProgressDialog(signin_page.this);
			dialog.setTitle("Processing...");
			dialog.setMessage("Please wait.");
			dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected String doInBackground(String... urls) {
			String result = "";
			for (String url : urls) {
				InputStream is = null;
				try {

					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost(url);
					HttpResponse response = httpclient.execute(httppost);
					int status = response.getStatusLine().getStatusCode();
					Log.d("KG", "status=" + status);

					if (status == 200) {
						HttpEntity entity = response.getEntity();
						is = entity.getContent();
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(is, "iso-8859-1"), 8);
						String line = "";
						while ((line = reader.readLine()) != null) {
							result += line;
						}
						is.close();

						Log.v("KG", result);

					}
				} catch (Exception ex) {
					Log.e("Error", ex.toString());
				}
			}
			return result;
		}

		protected void onPostExecute(String result) {
			Log.v("KG", "output=" + result);
			result = result.trim(); //
			// Toast.makeText(getApplicationContext(), result, //
			// Toast.LENGTH_LONG).show();
			if (result.equals("false")) {

				// *******************************************************

				Toast.makeText(getApplicationContext(),
						" Please try again later...", Toast.LENGTH_LONG).show();
			} else {
				System.out.println(result);

			}

			if (dialog != null)
				dialog.dismiss();

		}
	}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}

}

	
	



