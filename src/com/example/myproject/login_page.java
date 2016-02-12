package com.example.myproject;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class login_page extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.login_page);
		TabHost tb_host = getTabHost();
		TabSpec fruits = tb_host.newTabSpec("FRUITS");
		fruits.setIndicator("FRUITS",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent i = new Intent(this, fruits_page.class);
		fruits.setContent(i);
		//startActivity(i);
		TabSpec vege = tb_host.newTabSpec("VEGETABLES");
		vege.setIndicator(
				"VEGETABLES",
				getResources().getDrawable(
						R.drawable.abc_ab_stacked_transparent_dark_holo));
		Intent i1 = new Intent(this, vege_page.class);
		vege.setContent(i1);
		//startActivity(i1);
		TabSpec grocery = tb_host.newTabSpec("GROCERIES");
		grocery.setIndicator("GROCERIES",
		getResources().getDrawable(R.drawable.abc_ab_solid_light_holo));
		Intent i2 = new Intent(this, grocery_page.class);
		grocery.setContent(i2);
		TabSpec mens = tb_host.newTabSpec("MENS");
		mens.setIndicator("MENS",
		getResources().getDrawable(R.drawable.abc_ab_solid_light_holo));
		Intent i3 = new Intent(this, m.class);
		mens.setContent(i3);
		//startActivity(i2);
		TabSpec women = tb_host.newTabSpec("WOMEN");
		women.setIndicator("WOMEN",
		getResources().getDrawable(R.drawable.abc_ab_solid_light_holo));
		Intent i4 = new Intent(this, w.class);
		women.setContent(i4);
		tb_host.addTab(fruits);
		tb_host.addTab(vege);
		tb_host.addTab(grocery);
		tb_host.addTab(mens);
		tb_host.addTab(women);

	}

}
