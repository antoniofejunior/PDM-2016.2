package ifpb.pdm.junior.airsoft;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static ifpb.pdm.junior.airsoft.R.id.btlogar;
import static ifpb.pdm.junior.airsoft.R.id.line1;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void sendMain(View view){
        final EditText edEmail = (EditText) findViewById(R.id.etMail);
        final EditText edPassword = (EditText) findViewById(R.id.etPassword);
        if(logar(edEmail.getText().toString(),edPassword.getText().toString())) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "usuario ou senha invalidos", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
            toast.show();

        }
    }

    private boolean logar(String email, String senha){
        return (email.equals("admin")&&senha.equals("123"));
    }
}
