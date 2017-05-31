package millionkids.millionkidseducation.Children;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import millionkids.millionkidseducation.R;
import millionkids.millionkidseducation.SQLite.Game;
import millionkids.millionkidseducation.SQLite.GameData;
import millionkids.millionkidseducation.main.MainHomePage;

public class GameActivity extends AppCompatActivity {
    //Used to set the background image from the SQLite Database
    ImageView background;

    //Character imageView
    ImageView character;

    //Game Text that stores background information and questions
    TextView gameText;

    //Answer buttons
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;

    //Set up the RadioGroup
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
        String imageText = bundle.getString("imageText");

        //Initial index; set to zero
        index = 0;

        //Link Variables to UI content
        gameText = (TextView)findViewById(R.id.gameText);
        background = (ImageView)findViewById(R.id.bgImage);
        option1 = (RadioButton)findViewById(R.id.option1);
        option2 = (RadioButton)findViewById(R.id.option2);
        option3 = (RadioButton)findViewById(R.id.option3);
        submit = (ImageButton)findViewById(R.id.submitButton);
        character = (ImageView)findViewById(R.id.childImage);

        submit.setScaleType(ImageView.ScaleType.FIT_XY);

        //Game declaration
        games = new LinkedList<Game>();


        //Setting scrollable for GameText TextView
        gameText.setMovementMethod(new ScrollingMovementMethod());

        //Get GameData depending on ScenarioID
        games = gameData.getGameData(scenarioId);


        //Set Character Image based on resources
        Resources res = getResources();
        int resId = res.getIdentifier(imageText, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resId, this.getTheme());
        character.setImageDrawable(drawable);


        //Display Data onto UI
        displayData(games);

