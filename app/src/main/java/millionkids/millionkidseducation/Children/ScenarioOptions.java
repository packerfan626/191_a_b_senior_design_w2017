package millionkids.millionkidseducation.Children;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import millionkids.millionkidseducation.R;

public class ScenarioOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_options);

        //Set screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Receive Data from Previous screen (ChildrenHome.java)
        Bundle bundle = getIntent().getExtras();
        String folder = bundle.getString("folder");

        Log.d("Button", "HERE");
    }
}
