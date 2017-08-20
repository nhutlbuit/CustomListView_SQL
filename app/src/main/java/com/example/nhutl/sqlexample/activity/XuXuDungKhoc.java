package com.example.nhutl.sqlexample.activity;
import com.example.nhutl.sqlexample.R;
import com.example.nhutl.sqlexample.adapter.BinderDataXuxuDungKhoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;


public class XuXuDungKhoc extends Activity {
	// XML node keys
    static final String KEY_TAG = "list_truyen"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_NAMES = "name";
    static final String KEY_ICON = "icon";
   private ImageButton  btn_load, btn_link, btn_ads;
   public int Flag=1;
/*   public AdView adView;
   public StartAppAd startAppAd = new StartAppAd(this);*/
    // List items 
    ListView list;
    BinderDataXuxuDungKhoc adapter = null;
    List<HashMap<String,String>> list_truyenDataCollection;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xuxu_dung_khoc);
        btn_load= (ImageButton) findViewById(R.id.btn_load);
        btn_link= (ImageButton) findViewById(R.id.btn_skyMoon);
 /*       btn_ads= (ImageButton) findViewById(R.id.btn_ads);
      ads();
      StartAppAd.showSplash(this, savedInstanceState,
				new SplashConfig()
					.setTheme(Theme.DEEP_BLUE)
					.setLogo(R.drawable.xuxu)
					.setAppName("Bạn đọc truyện vui nhé! Thông cảm vì quảng cáo nha hihi!")
      		);
      ads_slider();
      StartAppSDK.init(this, "101645817", "202360071", true);*/
        
		try {
			
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	        Document doc = docBuilder.parse (getAssets().open("list_truyen.xml"));

	        list_truyenDataCollection = new ArrayList<HashMap<String,String>>();
	        
	        // normalize text representation
            doc.getDocumentElement ().normalize ();
	                    
            NodeList truyen_List = doc.getElementsByTagName("list_truyen");
            
			HashMap<String,String> map = null;
			
			for (int i = 0; i < truyen_List.getLength(); i++) {
				 
				   map = new HashMap<String,String>(); 
				   
				   Node firsttruyenNode = truyen_List.item(i);
				   
	                if(firsttruyenNode.getNodeType() == Node.ELEMENT_NODE){

	                    Element firsttruyenElement = (Element)firsttruyenNode;
	                    //-------
	                    NodeList idList = firsttruyenElement.getElementsByTagName(KEY_ID);
	                    Element firstIdElement = (Element)idList.item(0);
	                    NodeList textIdList = firstIdElement.getChildNodes();
	                    //--id
	                    map.put(KEY_ID, textIdList.item(0).getNodeValue().trim());
	                    
	                    //2.-------key_name
	                    NodeList cityList = firsttruyenElement.getElementsByTagName(KEY_NAMES);
	                    Element firstCityElement = (Element)cityList.item(0);
	                    NodeList textCityList = firstCityElement.getChildNodes();
	                    //--city
	                    map.put(KEY_NAMES, textCityList.item(0).getNodeValue().trim());
	                    
	                    //--city
	                    map.put(KEY_NAMES, textCityList.item(0).getNodeValue().trim());
	                    
	                    
	                    //6.-------
	                    NodeList iconList = firsttruyenElement.getElementsByTagName(KEY_ICON);
	                    Element firstIconElement = (Element)iconList.item(0);
	                    NodeList textIconList = firstIconElement.getChildNodes();
	                    //--city
	                    map.put(KEY_ICON, textIconList.item(0).getNodeValue().trim());
	               
	                    //Add to the Arraylist
	                    list_truyenDataCollection.add(map);
				}		
			}
			
	
			BinderDataXuxuDungKhoc bindingData = new BinderDataXuxuDungKhoc(this,list_truyenDataCollection);

						
			list = (ListView) findViewById(R.id.list);

			Log.i("BEFORE", "<<------------- Before SetAdapter-------------->>");

			list.setAdapter(bindingData);

			Log.i("AFTER", "<<------------- After SetAdapter-------------->>");

			// Click event for single list row
			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					
						  Intent intent=new Intent(XuXuDungKhoc.this,Web_viewXuxuDungKhoc.class);
							Bundle bundle = new Bundle();
							bundle.putInt("position", position);
							intent.putExtra("goi", bundle);
							startActivityForResult(intent, 1);
					 


				}
			});
			btn_load.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				// flag = 1
				Intent intent1=new Intent(XuXuDungKhoc.this,Web_viewXuxuDungKhoc.class);
				Bundle bundle = new Bundle();
				bundle.putInt("Flag", Flag );
			
				intent1.putExtra("goi", bundle);
				startActivityForResult(intent1, 1);

				}
				
			}); 
btn_link.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				// flag = 1
					Intent intent = new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=truyen.xuxudungkhoc"));
					startActivity(intent);

				}
				
			}); 
	
/*btn_ads.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	// flag = 1
		
		if (connectionAvailable()) // << your method from above
		{

			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Flashlight+App+Inc"));
			startActivity(intent);
		}
		else
		{
		   Toast.makeText(XuXuDungKhoc.this, "Vui lòng kết nối mạng để tải ứng dụng của tớ nhé hihi", Toast.LENGTH_LONG).show();
		}
		
		

	}
	
}); */
			
			

		}
		
		
		catch (IOException ex) {
			Log.e("Error", ex.getMessage());
		}
		catch (Exception ex) {
			Log.e("Error", "Loading exception");
		}
		
    }
    
    private boolean connectionAvailable() {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        return connected;
    }
    
	/*public void ads_slider(){
		*//** Add Slider **//*
		StartAppAd.showSlider(this);
		
		
	};

    public void ads(){
		adView = (AdView)this.findViewById(R.id.ad1);		 
		   adView.loadAd(new AdRequest());
	};
   
	@Override
	public void onResume() {
		super.onResume();
		startAppAd.onResume();
	}
*/
	/**
	 * Part of the activity's life cycle, StartAppAd should be integrated here
	 * for the home button exit ad integration.
	 */
	/*@Override
	public void onPause() {
		super.onPause();
		startAppAd.onPause();
	}

	@Override
	public void onBackPressed() {
		startAppAd.onBackPressed();
		super.onBackPressed();
	}*/

}

