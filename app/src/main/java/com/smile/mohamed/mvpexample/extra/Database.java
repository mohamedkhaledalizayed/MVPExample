package com.smile.mohamed.mvpexample.extra;

/**
 * Created by COMPUMAGIC on 01/12/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {





    SQLiteDatabase db;
    public static final String COL_1 = "STUDENT_ID";
    public static final String COL_2 = "STUDENT_NAME";
    public static final String COL_3 = "STUDENT_PHONE";
    public static final String COL_4 = "STUDENT_ADDRESS";
    public static final String COL_5 = "STUDENT_GRADE";
    public static final String COL_6 = "STUDENT_EMAIL";

    public static final String DATABASE_NAME = "STUDENT.db";
    public static final String TABLE_NAME = "info";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_DB_TABLE="CREATE TABLE " + TABLE_NAME +" (STUDENT_ID  TEXT PRIMARY KEY," +
            "STUDENT_NAME    TEXT," +
            "STUDENT_PHONE     TEXT," +
            "STUDENT_ADDRESS  TEXT," +
            "STUDENT_GRADE   TEXT," +
            "STUDENT_EMAIL    TEXT)" ;


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertStudent(String id, String name, String phone, String address,String grade,String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,phone);
        contentValues.put(COL_4,address);
        contentValues.put(COL_5,grade);
        contentValues.put(COL_6,email);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor findStudent(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME+" where STUDENT_ID="+ id, null);
        return res;
    }
    public Integer deleteStudent(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "STUDENT_ID = ?", new String[] {id});
    }

    public Cursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }
}

