package millionkids.millionkidseducation.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dorimouawad on 4/17/17.
 */

public class AgeGroupsData {
    Context myContext;

    //BEGIN SQLITE DATA
    //Scenarios table name
    private static final String TABLE_AGE_GROUPS = "AgeGroups";

    // AgeGroup Table Columns names
    private static final String KEY_ID = "ageId";
    private static final String KEY_GROUP = "ageGroup";
    private static final String KEY_IMAGE = "image";

    private static final String[] COLUMNS = {KEY_ID,KEY_GROUP, KEY_IMAGE};
    //END SQLITE DATA

    //Constructor Declaration
    public AgeGroupsData(Context context){
        myContext = context;
    }

    //Get AgeGroups
    public List<AgeGroups> getAgeGroups(){
        //AgeGroups List
        List<AgeGroups> ageGroups = new LinkedList<AgeGroups>();

        //Build Query to get AgeGroups
        String query = "SELECT * FROM " + TABLE_AGE_GROUPS;

        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(myContext);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

        //Prepare Query for processing
        Cursor cursor = db.rawQuery(query, null);

        //Declare single AgeGroup to read in
        AgeGroups ageGroup = null;

        //Get data from database
        if(cursor.moveToNext()){
            do{
                ageGroup = new AgeGroups();
                ageGroup.setAgeid(Integer.parseInt(cursor.getString(0)));
                ageGroup.setAgeGroup(cursor.getString(1));
                ageGroup.setImage(cursor.getString(2));

                ageGroups.add(ageGroup);
            } while (cursor.moveToNext());
        }

        //Log results of getAllScenarios
        Log.d("getAgeGroups", ageGroups.toString());

        //Return scenarios
        return ageGroups;
    }
}
