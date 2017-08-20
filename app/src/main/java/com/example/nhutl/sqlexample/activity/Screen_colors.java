package com.example.nhutl.sqlexample.activity;

import com.example.nhutl.sqlexample.R;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Screen_colors extends ActionBarActivity {

	Button btnRed, btnBlack, btnYellow, btnWhite, btnCyan, btnBlue, btnPink ;
	public RelativeLayout re_out;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setFullscreen();
		setContentView(R.layout.activity_screen_colors);
		intView();
		intEvent();
	}

	public void setFullscreen(){
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	        WindowManager.LayoutParams.FLAG_FULLSCREEN);
	};
	public void intView(){
		re_out= (RelativeLayout)findViewById(R.id.re_out);
		btnBlack = (Button) findViewById(R.id.btn_black);	
	 	btnRed = (Button) findViewById(R.id.btn_red);
	 	btnBlue = (Button) findViewById(R.id.btn_blue);
	 	btnYellow = (Button) findViewById(R.id.btn_yellow);
	 	btnCyan = (Button) findViewById(R.id.btn_cyan);
	 	btnWhite = (Button) findViewById(R.id.btn_white);
	 	btnPink = (Button) findViewById(R.id.btn_pink);
	};
	public void intEvent(){
		btnBlack.setOnClickListener(new MyOnclick());
		btnRed.setOnClickListener(new MyOnclick());
		btnBlue.setOnClickListener(new MyOnclick());
		btnYellow.setOnClickListener(new MyOnclick());
		btnCyan.setOnClickListener(new MyOnclick());
		btnWhite.setOnClickListener(new MyOnclick());
		btnPink.setOnClickListener(new MyOnclick());
	};
	public class  MyOnclick implements OnClickListener{

 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			switch (v.getId()) {
 			case R.id.btn_black:
 				re_out.setBackgroundColor(Color.BLACK);
				
 				break;
 			case R.id.btn_red:
 				re_out.setBackgroundColor(Color.RED);
				
 				break;
 			case R.id.btn_blue:
 				re_out.setBackgroundColor(Color.BLUE);
				
 				break;
 			case R.id.btn_cyan:
 				re_out.setBackgroundColor(Color.GREEN);
				
 				break;
 			case R.id.btn_yellow:
 				re_out.setBackgroundColor(Color.YELLOW);
				
 				break;
 			case R.id.btn_white:
 				re_out.setBackgroundColor(Color.WHITE);
				
 				break;
 			case R.id.btn_pink:
 	 				re_out.setBackgroundColor(Color.MAGENTA);
 					
 	 				break;
 			default:
 				break;
 			}
 		}
 		
 	}
}
