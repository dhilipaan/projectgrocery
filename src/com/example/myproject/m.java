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

public class m extends Activity{
	ListView list;
	String[] itemname ={
			("Fair&Handsome"),
			("Axe"),
			("Nivea facewash"),
			("Gillete razor"),
            ("Trimmer")
};
	
	
	Integer[] itemimg={
			R.drawable.men1,
			R.drawable.men2,
			R.drawable.men3,
			R.drawable.men4,
			R.drawable.men5
	};
	String[] price={
			"79",
			"210",
			"78",
			"99",
			"1250"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.m);
		
		m_adapt adapter=new m_adapt(this, itemname, itemimg,price);
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
	    
	