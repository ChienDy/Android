package com.example.chatroom;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity  implements OnClickListener{
	String url1 = "http://172.19.131.99/chatroom/posting.php";
	EditText txtchat ;
	EditText txtname;
	Button btnsend;
	WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        wv=(WebView) this.findViewById(R.id.webView1);
        wv.loadUrl(url1);

        txtname=(EditText) this.findViewById(R.id.editText2);
        txtchat=(EditText) this.findViewById(R.id.editText1);
        btnsend=(Button) this.findViewById(R.id.button1);
        
        
        
		
        //allow a thread to run along side the android app
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        
       btnsend.setOnClickListener(this);
        
        
    }
	@Override
	public void onClick(View arg0) {
		int i = arg0.getId();
		switch(i){
		case R.id.button1:
			String send= this.txtchat.getText().toString();
			String name= this.txtname.getText().toString();
			send = send.replaceAll(" ", "%20");
			if(!send.equals("")){
				URL url;
				try {
					url = new URL("http://172.19.131.99/chatroom/sendmessage.php?name="+name + "&message="+send);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					InputStream is = conn.getInputStream();
					StringBuffer sb=new StringBuffer();
					char ch ='\u0000';
					int n = 0;
					while(n!=-1){
						n=is.read();
						ch=(char)n;
						sb.append(ch);
					}
					is.close();
					conn.disconnect();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			break;
		}
		
		
	}


    
}
