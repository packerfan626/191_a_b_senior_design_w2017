package millionkids.millionkidseducation.main;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import millionkids.millionkidseducation.R;

public class MainActivity extends AppCompatActivity {
//    private int progress = 0;
//    private static int WELCOME_TIMEOUT = 8000;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        StartAnimations();
    }

    private void StartAnimations() {
        final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.startAnimation(animationFadeIn);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 5000) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(MainActivity.this,
                            MainHomePage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    MainActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    MainActivity.this.finish();
                }

            }
        };
        splashTread.start();
    }
    @Override
    public void onBackPressed(){
    }
}

    //Set progress integer to input within progressBar
//    private int progress = 0;
//    private static int WELCOME_TIMEOUT = 4000;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //Declaring Variables
//        final ProgressBar progressBar;
//        CountDownTimer countDownTimer;
//        //attempting smooth animation of progressbar
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(MainActivity.this, MainHomePage.class));
//                overridePendingTransition(R.anim.fade_in, null);
//                finish();
//            }
//        }, WELCOME_TIMEOUT);
//
//
//        //Setting progressBar to the UI ProgressBar
//        progressBar = (ProgressBar)findViewById(R.id.pgMain);
//
//        //Starting countdown timer for the splash screen
//        countDownTimer = new CountDownTimer(5000, 1000) {
//            @Override
//            //OnTick: For each second that passes
//            public void onTick(long l) {
//                //Increases the progress bar by 25 to show loading progress
//                progress = progress + 25;
//                progressBar.setProgress(progress);
//            }
//
//            @Override
//            /*onFinish:
//            Once finished "Loading" start the new activity and display the new view
//             */
//            public void onFinish() {
//                startActivity(new Intent(MainActivity.this, MainHomePage.class));
//            }
//        };
//        countDownTimer.start();
//    }

    //Disables back button from doing anything
