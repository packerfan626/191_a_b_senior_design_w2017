package millionkids.millionkidseducation.main;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import millionkids.millionkidseducation.R;

public class MainActivity extends AppCompatActivity {

    //Set progress integer to input within progressBar
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaring Variables
        final ProgressBar progressBar;
        CountDownTimer countDownTimer;
        //attempting smooth animation of progressbar



        //Setting progressBar to the UI ProgressBar
        progressBar = (ProgressBar)findViewById(R.id.pgMain);

        //Starting countdown timer for the splash screen
        countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            //OnTick: For each second that passes
            public void onTick(long l) {
                //Increases the progress bar by 25 to show loading progress
                progress = progress + 25;
                progressBar.setProgress(progress);
            }

            @Override
            /*onFinish:
            Once finished "Loading" start the new activity and display the new view
             */
            public void onFinish() {
                startActivity(new Intent(MainActivity.this, MainHomePage.class));
            }
        };
        countDownTimer.start();
    }

    //Disables back button from doing anything
    @Override
    public void onBackPressed(){
    }
}
