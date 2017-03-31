package millionkids.millionkidseducation.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import millionkids.millionkidseducation.Children.ChildrenHome;
import millionkids.millionkidseducation.Parent.ParentHome;
import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.menuUI.About;
import millionkids.millionkidseducation.menuUI.Help;
import millionkids.millionkidseducation.menuUI.LearnMore;
import millionkids.millionkidseducation.menuUI.Settings;

public class MainHomePage extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_page);

        final Button bParent = (Button) findViewById(R.id.bParent);
        final Button bChild = (Button) findViewById(R.id.bChild);
        bParent.setOnClickListener(this);
        bChild.setOnClickListener(this);
//        bAge13_16.setOnClickListener(this);
//        bAdults.setOnClickListener(this);
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



    //age selection buttons BEGINS
    @Override
    public void onClick(View v) {
        Intent intentExtras;
        String nextClass = "";
        switch(v.getId()) {
            case R.id.bChild:
                //intent AGE 5-8
                //this.startActivity(this, .class);
//                nextClass = "eightToTen";
                intentExtras = new Intent(MainHomePage.this, ChildrenHome.class);
//                intentExtras.putExtra("whichClass", nextClass);
                startActivity(intentExtras);
               // startActivity(new Intent(this, GameStart.class));
                break;
            case R.id.bParent:
                //intent Parent
                intentExtras = new Intent(MainHomePage.this, ParentHome.class);
                startActivity(intentExtras);
                break;
//            case R.id.bAge13_16:
//                //intent AGE 13-16
//                //this.startActivity(this, .class);
//                break;
//            case R.id.bAdults:
//                //intent AGE adults
//                //this.startActivity(this, .class);
//                break;
        }
    }
    //age selection buttons ENDS

    //Disables back button from going to previous activity
    @Override
    public void onBackPressed(){
    }

}
