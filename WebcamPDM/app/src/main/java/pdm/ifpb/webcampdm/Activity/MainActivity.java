package pdm.ifpb.webcampdm.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import pdm.ifpb.webcampdm.R;

public class MainActivity extends AppCompatActivity {
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
    }

    public void cam(View view) {
        startActivity(new Intent(getApplicationContext(), WebcamActivity.class));
    }

    public void control(View view) {
        startActivity(new Intent(getApplicationContext(), ControlActivity.class));
    }

    public void uri(View view) {
        if (count++ == 3) {
            count = 0;
            startActivity(new Intent(getApplicationContext(), URLActivity.class));
        } else {
            Toast.makeText(getApplicationContext(),"Faltam "+ (4 - count)+ " clique para alterar a uri.",Toast.LENGTH_SHORT).show();
        }
    }
}

