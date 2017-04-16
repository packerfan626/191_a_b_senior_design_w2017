package millionkids.millionkidseducation.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

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
    
    //Constructor Declaration
    public ScenarioData(Context context){
        myContext = context;
    }

    protected void openDatabase(){

    }
}
