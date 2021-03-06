package com.example.sakitprog;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	EditText txtuser,pwdpass;
	Button btnlogin,btncancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
    this.txtuser=(EditText) this.findViewById(R.id.editText1);
    this.pwdpass=(EditText) this.findViewById(R.id.editText2);
    
    this.btnlogin=(Button) this.findViewById(R.id.button1);
    this.btncancel=(Button) this.findViewById(R.id.button2);
    
    //allow a thread to run along side the android app
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);

    this.btnlogin.setOnClickListener(this);
    this.btncancel.setOnClickListener(this);
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		int id = arg0.getId();
		switch(id){
		case R.id.button1:

			String user = this.txtuser.getText().toString();
			String pass = this.pwdpass.getText().toString();
			if(!user.equals("")&&!pass.equals("")){
				try {
					URL url = new URL("http://172.19.131.115/summer/loginvalidation.php?username="+user+"&password="+pass);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					InputStream is = conn.getInputStream();
					StringBuffer sb = new StringBuffer();
					char ch ='\u0000';
					int n = 0;
					while(n!=-1){
						n=is.read();
						ch=(char)n;
						sb.append(ch);
					}
					is.close();
					conn.disconnect();
					
					Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
					
					/*AlertDialog.Builder builder = new AlertDialog.Builder(this);
						builder.setMessage(sb.toString());
						builder.setNeutralButton("OK",null);
					AlertDialog dialog = builder.create();
					dialog.show();*/
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}else{
				Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
				
			}
			break;
		case R.id.button2:
			this.txtuser.setText("");
			this.pwdpass.setText("");
			this.txtuser.requestFocus();
		
		}
		}
}