        //Add Listener for radio buttons
        addListenerButton();
    }

    public void addListenerButton(){
            //Link RadioGroup to the RadioGroupXML
            radioGroup = (RadioGroup) findViewById(R.id.radio);

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
                    if (selectedId == 0) {
                        message = games.get(index).getAnswer1text();
                        validSelection = true;
                    } else if (selectedId == 1) {
                        message = games.get(index).getAnswer2text();
                        validSelection = true;
                    } else if (selectedId == 2) {
                        message = games.get(index).getAnswer3text();
                        validSelection = true;
                    } else {
                        validSelection = false;
                    }

                    //Check if answer is correct or not, and provide the feedback in the dialog
                    if (games.get(index).getCorrectAnswer() == selectedId) {
                        //Display if the user selected the correct answer.
                        new AlertDialog.Builder(GameActivity.this)
                                .setTitle("Correct")
                                .setMessage("This is the correct answer: " + message)
                                .setPositiveButton("Next!", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Increment index by 1
                                        index++;

                                        //Check if Index is equal to the size of games list
                                        if (index == games.size()) {
                                            new AlertDialog.Builder(GameActivity.this)
                                                    .setTitle("Nice Job!")
                                                    .setMessage("Thank you for playing! We hope you " +
                                                            "learned a lot! \n\nRemember:" + "\n" +
                                                            "Be S.A.F.E." + "\n" +
                                                            "Stay S.A.F.E." + "\n" +
                                                            "S - Speak up.         " + "\n" +
                                                            "A - Ask first.           " + "\n" +
                                                            "F - Find help.          " + "\n" +
                                                            "E - Educate others.")
                                                    .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            //Reset index and redisplay data
                                                            finish();
                                                            startActivity(getIntent());
                                                        }
                                                    })
                                                    .setNegativeButton("Main Menu", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            //Game jumps back to Game--MainMenu
                                                            Intent intent = new Intent(GameActivity.this, ChildrenHome.class);
                                                            finish();
                                                            startActivity(intent);
                                                        }
                                                    })
                                                    .setCancelable(false)

                                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                                    .show();
                                        } else {
                                        /*If there are still questions within the scenario and then
                                        continue*/
                                            radioGroup.clearCheck();
                                            displayData(games);
                                        }
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .setCancelable(false)
                                .show();
                    } else if (games.get(index).getCorrectAnswer() != selectedId && validSelection) {
                        //Display if the user selected the incorrect answer
                        new AlertDialog.Builder(GameActivity.this)
                                .setTitle("Let's try again!")
                                .setMessage("This answer is not the best decision: " + message)
                                .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // continue with try again
                                        //radioButton.setVisibility(View.INVISIBLE);
                                        radioGroup.clearCheck();
                                    }
                                })

                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .setCancelable(false)
                                .show();
                    } else if (!validSelection) {
                        //Check if options are available, if yes display an error dialog
                        if (optionsAvail) {
                            new AlertDialog.Builder(GameActivity.this)
                                    .setTitle("Make a Selection")
                                    .setMessage("You must make a selection!")
                                    .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            // continue with try again
                                        }
                                    })
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .setCancelable(false)
                                    .show();
                            //If no options available allow them to proceed by simply clicking select
                        } else {
                            index++;
                            if (index == games.size()) {
                                new AlertDialog.Builder(GameActivity.this)
                                        .setTitle("Nice Job!")
                                        .setMessage("Thank you for playing! We hope you " +
                                                "learned a lot! Remember:" + "\n" +
                                                "Be S.A.F.E." + "\n" +
                                                "Stay S.A.F.E." + "\n" +
                                                "S - Speak up.         " + "\n" +
                                                "A - Ask first.           " + "\n" +
                                                "F - Find help.          " + "\n" +
                                                "E - Educate others.")
                                        .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                //Reset index and redisplay data
                                                finish();
                                                startActivity(getIntent());
                                            }
                                        })
                                        .setNegativeButton("Main Menu", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                //Game jumps back to Game--MainMenu
                                                Intent intent = new Intent(GameActivity.this, ChildrenHome.class);
                                                finish();
                                                startActivity(intent);
                                            }
                                        })
                                        .setCancelable(false)
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();
                            } else {
                                radioGroup.clearCheck();
                                displayData(games);
                            }
                        }
                    }
                }
            }
            );

    }

    //Display the data onto the UI that is taken in from the Database
    public void displayData(List<Game> games){
        optionsAvail = false;
        //Stores currentIndex of game
        Game currentIndex = games.get(index);

        background.setScaleType(ImageView.ScaleType.FIT_XY);
        option1.setBackgroundColor(Color.WHITE);
        option2.setBackgroundColor(Color.WHITE);

        option3.setBackgroundColor(Color.WHITE);
        gameText.setBackgroundColor(Color.WHITE);

        if(currentIndex.getShowChild().equals("n"))
            character.setVisibility(View.INVISIBLE);
        else
            character.setVisibility(View.VISIBLE);

        //Sets Text for Scenario/Question
        if(!currentIndex.getQuestionText().equals("null")) {
            gameText.setText(games.get(index).getQuestionText());
            gameText.setVisibility(View.VISIBLE);
            //radiogroupBg.setVisibility(View.VISIBLE);
        }
        else {
            gameText.setVisibility(View.INVISIBLE);
            //LinearLayout Parameters
            //radiogroupBg.setVisibility(View.INVISIBLE);
            optionsAvail = false;
        }

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
        try {
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(currentIndex.getImageDir()));
            background.setImageBitmap(b);
        } catch (FileNotFoundException e) {

            //If the picture did not load successfully, display message
            new AlertDialog.Builder(GameActivity.this)
                    .setTitle("Whoops!")
                    .setMessage("Something went wrong and the picture did not load correctly! Sorry about that! :(")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with try again
                        }
                    })
                    .setCancelable(false)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            e.printStackTrace();
        }
    }

    //Disables back button from doing anything
    @Override
    public void onBackPressed(){
        Intent intentExtras;
        intentExtras = new Intent(this, ChildrenHome.class);
        finish();
        startActivity(intentExtras);
    }


}
