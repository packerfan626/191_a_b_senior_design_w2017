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
        String query = "SELECT * FROM " + TABLE_GAME_DATA +
                " WHERE  scenarioId = ?";

        //Set query arguments
        String []queryArgs = new String[]{
                String.valueOf(scenarioId)
        };

        //MySQLiteHelper declaration
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(myContext);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

        //Prepare Query for Processing
        Cursor cursor = db.rawQuery(query, queryArgs);

        Game game = null;

        if(cursor.moveToNext()){
            do{
                game = new Game();
                game.setQuestionId(Integer.parseInt(cursor.getString(0)));
                game.setScenarioId(Integer.parseInt(cursor.getString(1)));
                game.setQuestionText(cursor.getString(2));
                game.setShowChild(Integer.parseInt(cursor.getString(3)));
                game.setBackgroundImage(cursor.getString(4));
                game.setAnswer1(cursor.getString(5));
                game.setAnswer2(cursor.getString(6));
                game.setAnswer3(cursor.getString(7));
                game.setCorrectAnswer(Integer.parseInt(cursor.getString(8)));
                game.setAnswer1text(cursor.getString(9));
                game.setAnswer2text(cursor.getString(10));
                game.setAnswer3text(cursor.getString(11));
            }while(cursor.moveToNext());
        }
        return gameData;
    }
}
