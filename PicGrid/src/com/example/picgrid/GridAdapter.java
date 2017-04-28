package com.example.picgrid;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
	
	Context contex;
	ArrayList<Person> list;
	
	

	public GridAdapter(Context contex, ArrayList<Person> list) {
		super();
		this.contex = contex;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		ImageView iv = new ImageView(contex);
			iv.setImageURI(list.get(arg0).getImageUri());
		return iv;
	}

}
