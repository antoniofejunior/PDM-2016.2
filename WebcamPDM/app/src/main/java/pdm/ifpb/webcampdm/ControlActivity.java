package pdm.ifpb.webcampdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
    }

    public void listarGravacao(View view) {
        startActivity(new Intent(getApplicationContext(), VideosListActivity.class));
    }

    public void gravar(View view) {
        Toast.makeText(getApplicationContext(), "recurso nao implementado", Toast.LENGTH_SHORT).show();
    }

    public void realtime(View view) {
        startActivity(new Intent(getApplicationContext(), RealtimeActivity.class));

    }
}
