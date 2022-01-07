package com.example.textdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getQuotes() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM ingredients", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public String getIngredient(String name) {
        String ingredientdescription;
        Cursor cursor = database.rawQuery("SELECT * FROM ingredients where ingredient=?",new String[]{name});
        cursor.moveToFirst();

        if (!cursor.moveToFirst()) {
            return "Cannot found  " + name ;
        }

        ingredientdescription = cursor.getString(1) + ": " + cursor.getString(2) + " --> " + cursor.getString(3);

        cursor.close();
        return ingredientdescription;
    }

    public String[] getAllIngredient() {
        Cursor cursor = database.rawQuery("SELECT * FROM ingredients;", new String[] {});
        cursor.moveToFirst();

        Vector<String> vectorOfresoults = new Vector<String>();

        if (!cursor.moveToFirst()) {
            vectorOfresoults.add("No resoults");
            cursor.close();
            return  vectorOfresoults.toArray(new String[vectorOfresoults.size()]);
        }

        do {
            String ingredientdescription = cursor.getString(1) + ": " + cursor.getString(2) + " --> " + cursor.getString(3);
            vectorOfresoults.add(ingredientdescription);
        } while(cursor.moveToNext());
        cursor.close();

        return  vectorOfresoults.toArray(new String[vectorOfresoults.size()]);
    }

    public String addNewIngredient(int number, String name, String description) {

        String ROW1 = "INSERT INTO ingredients (ingredient, name, description) VALUES('E"
                + Integer.toString(number) + "','"
                + name + "', '"
                + description + "');";

//        Log.d("DAWID: ",  ROW1);
        database.execSQL(ROW1);

        return "Success";
    }
}
