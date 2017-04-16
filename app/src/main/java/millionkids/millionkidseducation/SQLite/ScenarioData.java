package millionkids.millionkidseducation.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import java.util.List;

/**
 * Created by dorimouawad on 4/15/17.
 */

//This file will pull the Scenario Data from the SQLite 'MillionKids.db' file.
public class ScenarioData{

    //Select_Sql: Variable query that will select the data for a specific scenario
    private static final String SELECT_SQL = "SELECT * FROM Scenarios WHERE ";

    //To access MySQLiteHelper methods for use within this file
    MySQLiteHelper sqLiteHelper;

    //SQLiteDatabase variable declaration to access database
    private SQLiteDatabase database = sqLiteHelper.getReadableDatabase();

    Context myContext;

    //BEGIN SQLITE DATA
    // Scenarios table name
    private static final String TABLE_SCENARIOS = "Scenarios";

    // Scenarios Table Columns names
    private static final String KEY_ID = "scenarioid";
    private static final String KEY_AGEID = "ageid";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_IMAGE = "image";

    private static final String[] COLUMNS = {KEY_ID,KEY_AGEID,KEY_LOCATION, KEY_IMAGE};
    //END SQLITE DATA

    //Constructor Declaration
    public ScenarioData(Context context){
        myContext = context;
    }

    public List<Scenario> getScenarios(){
        return null;
    }
}
