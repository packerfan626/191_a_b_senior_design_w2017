package millionkids.millionkidseducation.SQLite;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dorimouawad on 4/20/17.
 */

//Stores GameData from SQLite
public class GameData {
    Context myContext;

    //GameData Table Column Names
    private static final String QUESTIONID = "questionId";
    private static final String SCENARIOID = "scenarioId";
    private static final String QUESTIONTEXT = "questionText";
    private static final String SHOWCHILD = "showChild";
    private static final String BACKGROUNDIMAGE = "backgroundImage";
    private static final String ANSWER1 = "answer1";
    private static final String ANSWER2 = "answer2";
    private static final String ANSWER3 = "answer3";
    private static final String CORRECTANSWER = "correctAnswer";
    private static final String ANSWER1SCREEN = "answer1screen";
    private static final String ANSWER2SCREEN = "answer2screen";
    private static final String ANSWER3SCREEN = "answer3screen";
    private static final String SCORE = "score";

    //int index
    int index = 0;

    //Scenario_Path
    private static String SCENARIO_PATH = "/data/data/millionkids.millionkidseducation/databases/Scenario_";

    //Constructor Declaration
    public GameData(Context context){
        myContext = context;
    }

    //GetGameData
    public List<Game> getGameData(int scenarioId){

        //Create file proj directory if it does not exist
        File projDir = new File(SCENARIO_PATH);
        if(!projDir.exists())
            projDir.mkdir();

        //Store temp game data in a List
        List<Game> gameData = new LinkedList<Game>();

        //Build Query to get GameData
        String query = "SELECT * FROM GAMEDATA" +
                " WHERE scenarioId = ?";

        //Set query arguments
        String []queryArgs = new String[]{
                String.valueOf(scenarioId)
        };

        //MySQLiteHelper declaration
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(myContext);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

        //Prepare Query for Processing
        Cursor cursor = db.rawQuery(query, queryArgs);

        //Game declaration used to store within the GameData list that will be returned
        Game game = null;

        if(cursor.moveToNext()){
            do{
                game = new Game();
                game.setQuestionId(Integer.parseInt(cursor.getString(0)));
                game.setScenarioId(Integer.parseInt(cursor.getString(1)));
                game.setQuestionText(cursor.getString(2));
                game.setShowChild(cursor.getString(3));
                game.setBackgroundImage(cursor.getString(4));
                game.setAnswer1(cursor.getString(5));
                game.setAnswer2(cursor.getString(6));
                game.setAnswer3(cursor.getString(7));
                game.setCorrectAnswer(Integer.parseInt(cursor.getString(8)));
                game.setAnswer1text(cursor.getString(9));
                game.setAnswer2text(cursor.getString(10));
                game.setAnswer3text(cursor.getString(11));
                index++;

                //Store background image into path and set the imageDir from what is pulled
                String path = storeImages(game.getBackgroundImage());
                game.setImageDir(path);

                //Add gameData
                gameData.add(game);
            }while(cursor.moveToNext());
        }
        return gameData;
    }

    //Store images from Assets folder to Android phone
    public String storeImages(String image){
        String folderPath = SCENARIO_PATH + index + "/";
        String imagePath = image; // + "/";

        //String completePath = folderPath + imagePath;
        String completePath = SCENARIO_PATH + image;

        File projDir = new File(folderPath);
        if(!projDir.exists())
            projDir.mkdir();

        try {
            //Open image from assets folder
            InputStream inputStream = myContext.getAssets().open(image);

            //Create outputstream with the complete path
            OutputStream outputStream = new FileOutputStream(completePath);
            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return completePath;
    }
}
