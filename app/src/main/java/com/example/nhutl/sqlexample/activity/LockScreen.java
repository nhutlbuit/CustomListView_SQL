package com.example.nhutl.sqlexample.activity;
import com.example.nhutl.sqlexample.R;
import com.example.nhutl.sqlexample.adapter.AdminReceiver;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LockScreen extends Activity implements OnClickListener {

	public static final int ADMIN_INTENT = 15;
	private static final String description = "Some Description About Your Admin";
	private DevicePolicyManager mDevicePolicyManager;
	private ComponentName mComponentName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lock);
		mDevicePolicyManager = (DevicePolicyManager)getSystemService(
				Context.DEVICE_POLICY_SERVICE);
		mComponentName = new ComponentName(this, AdminReceiver.class);
		Button btnEnableAdmin = (Button) findViewById(R.id.btnEnable);
		Button btnDisableAdmin = (Button) findViewById(R.id.btnDisable);
		Button rate = (Button) findViewById(R.id.btnRate);
		Button more = (Button) findViewById(R.id.btnMoreApp);
		btnEnableAdmin.setOnClickListener(this);
		btnDisableAdmin.setOnClickListener(this);
		rate.setOnClickListener(this);
		more.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btnEnable:
				Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
				intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mComponentName);
				intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,description);
				startActivityForResult(intent, ADMIN_INTENT);
				break;

			case R.id.btnDisable:
				mDevicePolicyManager.removeActiveAdmin(mComponentName);
				Toast.makeText(getApplicationContext(), "Admin registration removed", Toast.LENGTH_SHORT).show();
				break;
			case R.id.btnMoreApp:
				Intent intent1 = new Intent(Intent.ACTION_VIEW);
				intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=fart.lock"));
				startActivity(intent1);
				break;
			case R.id.btnRate:
				Intent intent2 = new Intent(Intent.ACTION_VIEW);
				intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=fart.lock"));
				startActivity(intent2);
				break;

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == ADMIN_INTENT) {
			if (resultCode == RESULT_OK) {
				Toast.makeText(getApplicationContext(), "Registered As Admin", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(getApplicationContext(), "Failed to register as Admin", Toast.LENGTH_SHORT).show();
			}
		}
	}

}