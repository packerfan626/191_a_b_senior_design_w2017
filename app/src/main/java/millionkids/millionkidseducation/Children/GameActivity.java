package millionkids.millionkidseducation.Children;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.SQLite.Game;
import millionkids.millionkidseducation.SQLite.GameData;

public class GameActivity extends AppCompatActivity {
    //Used to set the background image from the SQLite Database
    ImageView background;

    //Game Text that stores background information and questions
    TextView gameText;

    //Answer buttons
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;

    RadioGroup radioGroup;

    //Submit Option
    ImageButton submit;

    //Declaration of GameData
    GameData gameData = new GameData(this);

    //List of GameData
    List <Game> games;

    //Current index
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Set screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //Recieve data from previous screen
        Bundle bundle = getIntent().getExtras();

        //Store recieved (from previous screen) scenarioId into int scenarioId
        int scenarioId = bundle.getInt("scenarioId");

        //Initial index; set to zero
        index = 0;

        //Link Variables to UI content
        gameText = (TextView)findViewById(R.id.gameText);
        background = (ImageView)findViewById(R.id.bgImage);
        option1 = (RadioButton)findViewById(R.id.option1);
        option2 = (RadioButton)findViewById(R.id.option2);
        option3 = (RadioButton)findViewById(R.id.option3);
        submit = (ImageButton)findViewById(R.id.submitButton);

        //Game declaration
        games = new LinkedList<Game>();

        //Setting scrollable for GameText TextView
        gameText.setMovementMethod(new ScrollingMovementMethod());

        //Get GameData depending on ScenarioID
        games = gameData.getGameData(scenarioId);

        //Display Data onto UI
        displayData(games);

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
        //Link RadioGroup to the RadioGroupXML
        radioGroup = (RadioGroup)findViewById(R.id.radio);

        //Checks the imageButton "Submit" when OnClick
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recognize which radioButton is selected
                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonId);
                int selectedId = radioGroup.indexOfChild(radioButton);

                //Get feedback from selectedID.
                String message = "";
                if(selectedId == 0){
                    message = games.get(index).getAnswer1text();
                }else if (selectedId == 1){
                    message = games.get(index).getAnswer2text();
                }else{
                    message = games.get(index).getAnswer3text();
                }

                //Check if answer is correct or not, and provide the feedback in the dialog
                if(games.get(index).getCorrectAnswer() == selectedId) {

                    //Display if the user selected the correct answer.
                    new AlertDialog.Builder(GameActivity.this)
                            .setTitle("Correct")
                            .setMessage("This is the correct answer: " + message)
                            .setPositiveButton("Next!", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Increment index by 1
                                    index++;

                                    //Check if Index is equal to the size of games list
                                    if(index == games.size()){

                                    }else{
                                        /*If there are still questions within the scenario and then
                                        continue*/

                                        displayData(games);
                                    }
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }else{

                    //Display if the user selected the incorrect answer
                    new AlertDialog.Builder(GameActivity.this)
                            .setTitle("Wrong Answer")
                            .setMessage("This answer is incorrect: " + message)
                            .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }

            }
        });
    }

    public void displayData(List<Game> games){
        //Stores currentIndex of game
        Game currentIndex = games.get(index);

        //Sets Text for Scenario/Question
        if(!currentIndex.getQuestionText().isEmpty())
            gameText.setText(games.get(index).getQuestionText());
        else
            gameText.setVisibility(View.INVISIBLE);

        //BEGIN--Sets up text for radio buttons--------------
        if(!currentIndex.getAnswer1().equals("null"))
            option1.setText(games.get(index).getAnswer1());
        else
            option1.setVisibility(View.INVISIBLE);


        if(!currentIndex.getAnswer2().equals("null"))
            option2.setText(games.get(index).getAnswer2());
        else
            option2.setVisibility(View.INVISIBLE);

        if(!currentIndex.getAnswer3().equals("null"))
            option3.setText(games.get(index).getAnswer3());
        else
            option3.setVisibility(View.INVISIBLE);
        //END------------------------------------------------
    }
}
