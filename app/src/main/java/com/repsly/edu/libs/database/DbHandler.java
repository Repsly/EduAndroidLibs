package com.repsly.edu.libs.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 */
public class DbHandler extends SQLiteOpenHelper {

    public DbHandler(Context context) {
        super(context, "eventBusDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Drool(id INTEGER PRIMARY KEY, ime TEXT, broj TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Drool");
        onCreate(db);
    }

    public String getDrool(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("Drool", new String[]{"ime, broj"},"id=?", new String[]{String.valueOf(id)}, null, null, null, null);
        String hoy = "";
        if (c != null) {
            c.moveToFirst();
            hoy = c.getString(c.getColumnIndex("ime")) + " " + c
                    .getString(c.getColumnIndex("broj"));
            c.close();
        }
        return hoy;
    }

    public String getFirstDrool() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query("Drool", null, null, null, null, null, null, null);
        String hoy = "";
        if (c != null) {
            c.moveToFirst();
            hoy = c.getString(c.getColumnIndex("ime")) + " " + c
                    .getString(c.getColumnIndex("broj"));
            c.close();
        }
        return hoy;
    }

    public void saveDrool(String ime, String broj) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ime", ime);
        cv.put("broj", broj);
        db.insert("Drool", null, cv);
        db.close();
    }
}
