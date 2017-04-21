package millionkids.millionkidseducation.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dorimouawad on 4/20/17.
 */

//Stores GameData from SQLite
public class GameData {
    Context myContext;

    //BEGIN SQLITE DATA
    private static final String TABLE_GAME_DATA = "GameData";

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

    //Constructor Declaration
    public GameData(Context context){
        myContext = context;
    }

    //GetGameData
    public List<Game> getGameData(int scenarioId){
        //Store temp game data in a List
        List<Game> gameData = new LinkedList<Game>();

        //Build Query to get GameData
        String query = "SELECT * FROM " + TABLE_GAME_DATA + " WHERE  scenarioId = " + scenarioId;

        //MySQLiteHelper declaration
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(myContext);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

        //Prepare Query for Processing
        Cursor cursor = db.rawQuery(query, null);

        Game game = null;

        if(cursor.moveToNext()){
            do{
                game = new Game();

            }while(cursor.moveToNext());
        }


        return gameData;
    }



}
