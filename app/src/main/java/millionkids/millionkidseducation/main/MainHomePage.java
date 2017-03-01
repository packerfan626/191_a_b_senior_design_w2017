package millionkids.millionkidseducation.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

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

        final Button bAge5_8 = (Button) findViewById(R.id.bAge5_8);
        final Button bAge9_12 = (Button) findViewById(R.id.bAge9_12);
        final Button bAge13_16 = (Button) findViewById(R.id.bAge13_16);
        final Button bAdults = (Button) findViewById(R.id.bAdults);
        bAge5_8.setOnClickListener(this);
        bAge9_12.setOnClickListener(this);
        bAge13_16.setOnClickListener(this);
        bAdults.setOnClickListener(this);
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
            case R.id.bAge5_8:
                //intent AGE 5-8
                //this.startActivity(this, .class);
                nextClass = "eightToTen";
                intentExtras = new Intent(MainHomePage.this, GameStart.class);
                intentExtras.putExtra("whichClass", nextClass);
                startActivity(intentExtras);
               // startActivity(new Intent(this, GameStart.class));
                break;
            case R.id.bAge9_12:
                //intent AGE 9-12
                //this.startActivity(this, .class);
                break;
            case R.id.bAge13_16:
                //intent AGE 13-16
                //this.startActivity(this, .class);
                break;
            case R.id.bAdults:
                //intent AGE adults
                //this.startActivity(this, .class);
                break;
        }
    }
    //age selection buttons ENDS

    //Disables back button from going to previous activity
    @Override
    public void onBackPressed(){
    }

}
