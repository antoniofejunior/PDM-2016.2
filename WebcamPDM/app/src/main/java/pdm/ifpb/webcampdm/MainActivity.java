package pdm.ifpb.webcampdm;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cam(View view){
        startActivity(new Intent(getApplicationContext(), WebcamActivity.class));
    }
}

