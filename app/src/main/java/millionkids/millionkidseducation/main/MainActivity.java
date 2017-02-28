package millionkids.millionkidseducation.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import millionkids.millionkidseducation.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {            //jac test comment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //delay startup to mainHomepage
        Thread delayStartup =new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);    //waits 3 seconds
                    startActivity(new Intent(MainActivity.this, MainHomePage.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        delayStartup.start();

    }
}
