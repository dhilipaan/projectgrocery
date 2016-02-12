package com.example.myproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class grocery_page extends Activity{
	ListView list;
	String[] itemname ={
			("Rice"),
			("Pickle"),
			("Chilli Powder"),
			("Turmeric Powder"),
			("Salt"),
			("Bru")

};
	
	
	Integer[] itemimg={
			R.drawable.e1,
			R.drawable.e2,
			R.drawable.e3,
			R.drawable.e4,
			R.drawable.e5,
			R.drawable.e6
			
	};
	String[] price={
			"50",
			"99",
			"49",
			"49",
			"25",
			"10"
	};
	@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.grocery_page);
			grocery_adapter adapter=new grocery_adapter(this, itemname, itemimg,price);
			list=(ListView)findViewById(R.id.listView1);
			list.setAdapter(adapter);
			
			list.setOnItemClickListener(new OnItemClickListener() {
	 
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					String Slecteditem= itemname[+position];
					Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
					
					
				}
			});
		}
		
	}

		       // listView.setOnItemClickListener(new OnItemClickListener() {

		             // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		                
		               
		               //Intent i = null;
		              /* switch (position) {
					case 0:
		           Intent i=new Intent(MainActivity.this,restaurant.class);
		           startActivity(i);
					case 1:
						Intent i1=new Intent(MainActivity.this,restaurant1.class);
						 startActivity(i1);
		            break;

					
					}
		             
		              
		              */
		             
		             // }

		         //}); 
		    
		