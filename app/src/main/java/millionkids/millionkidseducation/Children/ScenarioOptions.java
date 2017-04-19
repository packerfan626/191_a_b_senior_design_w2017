package millionkids.millionkidseducation.Children;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import millionkids.millionkidseducation.R;

public class ScenarioOptions extends AppCompatActivity {

    //LinearLayout declaration
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario_options);

        //Linking LinearLayout to UI
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);

        //Set screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Receive Data from Previous screen (ChildrenHome.java)
        Bundle bundle = getIntent().getExtras();
        String folder = bundle.getString("ageId");
        //End

        //Testing Dynamic ImageViews in ScenarioOptions UI
        ImageButton image = new ImageButton(this);


        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        image.setLayoutParams(lp);
        image.setMaxHeight(300);
        image.setMaxWidth(300);
        image.setImageResource(R.drawable.boy5_8);
        image.setAdjustViewBounds(true);
        linearLayout.addView(image);

        ImageButton image2 = new ImageButton(this);

        image2.setLayoutParams(lp);
        image2.setMaxHeight(300);
        image2.setMaxWidth(300);
        image2.setImageResource(R.drawable.boy9_12);
        image2.setAdjustViewBounds(true);
        linearLayout.addView(image2);
    }
}
