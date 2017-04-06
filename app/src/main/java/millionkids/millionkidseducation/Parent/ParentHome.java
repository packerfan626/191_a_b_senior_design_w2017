package millionkids.millionkidseducation.Parent;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.TextView;

import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.main.MainHomePage;
import millionkids.millionkidseducation.menuUI.About;
import millionkids.millionkidseducation.menuUI.Help;
import millionkids.millionkidseducation.menuUI.LearnMore;
import millionkids.millionkidseducation.menuUI.Settings;
import android.webkit.WebView;
public class ParentHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private final String SEX_TRAFFICKING_MINOR = "sex trafficking minor",
                        SEX_TRAFFICKING_ADULT = "sex trafficking adult",
                        LABOR_TRAFFICKING = "labor trafficking",
                        SEXTORTION = "sextortion",
                        CHILD_PORNOGRAPHY = "child pornography",
                        SOCIAL_MEDIA_EXPLOITATION = "social media exploitation";
    private WebView mWebView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView tvSectionName, tvCurrentContent;
//    private String currentContent = "SexTraffickingMinor";
    private Button bSummary, bGroomingProcess, bWarrningSigns, bPreventMeasure, prevButton;
//    private Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    //class that handles all the parent information
    Content con = new Content(SEX_TRAFFICKING_MINOR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_home);

        //webview for html
        mWebView = (WebView) findViewById(R.id.test);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl(con.summaryContent());

        //set private variables
//        tvSectionName = (TextView) findViewById(R.id.tvSectionName);
        tvCurrentContent = (TextView) findViewById(R.id.tvCurrentContent);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.close);
        bSummary = (Button) findViewById(R.id.bSummary);
        bGroomingProcess = (Button) findViewById(R.id.bGroomingProcess);
        bWarrningSigns = (Button) findViewById(R.id.bWarrningSigns);
        bPreventMeasure = (Button) findViewById(R.id.bPreventMeasure);
        prevButton = bSummary;
        setTitle("Sex Trafficking - Minor");
        //set initial load
        bSummary.setBackgroundColor(Color.BLUE);
        tvCurrentContent.setText(con.summaryContent());

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
//        setTitle(con.getCurrentContent());
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
            case R.id.mHelp:
                this.startActivity(new Intent(this, Help.class));
                break;
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
//                currentContent = "SexTraffickingMinor";
                con.setcurrentContent(SEX_TRAFFICKING_MINOR);
                this.setTitle("Sex Trafficking - Minor");
//                tvSectionName.setText("Sex Trafficking - Minor");
                tvCurrentContent.setText(con.summaryContent());
                changeButtonColors(bSummary, prevButton);
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mSexTraffickingAdult:
//                currentContent = "SexTraffickingAdult";
                con.setcurrentContent(SEX_TRAFFICKING_ADULT);
                this.setTitle("Sex Trafficking - Adult");
//                tvSectionName.setText("Sex Trafficking - Adult");
                tvCurrentContent.setText(con.summaryContent());
                changeButtonColors(bSummary, prevButton);
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mLaborTrafficking:
//                currentContent = "LaborTrafficking";
                con.setcurrentContent(LABOR_TRAFFICKING);
                this.setTitle("Labor Trafficking");
//                tvSectionName.setText("Labor Trafficking");
                tvCurrentContent.setText(con.summaryContent());
                changeButtonColors(bSummary, prevButton);
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mSextortion:
//                currentContent = "Sextortion";
                con.setcurrentContent(SEXTORTION);
                this.setTitle("Sextortion");
//                tvSectionName.setText("Sextortion");
                tvCurrentContent.setText(con.summaryContent());
                changeButtonColors(bSummary, prevButton);
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mChildPornography:
//                currentContent = "ChildPornography";
                con.setcurrentContent(CHILD_PORNOGRAPHY);
                this.setTitle("Child Pornography");
//                tvSectionName.setText("Child Pornography");
                tvCurrentContent.setText(con.summaryContent());
                changeButtonColors(bSummary, prevButton);
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.mSocialMediaExploitation:
//                currentContent = "SocialMediaExploitation";
                con.setcurrentContent(SOCIAL_MEDIA_EXPLOITATION);
                this.setTitle("Social Media Exploitation");
//                tvSectionName.setText("Social Media Exploitation");
                tvCurrentContent.setText(con.summaryContent());
                changeButtonColors(bSummary, prevButton);
                mDrawerLayout.closeDrawers();
                return true;
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

    //button listeners
    @Override
    public void onClick(View v)
    {
        // getting the subcategory for each content category
        switch(v.getId())
        {
            case R.id.bSummary:
                tvCurrentContent.setText(con.summaryContent());
                changeButtonColors(bSummary, prevButton);
                break;
            case R.id.bGroomingProcess:
                tvCurrentContent.setText(con.groomingProcessContent());
                changeButtonColors(bGroomingProcess, prevButton);
                break;
            case R.id.bWarrningSigns:
                tvCurrentContent.setText(con.warningSignsContent());
                changeButtonColors(bWarrningSigns, prevButton);
                break;
            case R.id.bPreventMeasure:
                tvCurrentContent.setText(con.preventativeMeasureContent());
                changeButtonColors(bPreventMeasure, prevButton);
                break;
        }
    }

    //change the buttons color
    private void changeButtonColors(Button blue, Button gray)
    {
        int lighGray = Color.parseColor("#a7afbc");
        gray.setBackgroundColor(lighGray);
        blue.setBackgroundColor(Color.BLUE);
        prevButton = blue;
    }
}
