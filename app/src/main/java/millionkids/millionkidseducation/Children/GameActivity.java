package millionkids.millionkidseducation.Children;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    //Checks if options are available
    boolean optionsAvail = false;

    //Current index
    int index = 0;

    //The FileName to open
    String FILENAME;
    FileInputStream fileInputStream;

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

    public void addListenerButton(){
        //Link RadioGroup to the RadioGroupXML
        radioGroup = (RadioGroup)findViewById(R.id.radio);

        //Checks the imageButton "Submit" when OnClick
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recognize which radioButton is selected
                int radioButtonId = radioGroup.getCheckedRadioButtonId();
                final View radioButton = radioGroup.findViewById(radioButtonId);
                final int selectedId = radioGroup.indexOfChild(radioButton);
                boolean validSelection = false;

                //Get feedback from selectedID.
                String message = "";
                if(selectedId == 0){
                    message = games.get(index).getAnswer1text();
                    validSelection = true;
                }else if (selectedId == 1){
                    message = games.get(index).getAnswer2text();
                    validSelection = true;
                }else if (selectedId == 2){
                    message = games.get(index).getAnswer3text();
                    validSelection = true;
                }else{
                    validSelection = false;
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
                                        new AlertDialog.Builder(GameActivity.this)
                                                .setTitle("Game Over!")
                                                .setMessage("Thank you for playing! We hope you " +
                                                        "learned a lot!")
                                                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        //Reset index and redisplay data
                                                        index = 0;
                                                        displayData(games);
                                                    }
                                                })
                                                .setNegativeButton("Main Menu", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        //Game jumps back to Game--MainMenu
                                                        Intent intent = new Intent(GameActivity.this, ChildrenHome.class);
                                                        startActivity(intent);
                                                    }
                                                })
                                                .setIcon(android.R.drawable.ic_dialog_alert)
                                                .show();
                                    }else{
                                        /*If there are still questions within the scenario and then
                                        continue*/
                                        radioGroup.clearCheck();
                                        displayData(games);
                                    }
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }else if (games.get(index).getCorrectAnswer() != selectedId && validSelection) {
                    //Display if the user selected the incorrect answer
                    new AlertDialog.Builder(GameActivity.this)
                            .setTitle("Wrong Answer")
                            .setMessage("This answer is incorrect: " + message)
                            .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with try again
                                    radioButton.setVisibility(View.INVISIBLE);
                                    radioGroup.clearCheck();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
                else if (!validSelection){
                    //Check if options are available, if yes display an error dialog
                    if(optionsAvail) {
                        new AlertDialog.Builder(GameActivity.this)
                                .setTitle("Make a Selection")
                                .setMessage("You must make a selection!")
                                .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // continue with try again
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    //If no options available allow them to proceed by simply clicking select
                    }else{
                        index++;
                        displayData(games);
                    }
                }

            }
        });
    }

    //Display the data onto the UI that is taken in from the Database
    public void displayData(List<Game> games){
        //Stores currentIndex of game
        Game currentIndex = games.get(index);

        //Sets Text for Scenario/Question
        if(!currentIndex.getQuestionText().isEmpty()) {
            gameText.setText(games.get(index).getQuestionText());
        }
        else
            gameText.setVisibility(View.INVISIBLE);

        //BEGIN--Sets up text for radio buttons--------------
        if(!currentIndex.getAnswer1().equals("null")) {
            option1.setText(games.get(index).getAnswer1());
            option1.setVisibility(View.VISIBLE);
            optionsAvail = true;
        }
        else
            option1.setVisibility(View.INVISIBLE);


        if(!currentIndex.getAnswer2().equals("null")) {
            option2.setText(games.get(index).getAnswer2());
            option2.setVisibility(View.VISIBLE);
        }
        else
            option2.setVisibility(View.INVISIBLE);

        if(!currentIndex.getAnswer3().equals("null")) {
            option3.setText(games.get(index).getAnswer3());
            option3.setVisibility(View.VISIBLE);
        }
        else
            option3.setVisibility(View.INVISIBLE);
        //END------------------------------------------------

        getImage(currentIndex);
    }

    //Get the Image for the current index. Called within displaydata
    public void getImage(Game currentIndex){
        //ContextWrapper for applicationContext
        ContextWrapper cw = new ContextWrapper(getApplicationContext());

        //Access Directory containing ScenarioImages
        int questionNum = index + 1;

        //Something wrong here
        File directory = cw.getDir("Scenario_" + questionNum, Context.MODE_PRIVATE);

        try {
            //Image Directory with background image file name
            File myPath = new File(directory, currentIndex.getBackgroundImage());

            //Create bitmap that is decoded from image file that is passed in
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(myPath));



            //Set image as the background
            background.setImageBitmap(b);

            //Catch Exception
        }catch(Exception e){
            e.printStackTrace();
        }

        new AlertDialog.Builder(GameActivity.this)
                .setTitle("Make a Selection" + directory.isDirectory())
                .setMessage("You must make a selection!")
                .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with try again
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();


    }
}
