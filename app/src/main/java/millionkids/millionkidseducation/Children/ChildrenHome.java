package millionkids.millionkidseducation.Children;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.SQLException;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import io.realm.Realm;
import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.SQLite.MySQLiteHelper;
import millionkids.millionkidseducation.SQLite.Scenario;
import millionkids.millionkidseducation.SQLite.ScenarioData;
import millionkids.millionkidseducation.menuUI.About;
import millionkids.millionkidseducation.menuUI.Help;
import millionkids.millionkidseducation.menuUI.LearnMore;
import millionkids.millionkidseducation.menuUI.Settings;

public class ChildrenHome extends AppCompatActivity implements View.OnClickListener {

    //ImageButton declarations
    ImageButton girl5_8, boy5_8, girl9_12, boy9_12, girl13_17, boy13_17;
    MySQLiteHelper sqLiteHelper;
    AlertDialog.Builder builder;
    ScenarioData scenarioData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_home);

        //Set screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        List<Scenario> scenarios = new LinkedList<Scenario>();
        scenarios = scenarioData.getScenarios();
        


        //SetButtons for image buttons based on UI
        girl5_8 = (ImageButton)findViewById(R.id.girl5_8);
        boy5_8 = (ImageButton)findViewById(R.id.boy5_8);
        girl9_12 = (ImageButton)findViewById(R.id.girl9_12);
        boy9_12 = (ImageButton)findViewById(R.id.boy9_12);

        //SetOnClick Listeners
        girl5_8.setOnClickListener(this);
        boy5_8.setOnClickListener(this);
        girl9_12.setOnClickListener(this);
        boy9_12.setOnClickListener(this);
    }

    //Menu option BEGINS
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
        //  return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mHome:
                //this.startActivity(new Intent(this, MainHomePage.class));
                break;
            case R.id.mAbout:
                this.startActivity(new Intent(this, About.class));
                break;
            case R.id.mLearnMore:
                this.startActivity(new Intent(this, LearnMore.class));
                break;
            case R.id.mHelp:
                this.startActivity(new Intent(this, Help.class));
                break;
            case R.id.mSetting:
                this.startActivity(new Intent(this, Settings.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        //Type to pass in to recognize which folder to open
        String folder = "";

        //Prepare to send data to ScenarioOptions.java
        Intent intent = new Intent(ChildrenHome.this, ScenarioOptions.class);
        Bundle data = new Bundle();

        switch(view.getId()){
            case R.id.girl5_8:
                folder = "girl5-8";
                break;
            case R.id.boy5_8:
                folder = "boy5-8";
                break;
            case R.id.girl9_12:
                folder = "girl9-12";
                break;
            case R.id.boy9_12:
                folder = "boy9-12";
                break;
        }

        //Put data in bundle to send to ScenarioOptions.java
        data.putString("folder", folder);

        //Start the new activity w/ send data
        intent.putExtras(data);
        startActivity(intent);
    }
    //Menu option ENDS
}
