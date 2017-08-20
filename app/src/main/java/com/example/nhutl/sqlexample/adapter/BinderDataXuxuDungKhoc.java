package com.example.nhutl.sqlexample.adapter;

import com.example.nhutl.sqlexample.R;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BinderDataXuxuDungKhoc extends BaseAdapter {

	// XML node keys
    static final String KEY_TAG = "list-truyen"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_NAMES = "name";
    
    static final String KEY_ICON = "icon";
	
	LayoutInflater inflater;
	ImageView thumb_image;
	List<HashMap<String,String>> list_truyenDataCollection;
	ViewHolder holder;
	public BinderDataXuxuDungKhoc() {
		// TODO Auto-generated constructor stub
	}
	
	public BinderDataXuxuDungKhoc(Activity act, List<HashMap<String,String>> map) {
		
		this.list_truyenDataCollection = map;
		
		inflater = (LayoutInflater) act
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
//		return idlist.size();
		return list_truyenDataCollection.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 
		View vi=convertView;
	    if(convertView==null){
	     
	      vi = inflater.inflate(R.layout.list_row_product, null);
	      holder = new ViewHolder();
	     
	      holder.tvname = (TextView)vi.findViewById(R.id.tvname); // city name
	     
	      holder.tvWeatherImage =(ImageView)vi.findViewById(R.id.list_image); // thumb image
	 
	      vi.setTag(holder);
	    }
	    else{
	    	
	    	holder = (ViewHolder)vi.getTag();
	    }

	      // Setting all values in listview
	      
	      holder.tvname.setText(list_truyenDataCollection.get(position).get(KEY_NAMES));
	      
	      
	      //Setting an image
	      String uri = "drawable/"+ list_truyenDataCollection.get(position).get(KEY_ICON);
	      int imageResource = vi.getContext().getApplicationContext().getResources().getIdentifier(uri, null, vi.getContext().getApplicationContext().getPackageName());
	      Drawable image = vi.getContext().getResources().getDrawable(imageResource);
	      holder.tvWeatherImage.setImageDrawable(image);
	      
	      return vi;
	}
	
	/*
	 * 
	 * */
	static class ViewHolder{
		
		public TextView tvname;
		
		ImageView tvWeatherImage;
	}
	
}
