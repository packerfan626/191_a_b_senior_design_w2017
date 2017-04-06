package millionkids.millionkidseducation.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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

public class MainHomePage extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_page);

        final Button bParent = (Button) findViewById(R.id.bParent);
        final Button bChild = (Button) findViewById(R.id.bChild);
        bParent.setOnClickListener(this);
        bChild.setOnClickListener(this);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutMain);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //listen for buttons in navigation Menu
        NavigationView nv = (NavigationView) findViewById(R.id.navigationViewDefaultMain);
        nv.setNavigationItemSelectedListener(this);
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

        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.mHome:
                break;
            case R.id.mHelp:
                this.startActivity(new Intent(this, Help.class));
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
//
        }
    }
    //age selection buttons ENDS

    //Disables back button from going to previous activity
    @Override
    public void onBackPressed(){
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.mAbout:
                this.startActivity(new Intent(this, About.class));
                return true;
            case R.id.mLearnMore:
                this.startActivity(new Intent(this, LearnMore.class));
                return true;
            case R.id.mSetting:
                this.startActivity(new Intent(this, Settings.class));
                return true;
        }
        return false;
    }
}
