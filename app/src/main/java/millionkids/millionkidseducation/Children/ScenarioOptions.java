package millionkids.millionkidseducation.Children;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.SQLite.AgeGroups;
import millionkids.millionkidseducation.SQLite.Scenario;
import millionkids.millionkidseducation.SQLite.ScenarioData;

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
        String ageId = bundle.getString("ageId");
        int age = Integer.parseInt(ageId);
        //End

        ScenarioData scenarioData = new ScenarioData(this);
        //Declaring a list of scenarios
        List<Scenario> scenarios = scenarioData.getScenarios(age);

        //Create an array of ImageButtons based on scenarios size
        final ImageButton[] imageButtons = new ImageButton[scenarios.size()];

        //LinearLayout Parameters
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for(int i = 0; i < scenarios.size(); i++){
            //Setting button to new ImageButton
            imageButtons[i] = new ImageButton(this);

            //Setting Image Resource
            imageButtons[i].setImageResource(R.drawable.boy5_8);

            //Setting Tags and ID for UI ImageButton
            imageButtons[i].setTag(i);
            imageButtons[i].setId(i);

            //Formatting
            imageButtons[i].setLayoutParams(lp);
            imageButtons[i].setBackgroundColor(Color.TRANSPARENT);
            imageButtons[i].setMaxHeight(300);
            imageButtons[i].setMaxWidth(300);
            imageButtons[i].setAdjustViewBounds(true);

            //OnClick options for button
            imageButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ScenarioOptions.this, GameActivity.class);
                    Bundle bundle = new Bundle();

                    ImageButton imageButton = (ImageButton) view;
                    int id = imageButton.getId() + 1;

                    new AlertDialog.Builder(ScenarioOptions.this)
                            .setTitle("Delete entry")
                            .setMessage("Are you sure you want to delete this entry?" + id)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                    bundle.putInt("scenarioId", id);

                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            });


            //Add ImageButton to the view
            linearLayout.addView(imageButtons[i]);
        }
    }
}
