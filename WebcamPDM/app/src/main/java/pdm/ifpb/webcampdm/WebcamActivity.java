package pdm.ifpb.webcampdm;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import java.io.IOException;

public class WebcamActivity extends AppCompatActivity {

    private Camera camera;
    private CameraPreview cameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcam);
        camera = getCameraInstance();
        cameraPreview = new CameraPreview(this, camera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.surfaceView);
        preview.addView(cameraPreview);
    }

    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (camera != null) {
//            camera.release();
//        }
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        if (camera != null) {
//            camera.stopPreview();
//        }
//    }

//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
//        try {
//            camera.setPreviewDisplay(holder);
//            camera.startPreview();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format,
//                               int width, int height) {
//
//        if (holder.getSurface() != null) {
//            try {
//                camera.stopPreview();
//            } catch (Exception e) {
//            }
//
//            try {
//                camera.setPreviewDisplay(holder);
//                camera.startPreview();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//    }

}
