package millionkids.millionkidseducation.Children;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import millionkids.millionkidseducation.R;

public class GameActivity extends AppCompatActivity {
    //Used to set the background image from the SQLite Database
    ImageView background = (ImageView)findViewById(R.id.bgImage);

    //Game Text that stores background information and questions
    TextView gameText = (TextView)findViewById(R.id.gameText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Set screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Setting scrollable for GameText TextView
        gameText.setMovementMethod(new ScrollingMovementMethod());
    }
}
