package com.example.myproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;



public class w_adapt extends ArrayAdapter<String> {
	 
		private final Activity context;
		private final String[] itemname;
		private final Integer[] itemimg;
		private final String[] price;
			
				
		public w_adapt(Activity context, String[] itemname, Integer[] itemimg, String[] price) {
			super(context, R.layout.w_adapt, itemname);
			// TODO Auto-generated constructor stub
			
			this.context=context;
			this.itemname=itemname;
			this.itemimg=itemimg;
			this.price=price;
		}

		public View getView(int position,View view,ViewGroup parent) {
			LayoutInflater inflater=context.getLayoutInflater();
			View rowView=inflater.inflate(R.layout.w_adapt, null,true);
			
			TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
			ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1);
			 final TextView edittxt=(TextView)rowView.findViewById(R.id.textView3);
			 final TextView total=(TextView)rowView.findViewById(R.id.textView5);
			 final Spinner spin=(Spinner)rowView.findViewById(R.id.spinner1);
			Button btn=(Button)rowView.findViewById(R.id.button1);
			btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub\
					int value1=Integer.parseInt(edittxt.getText().toString());
					int value2=Integer.parseInt(spin.getSelectedItem().toString());
					int value3=value1*value2;
					total.setText(Integer.toString(value3));
					
				}
			});
			
			
			txtTitle.setText(itemname[position]);
			imageView.setImageResource(itemimg[position]);
			edittxt.setText(price[position]);
			
	
			
			return rowView;
			
		}


	}
