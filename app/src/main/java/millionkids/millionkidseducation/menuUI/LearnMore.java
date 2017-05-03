package millionkids.millionkidseducation.menuUI;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;

import millionkids.millionkidseducation.main.MainActivity;
import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.main.MainHomePage;

public class LearnMore extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);

        //set Hamburger Menu
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutLearnMore);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //listen for buttons in navigation Menu
        NavigationView nv = (NavigationView) findViewById(R.id.navigationViewDefault);
        nv.setNavigationItemSelectedListener(this);
    }

    //Menu option
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
                this.startActivity(new Intent(this, MainHomePage.class));
                break;
//            case R.id.mHelp:
//                this.startActivity(new Intent(this, Help.class));
//                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Hamburger Menu
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.mAbout:
                this.startActivity(new Intent(this, About.class));
                return true;
            case R.id.mLearnMore:
                this.startActivity(new Intent(this, LearnMore.class));
                return true;
//            case R.id.mSetting:
//                this.startActivity(new Intent(this, Settings.class));
//                return true;
        }
        return false;
    }
    //Menu option end
}
