package com.example.clubolympus.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.clubolympus.data.ClubOlympusContract.MemberEntry;


import androidx.annotation.Nullable;

public class OlympusDbHelper extends SQLiteOpenHelper {

    public OlympusDbHelper(@Nullable Context context) {
        super(context, ClubOlympusContract.DATABASE_NAME, null, ClubOlympusContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEMBERS_TABLE = "CREATE TABLE " + MemberEntry.TABLE_NAME + "(" + MemberEntry.KEY_ID + " INTEGER PRIMARY KEY," + MemberEntry.KEY_FIRST_NAME + " TEXT," + MemberEntry.KEY_LAST_NAME + " TEXT," + MemberEntry.KEY_GENDER + " INTEGER NOT NULL," + " TEXT," + MemberEntry.KEY_SPORT + " TEXT" + ")";

        db.execSQL(CREATE_MEMBERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ClubOlympusContract.DATABASE_NAME);
        onCreate(db);
    }
}
