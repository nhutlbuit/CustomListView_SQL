package com.example.nhutl.sqlexample.activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.nhutl.sqlexample.R;

public class FlashLight extends AppCompatActivity {
	private boolean isLighOn = false;
	static Camera camera;
	private Button button;
    private ImageButton imgbtn;
	//public AdView adView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.led_light_flash);
	//	ads();
		button = (Button) findViewById(R.id.btn_on_off);
		imgbtn = (ImageButton) findViewById(R.id.img_btncolor);
		Context context = this;
		PackageManager pm = context.getPackageManager();

		// if device support camera?
		if (!checkCameraHardware(this)){
			AlertDialog alertDialog = new AlertDialog.Builder(context).create();
			alertDialog.setTitle("No Camera");
			alertDialog.setMessage("The device's doesn't support camera.");
			alertDialog.setButton(RESULT_OK, "OK", new DialogInterface.OnClickListener() {
				public void onClick(final DialogInterface dialog, final int which) {
					Log.e("err", "The device's doesn't support camera.");
				}
			});
			alertDialog.show();
		}

        if (isCameraInUse()){
            Toast.makeText(this, "Camera Busy! Camera is opened by another application", Toast.LENGTH_LONG).show();
            finish();
        } else {
            camera = null;
            camera = Camera.open();
            //noinspection deprecation
            final Camera.Parameters p = camera.getParameters();
            p.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(p);
            camera.startPreview();
            isLighOn = true;

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    if (isLighOn) {
                        p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(p);
                        camera.stopPreview();
                        isLighOn = false;
                    } else {
                        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(p);
                        camera.startPreview();
                        isLighOn = true;
                    }
                }
            });

            imgbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent intent = new Intent(FlashLight.this, Screen_colors.class);
                    startActivity(intent);
                }
            });
        }
	}
	/*public void ads(){
		adView = (AdView)this.findViewById(R.id.ad1);		 
		   adView.loadAd(new AdRequest());
	};*/
	@Override
	protected void onDestroy() {
	    if (camera != null) {
	        camera.release();
	    }
	    super.onDestroy();
	}
//	@Override
//    public void onBackPressed() {
//        super.onBackPressed();   
//            finish();
//
//    }

	/** Check if this device has a camera */
	private boolean checkCameraHardware(Context context) {
		if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
			// this device has a camera
			return true;
		} else {
			// no camera on this device
			return false;
		}
	}

    public boolean isCameraInUse() {
        Camera c = null;
        try {
            c = Camera.open();
        } catch (RuntimeException e) {
            return true;
        } finally {
            if (c != null) c.release();
        }
        return false;
    }
}