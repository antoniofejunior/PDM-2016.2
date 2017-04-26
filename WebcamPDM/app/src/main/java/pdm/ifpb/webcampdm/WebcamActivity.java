package pdm.ifpb.webcampdm;

import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class WebcamActivity extends AppCompatActivity {

    private Camera camera;
    private CameraPreview cameraPreview;
    private boolean booFlash;
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
        idcam.setText(getIDCam());
    }

    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open();
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
            return pref.getString("idcam",null);

    }

    private String ServerId() {
        return "id cam 2";
    }
}