package pdm.ifpb.webcampdm;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class WebcamActivity extends AppCompatActivity {

    private Camera camera;
    private CameraPreview cameraPreview;
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
        FrameLayout preview = (FrameLayout) findViewById(R.id.surfaceView);
        preview.addView(cameraPreview);
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
        if (camera.getParameters().getFlashMode() == Camera.Parameters.FLASH_MODE_OFF) {
            camera.getParameters().setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        } else {
            camera.getParameters().setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        }
    }

}
