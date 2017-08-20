package com.example.nhutl.sqlexample.activity;

import com.example.nhutl.sqlexample.R;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/*import com.google.ads.AdRequest;
import com.google.ads.AdView;*/


public class Part extends ActionBarActivity {
	//public AdView adView;

    Button btn_dit, btn_ok, btn_5s, btn_10s;
    EditText edt;
    public TextView tv;
    public int time= 1000;
    public Spinner spin;
	public int fart, s =0, x;
	
    String arr[]={
    "Fart1",
    "Fart2",
    "Fart3",
    "Fart4",
    "Fart5",
    "Fart6",
    "Fart7",
    "Fart8",
    "Fart9",
    "Fart10",
    "Fart11",   
    "Fart12",};
    
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_part);
		intView();
		//ads();

		intEvent();
		sninper();
	}

	
/*public void ads(){
	adView = (AdView)this.findViewById(R.id.ad1);		 
	   adView.loadAd(new AdRequest());
};*/

	public void intView(){
		//btn_dit = (Button) findViewById(R.id.btn_dit);
		edt = (EditText) findViewById(R.id.edt);
		btn_ok = (Button) findViewById(R.id.btn_ok);
		btn_5s = (Button) findViewById(R.id.btn_dit2);
		btn_10s = (Button) findViewById(R.id.btn_dit3);
		spin=(Spinner) findViewById(R.id.spinner1);
		tv=(TextView) findViewById(R.id.txtVw);
		
		 
	};
	public void sninper(){
		
		 
		 //Gán Data source (arr) vào Adapter
		 ArrayAdapter<String> adapter=new ArrayAdapter<String>
		 (
		 this,android.R.layout.simple_spinner_item,arr);
		 //phải g�?i lệnh này để hiển thị danh sách cho Spinner
		 adapter.setDropDownViewResource
		 (android.R.layout.simple_list_item_single_choice);
		 spin.setPrompt("Select kinds of Fart!");
		 //Thiết lập adapter cho Spinner
		 spin.setAdapter(adapter);
		 //thiết lập sự kiện ch�?n phần tử cho Spinner
		 spin.setOnItemSelectedListener((OnItemSelectedListener) new MyProcessEvent());
		 }
	//Class tạo sự kiện
	 private class MyProcessEvent implements OnItemSelectedListener
	 {
	 //	 int iCurrentSelection = spin.getSelectedItemPosition();
	 //Khi có ch�?n lựa thì vào hàm này
	 public void onItemSelected(AdapterView<?> arg0,
	 View arg1,
	 int arg2,
	 long arg3) {
		
		 
	   /*switch (arg2) {
		 case 0:
			fart= R.drawable.fart1;
				break;
		 case 1:
			 fart= R.drawable.fart2;
             break;
         case 2:
        	 fart= R.drawable.fart3;
               
             break;
         
         case 3:
        	 fart= R.drawable.fart4;
               
             break;
         case 4:
        	 fart= R.drawable.fart5;
               
             break;
         case 5:
        	 fart= R.drawable.fart6;
               
             break;
         case 6:
        	 fart= R.drawable.fart7;
               
             break;
         case 7:
        	 fart= R.drawable.fart8;
               
             break;
         case 8:
        	 fart= R.drawable.fart9;
               
             break;
         case 9:
        	 fart= R.drawable.fart10;
               
             break;
         case 10:
        	 fart= R.drawable.fart11;
               
             break;
         case 11:
        	 fart= R.row.fart12;
               
             break;
			default:
				break;
			}*/
		}
	
	 //Nếu không ch�?n gì cả
	 @Override
	 public void onNothingSelected(AdapterView<?> arg0) {
	// selection.setText("");
		 
	 }

	
};

	
	public void intEvent(){
		//btn_dit.setOnClickListener(new MyOnclick());
		btn_ok.setOnClickListener(new MyOnclick());
		edt.setHint("15");		
		btn_5s.setOnClickListener(new MyOnclick());
		btn_10s.setOnClickListener(new MyOnclick());
	
		
	};
	public class  MyOnclick implements OnClickListener{

 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			switch (v.getId()) {
// 			case R.id.btn_dit:	
// 				MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.drawable.lythuyetdit);
// 				mp.start();
// 				break;
 			case R.id.btn_ok:
 				
 				String get=edt.getText().toString();
 				if((TextUtils.isEmpty(get))) {
            		
            		Builder b = new Builder(Part.this);//
        			b.setTitle("Notify!");
        			b.setMessage("please fill in time fart!");
        			b.setPositiveButton("Close", new DialogInterface.OnClickListener() {

        				@Override
        				public void onClick(DialogInterface dialog, int which) {
        				
        					
        					dialog.cancel();
        				}
        				
            	
        			});
        			b.show();
    				
            	}
            	else{
            		x=Integer.parseInt(get);
     				MyAsyncTask myAsyncTask2 = new MyAsyncTask();
                    myAsyncTask2.execute();
   
            		}
            	
 		

                break;
                
            case R.id.btn_dit2:
            	x=5;
            	MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
                break;
                
            case R.id.btn_dit3:           
            	x=10;
            	MyAsyncTask myAsyncTask1 = new MyAsyncTask();
                myAsyncTask1.execute();
                break;
                
 			default:
 				break;
 			}
 		}
 		
 	}
	
	
	
	public int delay(int t){
    	try {
				Thread.sleep(t);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return t;
    	
    };
    
    
    private class MyAsyncTask extends AsyncTask<Void, String, Void> {
    	 
        @Override
        protected Void doInBackground(Void... params) {
     
        	
        	for(int s=x;s>=0;--s){      		
        		delay(time);           		
        		publishProgress(""+s);        		         	
        	}
        	MediaPlayer mp1 = MediaPlayer.create(getBaseContext(), fart);
				mp1.start();    
            return null;
        }
     
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
     
        @Override
        protected void onProgressUpdate(String... values) {
     
            tv.setText(values[0]);
     
        }
     
        }  
    
}