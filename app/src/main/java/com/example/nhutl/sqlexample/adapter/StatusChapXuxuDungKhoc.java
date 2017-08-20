package com.example.nhutl.sqlexample.adapter;

import android.content.Context;
import android.content.SharedPreferences;

public class StatusChapXuxuDungKhoc {
	private SharedPreferences sharedPreferences;
	private SharedPreferences.Editor editor;
	public static String save_state = "save_state";
	public static String SIZE = "Size";
	public static String STATUS = "Status";
	public static String HEIGHT = "Height";
	public static String ID = "Id";
	public static String POSITION = "Position";
	public static String FLAG = "Flag";
	
	
	public StatusChapXuxuDungKhoc(Context context) {
		
		sharedPreferences = context.getSharedPreferences(save_state, Context.MODE_PRIVATE);
		editor = sharedPreferences.edit();
	}
	public float getStatus(){
		return sharedPreferences.getFloat(STATUS, 0);
	}
	public void setStatus(float status){
		editor.putFloat(STATUS, status);
		editor.commit();
	}
	public int  getHeight(){
		return sharedPreferences.getInt(HEIGHT, 0);
	}
	public void setHeight(int height){
		editor.putInt(HEIGHT, height);
		editor.commit();
	}
	public int  getSize(){
		return sharedPreferences.getInt(SIZE, 0);
	}
	public void setSize(int size){
		editor.putInt(SIZE, size);
		editor.commit();
	}
//	public int  getId(){
//		return sharedPreferences.getInt(SIZE, 0);
//	}
//	public void setId(int idchap){
//		editor.putFloat(SIZE, idchap);
//		editor.commit();
//	}
	public int  getPosition(){
		return sharedPreferences.getInt(POSITION, 0);
	}
	public void setPosition(int position){
		editor.putInt(POSITION, position);
		editor.commit();
	}
	public int  getFlag(){
		return sharedPreferences.getInt(FLAG, 0);
	}
	public void setFlag(int flag){
		editor.putInt(FLAG, flag);
		editor.commit();
	}

}
