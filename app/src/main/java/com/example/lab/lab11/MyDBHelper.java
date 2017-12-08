package com.example.lab.lab11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;


public class MyDBHelper extends SQLiteOpenHelper{

    private static final String database = "mydata.db";
    private static final int version = 1;

    public MyDBHelper(Context context , String name ,SQLiteDatabase.CursorFactory factory
        , int version){
        super(context , name , factory , version);
    }

    public MyDBHelper(Context context){
        this(context , database , null , version);
    }

    @Override
    public  void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE myTable(_id integer primary key autoincrement," +
        "title text no null ," +
        "price real no null )");
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db,int oldVersion , int newVersion){

        db.execSQL("DROP TABLE IF  EXISTS  myTable" );
        onCreate(db);
    }
}
