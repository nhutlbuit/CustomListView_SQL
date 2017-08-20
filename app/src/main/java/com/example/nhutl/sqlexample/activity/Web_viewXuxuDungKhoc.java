package com.example.nhutl.sqlexample.activity;

import com.example.nhutl.sqlexample.R;
import com.example.nhutl.sqlexample.adapter.StatusChapXuxuDungKhoc;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;
public class Web_viewXuxuDungKhoc extends Activity {
	
	static public WebView webView;
	private String url=null;
	private ImageButton btnLeft,btnMark,btnRight,btnPlus,btnSub;
	static public int position,maxCharp=84, fontSize=16, Flag=0;
	static public String path="file:///android_asset/", html=".html";;
	static StatusChapXuxuDungKhoc st;
	static public float scrollPercent;
	static final Handler mHandler = new Handler();
/*	public AdView adView;
	public StartAppAd startAppAd = new StartAppAd(this);*/
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setFullscreen();
        setContentView(R.layout.activity_web_view);
        intView();
        setwebView();
        getData();	
        intEvent(); 
       // ads();
       /* StartAppSDK.init(this, "101645817", "202360071", true);*/
	}
/*	public void ads(){
		adView = (AdView)this.findViewById(R.id.ad1);		 
		   adView.loadAd(new AdRequest());
	};*/
	public void setFullscreen(){
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	        WindowManager.LayoutParams.FLAG_FULLSCREEN);
	};
	public void setwebView(){
        webView.setWebViewClient(new MyWebViewClient());
        webView.setBackgroundColor(Color.parseColor("#BBBBBB"));
//        webView.getSettings().setSupportZoom(true);
//        webView.getSettings().setBuiltInZoomControls(true);
//        webView.getSettings().setDisplayZoomControls(true);
        
	};
	
	 public void intView(){
		 st = new StatusChapXuxuDungKhoc(this);
		btnRight = (ImageButton) findViewById(R.id.btnRight);
	    btnLeft = (ImageButton) findViewById(R.id.btnLeft);
	    btnMark = (ImageButton) findViewById(R.id.btnMark);
	    webView = (WebView) findViewById(R.id.webView);
	    btnPlus = (ImageButton) findViewById(R.id.btnPlus);
	    btnSub = (ImageButton) findViewById(R.id.btnSub);
     };
     public void  intEvent(){
    	btnLeft.setOnClickListener(new MyOnclick());
 		btnRight.setOnClickListener(new MyOnclick());
 		btnMark.setOnClickListener(new MyOnclick());
 		btnPlus.setOnClickListener(new MyOnclick());
 		btnSub.setOnClickListener(new MyOnclick()); 
     };
     public class  MyOnclick implements OnClickListener{

 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			switch (v.getId()) {
 			case R.id.btnLeft:
 				if(position>0){
 					position--;
 					webView.loadUrl(path+String.valueOf(position)+html);
 				}
 				break;
 			case R.id.btnRight:
 				
 				if(position < maxCharp-1){
 					position++;
 					webView.loadUrl(path+String.valueOf(position)+".html");
 				}
 				break;
 			
 			case R.id.btnMark:
 				saveStatus();
				int charp_number= position + 1;
 				Toast.makeText(Web_viewXuxuDungKhoc.this, "Chương "+charp_number+" đã được đánh dấu!", Toast.LENGTH_LONG).show();
 				break;
 			case R.id.btnSub:
				fontSizeMinus();
				break;
		
			case R.id.btnPlus:
				fontSizePlus();
				break;

 			default:
 				break;
 			}
 		}
 		
 	}
     
     public void getData(){
    	//reciver bundle from main_activity
	    	Intent intent = getIntent();
			Bundle bundle = intent.getBundleExtra("goi");
			Flag = bundle.getInt("Flag");
			webView.getSettings().setDefaultFontSize(fontSize);
			
	        
	        if (Flag == 0){
	        	position = bundle.getInt("position");
				url =path+position+html;
		        webView.loadUrl(url);
				
			 }
			

		 else{
			     fontSize = st.getSize();
		    	 webView.getSettings().setDefaultFontSize(st.getSize());
		    	 position=st.getPosition();
				 webView.loadUrl(path+position+html);
				 webView.setWebViewClient(new WebViewClient(){
				 @Override  
			     public void onPageFinished(WebView view, String url) {
			         
					 mHandler.postDelayed(new Runnable() {

			                @Override
			                public void run() {
			                    if (webView.getContentHeight() > 0) {
			                    	scrollPercent = st.getStatus();
			                    	 int contentHeight = st.getHeight();
			                    	    int y = (int) ((float) contentHeight * scrollPercent);
			                    	    webView.scrollTo(0, y);
			                        mHandler.removeCallbacks(this);
			                    } else {
			                        mHandler.postDelayed(this, 100);
			                    }
			                }
			            }, 100);
				 }

					});
		 }
     };
     private void fontSizePlus() {
 	    fontSize++;
 	    this.changeFontSize(fontSize);
 	}

 	 private void fontSizeMinus() {
 	    fontSize--;
 	    this.changeFontSize(fontSize);
 	}
     private void changeFontSize(int value) {
 		webView.getSettings().setDefaultFontSize(fontSize);
 	}     
			
     public void saveStatus(){
 		//st.setStatusMark(true);
 		int contentHeight = webView.getContentHeight();
 	    int scrollY = webView.getScrollY();
 	    scrollPercent = ((float) scrollY / ((float) contentHeight));
// 	    Flag=1;
//		st.setFlag(Flag);
 	    st.setPosition(position);
 	    st.setHeight(contentHeight);
 	    st.setStatus(scrollPercent);
 	    st.setSize(fontSize);
 	   
		 }
//	static public void savingPreferences(int position, Context context)
//	 {
//		
//		 //táº¡o Ä‘á»‘i tÆ°á»£ng getSharedPxreferences
//	   SharedPreferences pre=context.getSharedPreferences
//				 ("save_page", Context.MODE_PRIVATE);
//		 //táº¡o Ä‘á»‘i tÆ°á»£ng Editor Ä‘á»ƒ lÆ°u thay Ä‘á»•i
//		 SharedPreferences.Editor editor=pre.edit();		
//		 editor.putInt("position", position);
//		//cháº¥p nháº­n lÆ°u xuá»‘ng file
//		  editor.commit();
//		 }
//		 
//	 
//	static public int retorePreferences( Context context)
//	 {
//		
//		 //táº¡o Ä‘á»‘i tÆ°á»£ng getSharedPxreferences
//	   SharedPreferences pre=context.getSharedPreferences
//				 ("save_page", Context.MODE_PRIVATE);
//		
//		 
////		 //xÃ³a mï¿½?i lÆ°u trá»¯ trÆ°á»›c Ä‘Ã³
////		 editor.clear();
//		 			
//		int pos1 = pre.getInt("position", 0);
//		  return pos1;
//		
//		 }
	
	private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
;
/// set event for button back
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Builder b = new Builder(Web_viewXuxuDungKhoc.this);//
			b.setTitle("Lưu trang đang đọc!");
			b.setMessage("Bạn có muốn lưu trang đang đọc?");
			b.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
				//	savingPreferences(position,getBaseContext());
					saveStatus();
					finish();
				}
			});
			b.setNegativeButton("Không", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					//dialog.cancel();
					finish();
				}
			});
			b.show();
			return false;
		}
		return false;

	}
	
}

