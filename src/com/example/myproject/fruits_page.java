package com.example.myproject;



import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class fruits_page extends Activity{
	ListView list;
	String[] itemname ={
			("APPLE"),
			("BANANA"),
			("MANGO"),
			("ORANGE"),

};
	
	
	Integer[] itemimg={
			R.drawable.apple,
			R.drawable.banana,
			R.drawable.mango,
			R.drawable.orange,
			
	};
	String[] price={
			"10",
			"20",
			"30",
			"40",
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fruits_page);
		
		fruits_adapter adapter=new fruits_adapter(this, itemname, itemimg,price);
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
	    
	