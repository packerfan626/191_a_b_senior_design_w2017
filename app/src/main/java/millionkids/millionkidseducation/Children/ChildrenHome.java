package millionkids.millionkidseducation.Children;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;

import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.main.MainHomePage;
import millionkids.millionkidseducation.menuUI.About;
import millionkids.millionkidseducation.menuUI.Help;
import millionkids.millionkidseducation.menuUI.LearnMore;
import millionkids.millionkidseducation.menuUI.Settings;

public class ChildrenHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_home);
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
                this.startActivity(new Intent(this, MainHomePage.class));
                break;
//            case R.id.mAbout:
//                this.startActivity(new Intent(this, About.class));
//                break;
//            case R.id.mLearnMore:
//                this.startActivity(new Intent(this, LearnMore.class));
//                break;
            case R.id.mHelp:
                this.startActivity(new Intent(this, Help.class));
                break;
//            case R.id.mSetting:
//                this.startActivity(new Intent(this, Settings.class));
//                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //Menu option ENDS
}
