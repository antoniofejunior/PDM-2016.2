package pdm.ifpb.webcampdm.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pdm.ifpb.webcampdm.R;

public class RealtimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime);
    }

    public void voltar(View view) {
        onBackPressed();
    }

}
