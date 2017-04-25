package millionkids.millionkidseducation.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dorimouawad on 4/15/17.
 */

//This file will pull the Scenario Data from the SQLite 'MillionKids.db' file.
public class ScenarioData{

    //Select_Sql: Variable query that will select the data for a specific scenario
    private static final String SELECT_SQL = "SELECT * FROM Scenarios WHERE ";

    Context myContext;

    //BEGIN SQLITE DATA
    // Scenarios table name
    private static final String TABLE_SCENARIOS = "Scenarios";

    // Scenarios Table Columns names
    private static final String KEY_ID = "scenarioId";
    private static final String KEY_AGEID = "ageId";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_IMAGE = "image";

    private static final String[] COLUMNS = {KEY_ID,KEY_AGEID,KEY_LOCATION, KEY_IMAGE};
    //END SQLITE DATA

    //Constructor Declaration
    public ScenarioData(Context context){
        myContext = context;
    }

    //Get Scenarios
    public List<Scenario> getScenarios(int ageId){
        //Scenarios List
        List<Scenario> scenarios = new LinkedList<Scenario>();

        //Build Query to get Scenarios
        String query = "SELECT * FROM SCENARIOS " +
                "WHERE ageId = ?";

        //Set query arguments
        String []queryArgs = new String[]{
                String.valueOf(ageId)
        };

        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(myContext);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

        //Prepare Query for processing
        Cursor cursor = db.rawQuery(query, queryArgs);

        //Declare scenarios
        Scenario scenario = null;

        //Get data from database
        if(cursor.moveToNext()){
            do{
                scenario = new Scenario();
                scenario.setScenarioid(Integer.parseInt(cursor.getString(0)));
                scenario.setAgeid(Integer.parseInt(cursor.getString(1)));
                scenario.setLocation(cursor.getString(2));
                scenario.setImage(cursor.getString(3));

                scenarios.add(scenario);
            } while (cursor.moveToNext());
        }

        //Return scenarios
        return scenarios;
    }
}
