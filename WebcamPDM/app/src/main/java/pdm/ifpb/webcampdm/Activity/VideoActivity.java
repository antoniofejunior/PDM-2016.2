package pdm.ifpb.webcampdm.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pdm.ifpb.webcampdm.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
    }

    public void voltar(View view) {
        onBackPressed();
    }
}
