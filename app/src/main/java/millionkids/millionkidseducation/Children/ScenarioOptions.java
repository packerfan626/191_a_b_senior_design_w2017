package millionkids.millionkidseducation.Children;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.SQLite.AgeGroups;
import millionkids.millionkidseducation.SQLite.Scenario;
import millionkids.millionkidseducation.SQLite.ScenarioData;

public class ScenarioOptions extends AppCompatActivity {
    //LinearLayout declaration
    LinearLayout linearLayout;

    private List<Scenario> scenarios;

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
        final String imageText = bundle.getString("imageText");
        int age = Integer.parseInt(ageId);
        //End

        ScenarioData scenarioData = new ScenarioData(this);
        //Declaring a list of scenarios
        scenarios = scenarioData.getScenarios(age);

        //Create an array of ImageButtons based on scenarios size
        final ImageButton[] imageButtons = new ImageButton[scenarios.size()];

        //LinearLayout Parameters
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for(int i = 0; i < scenarios.size(); i++){
            //Setting button to new ImageButton
            imageButtons[i] = new ImageButton(this);

            try {
                Bitmap b = BitmapFactory.decodeStream(new FileInputStream(scenarios.get(i).getImagePath()));
                imageButtons[i].setImageBitmap(b);
            } catch (FileNotFoundException e) {

                //If the picture did not load successfully, display message
                new AlertDialog.Builder(ScenarioOptions.this)
                        .setTitle("Whoops!")
                        .setMessage("Something went wrong and the picture did not load correctly! Sorry about that! :(")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with try again
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                e.printStackTrace();
            }

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

                    int id = scenarios.get(imageButton.getId()).getScenarioid();

                    bundle.putInt("scenarioId", id);
                    bundle.putString("imageText", imageText);

                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            });

            //Add ImageButton to the view
            linearLayout.addView(imageButtons[i]);
        }
    }
}
