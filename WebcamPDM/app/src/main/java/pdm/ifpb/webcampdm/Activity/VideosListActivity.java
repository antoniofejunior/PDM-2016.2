package pdm.ifpb.webcampdm.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pdm.ifpb.webcampdm.R;

public class VideosListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //    String[] listviewTitle = new String[]{
//            "ListView Title 1", "ListView Title 2", "ListView Title 3", "ListView Title 4",
//            "ListView Title 5", "ListView Title 6", "ListView Title 7", "ListView Title 8",
//    };
//
//
//    int[] listviewImage = new int[]{
//            R.drawable.arrow_left, R.drawable.arrow_left, R.drawable.arrow_left, R.drawable.arrow_left,
//            R.drawable.arrow_left, R.drawable.arrow_left, R.drawable.arrow_left, R.drawable.arrow_left,
//    };
//
//    String[] listviewShortdata = new String[]{
//            "11/02/2017", "21/04/2017", "11/0e/2017", "15/05/2017",
//            "01/02/2017", "21/02/2017", "13/04/2017", "15/02/2017",
//    };
//    String[] listviewShortime = new String[]{
//            "10:00", "16:55", "11:15", "20:17",
//            "22:40", "15:20", "11:02", "11:03",
//    };
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_videos_list);
//
//        List<HashMap<String, String>> aList = new ArrayList<>();
//
//        for (int i = 0; i < 8; i++) {
//            HashMap<String, String> hm = new HashMap<String, String>();
//            hm.put("listview_Idcam", listviewTitle[i]);
//            hm.put("listview_data", listviewShortdata[i]);
//            hm.put("listview_time", listviewShortime[i]);
//            hm.put("listview_image", Integer.toString(listviewImage[i]));
//            aList.add(hm);
//        }
//
//        String[] from = {"listview_image", "listview_Idcam", "listview_data", "listview_time"};
//        int[] to = {R.id.lviImage, R.id.lviIdCam, R.id.lviData, R.id.lviHora};
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.video_item, from, to);
//        ListView androidListView = (ListView) findViewById(R.id.listVideos);
//        androidListView.setAdapter(simpleAdapter);
//    }

    public void voltar(View view) {
        onBackPressed();
    }
}
