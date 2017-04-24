package millionkids.millionkidseducation.Children;

import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.SQLite.Game;
import millionkids.millionkidseducation.SQLite.GameData;

public class GameActivity extends AppCompatActivity {
    //Used to set the background image from the SQLite Database
    ImageView background = (ImageView)findViewById(R.id.bgImage);

    //Game Text that stores background information and questions
    TextView gameText = (TextView)findViewById(R.id.gameText);

    //Answer buttons
    RadioButton option1 = (RadioButton)findViewById(R.id.option1);
    RadioButton option2 = (RadioButton)findViewById(R.id.option2);
    RadioButton option3 = (RadioButton)findViewById(R.id.option3);

    RadioGroup radioGroup;

    //Submit Option
    ImageButton submit = (ImageButton)findViewById(R.id.submitButton);

    //Recieve data from previous screen
    Bundle bundle = getIntent().getExtras();
    int scenarioId = bundle.getInt("scenarioId");

    //Declaration of GameData
    GameData gameData = new GameData(this);

    //List of GameData
    List <Game> games;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Set screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Setting scrollable for GameText TextView
        gameText.setMovementMethod(new ScrollingMovementMethod());

        //Get GameData depending on ScenarioID
        games = gameData.getGameData(scenarioId);


        //Add Listener for radio buttons
        addListenerButton();
    }

    //Might not use
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.option1:
                if(checked){

                }
                break;
            case R.id.option2:
                if(checked){

                }
                break;
            case R.id.option3:
                if(checked){

                }
                break;
        }
    }

    public void addListenerButton(){
        radioGroup = (RadioGroup)findViewById(R.id.radio);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                selectedId = selectedId + 1;
            }
        });
    }

    public void displayData(){

    }
}
