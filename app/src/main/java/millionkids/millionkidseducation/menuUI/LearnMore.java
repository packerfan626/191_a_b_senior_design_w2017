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
import android.widget.TextView;

import millionkids.millionkidseducation.main.MainActivity;
import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.main.MainHomePage;

public class LearnMore extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private String content = "Educate yourself, your friends, your family, your community, and your " +
            "business about trafficking.\n\nThe first step in success is helping to make people aware " +
            "of the extent that trafficking exists in our own backyard. Our goal is to reach every " +
            "Riverside and San Bernardino County community so they can recognize trafficking and " +
            "identify victims and assist law enforcement to aid victims and bring perpetrators to " +
            "justice.\n\nBecome an Informed Volunteer. This program will equip you to be able to " +
            "inform others about the issue of human trafficking and what EVERYONE can do to prevent " +
            "child sex trafficking. It will also provide you with the basis for actionable programs " +
            "that you can lead and participate in to empower kids to take a stand against " +
            "exploitation.\n\nContact us at 1-(951)-323-0298 to be trained or to arrange a speaking " +
            "engagement for groups and organizations to learn about trafficking in the community.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);

        final TextView tvLearnMoreContent = (TextView) findViewById(R.id.tvLearnMoreContent);
        tvLearnMoreContent.setText(content);

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
