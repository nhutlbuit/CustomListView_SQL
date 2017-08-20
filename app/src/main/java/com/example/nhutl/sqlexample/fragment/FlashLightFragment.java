package com.example.nhutl.sqlexample.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nhutl.sqlexample.R;
import com.example.nhutl.sqlexample.activity.Screen_colors;

import static android.app.Activity.RESULT_OK;

public class FlashLightFragment extends Fragment {
    TextView tv;
    private boolean isLighOn = false;
    static Camera camera;
    private Button btnOnOff;
    private ImageButton imgbtnColor;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flash_light, container, false);
        btnOnOff = (Button) view.findViewById(R.id.btn_on_off);
        imgbtnColor = (ImageButton) view.findViewById(R.id.img_btncolor);
        context = getActivity();
        PackageManager pm = context.getPackageManager();

        // if device support camera?
        if (!checkCameraHardware(getActivity())){
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
            AlertDialog alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Camera Busy");
            alertDialog.setMessage("Camera is opened by another application, CRASH! Please close it!");
            alertDialog.show();
        } else {
            camera=null;
            camera = Camera.open();
            //noinspection deprecation
            final Camera.Parameters p = camera.getParameters();
            p.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(p);
            camera.startPreview();
            isLighOn = true;

            btnOnOff.setOnClickListener(new View.OnClickListener() {

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

            imgbtnColor.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                Intent i = new Intent(getActivity(), Screen_colors.class);
                startActivity(i);
                }
            });
        }
        return view;
    }

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
