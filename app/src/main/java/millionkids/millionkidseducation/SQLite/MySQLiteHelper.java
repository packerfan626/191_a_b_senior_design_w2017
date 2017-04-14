package millionkids.millionkidseducation.SQLite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dorimouawad on 4/12/17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    private Context myContext;
    private static String DB_PATH = "/data/data/millionkids.millionkidseducation/databases/";

    //Variable for Database name
    private static final String DB_NAME = "MillionKids.db";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase database = null;

    //Constructor for MySQLiteHelper
    public MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        myContext = context;
    }

    public void createDatabase() throws IOException{
        boolean dbExists = checkDataBase();

        if(dbExists){
            //Do nothing
        }else{
            //Open database MillionKids.db SQLite file from assets directory and import into database.
            this.getReadableDatabase();
            try{
                importDatabase();
            }catch (IOException e){
                throw new Error("Error copying database");
            }
        }
    }

    //Open the SQLiteDatabase
    public void openDatabase() throws SQLException{
        String myPath = DB_PATH + DB_NAME;
        database = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    //Close the database (If needed)
    public synchronized void close() {
        if(database != null)
            database.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Checks if database exists
    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){
            //database does't exist yet.
        }

        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    //Import pre-made database from SQLite file
    private void importDatabase() throws IOException {
        InputStream inputStream = myContext.getAssets().open(DB_NAME);

        String fileName = DB_PATH + DB_NAME;

        OutputStream outputStream = new FileOutputStream(fileName);

        byte[] buffer = new byte[1024];

        int length;

        while ((length = inputStream.read(buffer)) > 0){
            outputStream.write(buffer, 0, length);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
