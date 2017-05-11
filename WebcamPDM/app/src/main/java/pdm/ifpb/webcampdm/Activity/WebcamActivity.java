package pdm.ifpb.webcampdm.Activity;

import android.content.SharedPreferences;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pdm.ifpb.webcampdm.Controler.CameraPreview;
import pdm.ifpb.webcampdm.HTTPUtils;
import pdm.ifpb.webcampdm.R;

public class WebcamActivity extends AppCompatActivity {

    private Camera camera;
    private MediaRecorder aMediaRecorder;
    private CameraPreview cameraPreview;
    private boolean booFlash;
    private static String tag = "AjrLOG";
    private FloatingActionButton btflash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcam);
        camera = getCameraInstance();
        if (camera.getParameters().getFlashMode() == null) {
            btflash = (FloatingActionButton) findViewById(R.id.fab);
            btflash.setVisibility(View.INVISIBLE);
            btflash.setClickable(false);
        }
        cameraPreview = new CameraPreview(this, camera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.frameCam);
        preview.addView(cameraPreview);
        booFlash = true;
        TextView idcam = (TextView) findViewById(R.id.tvIDcam);
        Log.d("teste antes", idcam.toString());
        idcam.setText(getIDCam());
        Log.d("teste apos", idcam.toString());

    }

    public void voltar(View view) {
        onBackPressed();
    }

    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open();
            Camera.Parameters parm = c.getParameters();
            parm.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            parm.setAutoWhiteBalanceLock(false);
            parm.setAntibanding(Camera.Parameters.ANTIBANDING_AUTO);
            parm.setSceneMode(Camera.Parameters.SCENE_MODE_AUTO);
            c.setParameters(parm);
        } catch (Exception e) {
        }
        return c;
    }


    public void flash(View view) {
        Camera.Parameters parm = camera.getParameters();
        if (booFlash) {
            setflash(Camera.Parameters.FLASH_MODE_TORCH);
            booFlash = false;
        } else {
            setflash(Camera.Parameters.FLASH_MODE_OFF);
            booFlash = true;
        }
    }


    private void setflash(String parameter) {
        Camera.Parameters parm = camera.getParameters();
        parm.setFlashMode(parameter);
        camera.setParameters(parm);
    }

    private String getIDCam() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        if (!pref.contains("idcam")) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("idcam", ServerId());
        editor.commit();
        }
        return pref.getString("idcam", "ID camera fail");

    }

    private String ServerId() {
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        String uri = pref.getString("URI", "ID camera fail");
        String conteudo = HTTPUtils.acessar(uri + "/api/CamService/registrar");
        return conteudo;
    }

    public void gravarVideo(View view) {

    }


}
