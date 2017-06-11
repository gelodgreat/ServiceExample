package com.gelo.serviceexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Angelo Umali on 6/11/2017.
 */

public class TheDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TestDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_TEST = "tabletest";
    private static final String COL1 = "id";
    private static final String COL2 = "fname";
    private static final String COL3 = "lname";

    private static final String CREATE_TEST_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_TEST + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " VARCHAR(50), " + COL3 + " VARCHAR(50))";
    private static final String DELETE_TABLE_TEST = "DELETE FROM " + TABLE_TEST;
    private static final String DROPTABLE = "DROP TABLE IF EXISTS " + TABLE_TEST;

    public TheDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TEST_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEST);
        onCreate(db);
    }

    public boolean insertData(String fname, String lname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, fname);
        contentValues.put(COL3, lname);

        long result = db.insert(TABLE_TEST, null, contentValues);
        if (result == -1) {
            return false;

        } else {
            return true;
        }
    }

    public void truncatetable() {

        SQLiteDatabase db = this.getWritableDatabase();
        //        db.execSQL(DELETE_TABLE_TEST);
        //        db.execSQL("vacuum");
        db.execSQL(DROPTABLE);
        db.execSQL(CREATE_TEST_TABLE);


    }
}
