package com.example.nhutl.sqlexample.activity;

import com.example.nhutl.sqlexample.R;
import com.example.nhutl.sqlexample.adapter.AdminReceiver;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class PartOfLockScreen extends Activity {
	private DevicePolicyManager mDevicePolicyManager; 
	private ComponentName mComponentName; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setFullscreen();
		setContentView(R.layout.activity_phu);
		
		mDevicePolicyManager = (DevicePolicyManager)getSystemService(  
				Context.DEVICE_POLICY_SERVICE);
		mComponentName = new ComponentName(this, AdminReceiver.class);
		boolean isAdmin = mDevicePolicyManager.isAdminActive(mComponentName);  
		if (isAdmin) {  
			mDevicePolicyManager.lockNow(); 
			finish();
		}
		else{
			finish();
			Toast.makeText(getApplicationContext(), "Not Registered as admin", Toast.LENGTH_SHORT).show();
		}
			
		
	}
	public void setFullscreen(){
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	        WindowManager.LayoutParams.FLAG_FULLSCREEN);
	};

	
}
