package ifpb.pdm.junior.airsoft;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction tr = fragmentManager.beginTransaction();
        tr.add(R.id.frameMain, new missionsFragment());
        tr.replace(R.id.frameMain, new missionsFragment());
        tr.addToBackStack("mission");
        tr.commit();
    }

    private void replaceFragment(int id, Fragment fragment) {
        FragmentTransaction tr = fragmentManager.beginTransaction();
        tr.replace(id, fragment);
        tr.addToBackStack(fragment.getClass().getSimpleName());
        tr.commit();
    }


    public void btMission(View view) {
        replaceFragment(R.id.frameMain, new missionsFragment());
        Button btchat = (Button) findViewById(R.id.btMission);
        Button btmission = (Button) findViewById(R.id.btMission);
        btchat.setBackgroundColor(getResources().getColor(R.color.colorInativePn));
        btmission.setBackgroundColor(getResources().getColor(R.color.colorPn));
    }

    public void btchat(View view) {
        replaceFragment(R.id.frameMain, new missionsFragment());
        Button btchat = (Button) findViewById(R.id.btMission);
        Button btmission = (Button) findViewById(R.id.btMission);
        btmission.setBackgroundColor(getResources().getColor(R.color.colorInativePn));
        btchat.setBackgroundColor(getResources().getColor(R.color.colorPn));
    }

}
