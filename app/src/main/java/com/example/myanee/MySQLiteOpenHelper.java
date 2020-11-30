package com.example.myanee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    final static String DATABAENAME="factory.db";
    final static String TABLENAME="stage";
    final static String COLID="id";
    final static String COLNUM="num";
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table stage("+
                MySQLiteOpenHelper.COLID+" integer primary key autoincrement,"+
                MySQLiteOpenHelper.COLNUM+" text)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
