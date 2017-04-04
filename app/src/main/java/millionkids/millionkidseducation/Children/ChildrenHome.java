package millionkids.millionkidseducation.Children;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;

import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.menuUI.About;
import millionkids.millionkidseducation.menuUI.Help;
import millionkids.millionkidseducation.menuUI.LearnMore;
import millionkids.millionkidseducation.menuUI.Settings;

public class ChildrenHome extends AppCompatActivity {

    //ImageButton declarations
    ImageButton girl5_8, boy5_8, girl9_12, boy9_12, girl13_17, boy13_17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_home);

        //Set screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //SetButtons for image buttons based on UI
        girl5_8 = (ImageButton)findViewById(R.id.girl5_8);
        boy5_8 = (ImageButton)findViewById(R.id.boy5_8);
        girl9_12 = (ImageButton)findViewById(R.id.girl9_12);
        boy9_12 = (ImageButton)findViewById(R.id.boy9_12);

//        //SetImages for buttons
//        girl5_8.setBackgroundResource(R.drawable.girl5_8);
//        girl5_8.setAlpha(1.0f);
//
//        boy5_8.setBackgroundResource(R.drawable.boy5_8);
//        boy5_8.setAlpha(1.0f);
//
//        girl9_12.setBackgroundResource(R.drawable.girl9_12);
//        girl9_12.setAlpha(1.0f);
//
//        boy9_12.setBackgroundResource(R.drawable.boy9_12);
//        boy9_12.setAlpha(1.0f);
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
    //Menu option ENDS
}
