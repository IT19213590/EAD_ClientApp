package com.example.fuelapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.fuelapp.models.Login;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "fuel.db";
    private static final  String TAG = "DatabaseHelper";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER =
                "CREATE TABLE " + DBMaster.Register.TABLE_NAME + "(" +
                        DBMaster.Register._ID + " INTEGER PRIMARY KEY," +
                        DBMaster.Register.COLUMN_USER_NAME + " TEXT," +
                        DBMaster.Register.COLUMN_PASSWORD + " TEXT )";

        sqLiteDatabase.execSQL(CREATE_USER);

    }

    public long InitialRecorde(String username, String password) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DBMaster.Register.COLUMN_USER_NAME, username);
        cv.put(DBMaster.Register.COLUMN_PASSWORD, password);


        return db.insert(DBMaster.Register.TABLE_NAME, null, cv);
    }

    public long updateeExistingRecorde(String UserName , String NewPassword) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        String id = "1";
        cv.put(DBMaster.Register.COLUMN_PASSWORD, NewPassword);
        cv.put(DBMaster.Register.COLUMN_USER_NAME,UserName);
        Log.e(TAG, "updateid: " + 1 + " password " +NewPassword );
        return  db.update(DBMaster.Register.TABLE_NAME,cv, "_id = ?", new String[]{id});



    }

    public  boolean actionRegister(String uName,String pword){
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user_table",null,null);

        if(cursor.getCount() == 0){
            long result =InitialRecorde(uName,pword);
            if(result>0) {
                return true;
            }else{
                return false;
            }

        }else  {
            while(cursor.moveToNext()){
                String userName = cursor.getString(1);
                String password = cursor.getString(2);

                if(!(userName.equals(uName)) && !(password.equals(pword))){
                    updateeExistingRecorde(uName ,pword);
                    return true;

                }else {
                    return true;
                }
        }

        }
        return false;
    }


    public Cursor getcredencials (){
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user_table",null,null);
        return cursor;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
