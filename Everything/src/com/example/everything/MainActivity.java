package com.example.everything;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {
	
	GridView gv;
	ArrayList<Person> list = new ArrayList<Person>();
	GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.gv = (GridView) this.findViewById(R.id.gridView1);
        this.list.add(new Person (R.drawable.img1, "Alpha","BSIT"));
        this.list.add(new Person (R.drawable.img2, "Bravo","BSOA"));
        this.list.add(new Person (R.drawable.img3, "Charlie","BSHRM"));
        this.list.add(new Person (R.drawable.img4, "Delta","BSCREAM"));
        this.list.add(new Person (R.drawable.img5, "Echo","BA"));
        this.list.add(new Person (R.drawable.img6, "Froxtrot","BSBA"));
        this.list.add(new Person (R.drawable.img7, "Golf","AB"));
        this.list.add(new Person (R.drawable.img8, "Hotel","BEED"));
        this.list.add(new Person (R.drawable.img9, "India","BSCPE"));
        this.list.add(new Person (R.drawable.img10, "J","BSCS"));
        this.list.add(new Person (R.drawable.img11, "Kilo","BSEE"));
        this.list.add(new Person (R.drawable.img12, "Lima","BSECE"));
        
        this.adapter = new GridAdapter(this,list);
        this.gv.setAdapter(adapter);
        
        this.gv.setOnItemClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
		ImageView iv = new ImageView(this);
    		iv.setImageResource(list.get(arg2).getImage());
    	TextView tv = new TextView(this);
    		tv.setText(list.get(arg2).getCourse());
    		tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
    		
    	LinearLayout layout = new LinearLayout(this);
    		layout.setOrientation(LinearLayout.HORIZONTAL);
    		layout.addView(iv);
    		layout.addView(tv);
    		
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setTitle(list.get(arg2).getName());
    		builder.setView(layout);
    		builder.setNeutralButton("OKEY", null);
    		
    	AlertDialog dialog = builder.create();
    		dialog.show();
		
	}
    
}
