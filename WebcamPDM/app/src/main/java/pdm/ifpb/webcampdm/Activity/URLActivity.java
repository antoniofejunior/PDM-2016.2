package pdm.ifpb.webcampdm.Activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import pdm.ifpb.webcampdm.R;

public class URLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);
        EditText uri = (EditText) findViewById(R.id.URIedt);
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        uri.setText(pref.getString("URI", "http://192.168.0.113:8080/ServerCam"));

    }

    public void voltar(View view) {
        onBackPressed();
    }

    public void salvar(View view) {
        EditText uri = (EditText) findViewById(R.id.URIedt);
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("URI", uri.getText().toString());
        editor.commit();
        onBackPressed();
    }
}
