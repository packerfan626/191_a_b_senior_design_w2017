package millionkids.millionkidseducation.Parent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;

import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.main.MainHomePage;
import millionkids.millionkidseducation.menuUI.About;
import millionkids.millionkidseducation.menuUI.LearnMore;

import android.webkit.WebView;
public class ParentHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private final String SEX_TRAFFICKING_MINOR = "Child Sex Trafficking",
                        SEX_TRAFFICKING_ADULT = "Adult Sex Trafficking",
                        LABOR_TRAFFICKING = "Labor Trafficking",
                        SEXTORTION = "Sextortion",
                        CHILD_PORNOGRAPHY = "Child Pornography",
                        SOCIAL_MEDIA_EXPLOITATION = "Social Media Exploitation";
    private WebView mWebView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Button bSummary, bGroomingProcess, bWarrningSigns, bPreventMeasure, prevButton;
    //class that handles all the parent information
    Content con = new Content(SEX_TRAFFICKING_MINOR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_home);

        //set private variables;
        mWebView = (WebView) findViewById(R.id.test);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.close);
        bSummary = (Button) findViewById(R.id.bSummary);
        bGroomingProcess = (Button) findViewById(R.id.bGroomingProcess);
        bWarrningSigns = (Button) findViewById(R.id.bWarrningSigns);
        bPreventMeasure = (Button) findViewById(R.id.bPreventMeasure);
        prevButton = bSummary;
        setTitle("Child Sex Trafficking");

        //set initial load
        changeButtonColors(bSummary, null, SEX_TRAFFICKING_MINOR);

        //webview for html
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl(con.summaryContent());
        mWebView.setBackgroundColor(Color.TRANSPARENT);

        //Button Listeners
        bSummary.setOnClickListener(this);
        bGroomingProcess.setOnClickListener(this);
        bWarrningSigns.setOnClickListener(this);
        bPreventMeasure.setOnClickListener(this);

        //set Navigation menu
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //listen for buttons in navigation Menu
        NavigationView nv = (NavigationView) findViewById(R.id.navigationView);
        nv.setNavigationItemSelectedListener(this);
    }

    //Menu option BEGINS
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
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
    //Menu option ENDS

    //Navigation Menu
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.mSexTraffickingMinor:
                con.setcurrentContent(SEX_TRAFFICKING_MINOR);
                this.setTitle(SEX_TRAFFICKING_MINOR);
                changeButtonColors(bSummary, prevButton, con.summaryContent());
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mSexTraffickingAdult:
                con.setcurrentContent(SEX_TRAFFICKING_ADULT);
                this.setTitle(SEX_TRAFFICKING_ADULT);
                changeButtonColors(bSummary, prevButton, con.summaryContent());
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mLaborTrafficking:
                con.setcurrentContent(LABOR_TRAFFICKING);
                this.setTitle(LABOR_TRAFFICKING);
                changeButtonColors(bSummary, prevButton, con.summaryContent());
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mSextortion:
                con.setcurrentContent(SEXTORTION);
                this.setTitle(SEXTORTION);
                changeButtonColors(bSummary, prevButton, con.summaryContent());
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mChildPornography:
                con.setcurrentContent(CHILD_PORNOGRAPHY);
                this.setTitle(CHILD_PORNOGRAPHY);
                changeButtonColors(bSummary, prevButton, con.summaryContent());
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mSocialMediaExploitation:
                con.setcurrentContent(SOCIAL_MEDIA_EXPLOITATION);
                this.setTitle(SOCIAL_MEDIA_EXPLOITATION);
                changeButtonColors(bSummary, prevButton, con.summaryContent());
                mDrawerLayout.closeDrawers();
                return true;

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

    //button listeners
    @Override
    public void onClick(View v)
    {
        // getting the subcategory for each content category
        switch(v.getId())
        {
            case R.id.bSummary:
                changeButtonColors(bSummary, prevButton, con.summaryContent());
                break;
            case R.id.bGroomingProcess:
                changeButtonColors(bGroomingProcess, prevButton, con.groomingProcessContent());
                break;
            case R.id.bWarrningSigns:
                changeButtonColors(bWarrningSigns, prevButton, con.warningSignsContent());
                break;
            case R.id.bPreventMeasure:
                changeButtonColors(bPreventMeasure, prevButton, con.preventativeMeasureContent());
                break;
        }
    }

    //change the buttons color
    private void changeButtonColors(Button clicked, Button gray, String currentContext)
    {
        mWebView.loadUrl(currentContext);
        if(gray != null) {
            gray.setBackgroundColor(Color.parseColor("#00081d")); //set unselected button to dark blue
            gray.setTextColor(Color.parseColor("#FFFFFF"));    //set unselected text to white
        }
        clicked.setBackgroundColor(Color.parseColor("#203469"));  //set selected button to globeblue
        clicked.setTextColor(Color.parseColor("#fbb919")); //set text to gold
        prevButton = clicked;
    }
}
