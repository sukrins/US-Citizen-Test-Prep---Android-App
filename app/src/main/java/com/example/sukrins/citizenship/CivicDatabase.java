package com.example.sukrins.citizenship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sukrins on 12/5/15.
 */
public class CivicDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "CIVIC Questions";
    private static final String TABLE_CIVICQUESTIONS = "civicQuestions";
    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "questions";
    private static final String KEY_A = "a";
    private static final String KEY_B = "b";
    private static final String KEY_C = "c";
    private static final String KEY_D = "d";
    private static final String KEY_ANSWER = "answer";

    private SQLiteDatabase database;

    public CivicDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CIVIC_TABLE = "CREATE TABLE civicQuestions ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "questions TEXT, " +
                "a TEXT, " +
                "b TEXT, " +
                "c TEXT, " +
                "d TEXT, " +
                "answer TEXT)";

        db.execSQL(CREATE_CIVIC_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS civicQuestions");
        this.onCreate(db);
    }


    public void addQuestion(CivicQuestion question){

        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, question.getQuestion());
        values.put(KEY_A, question.getA());
        values.put(KEY_B, question.getB());
        values.put(KEY_C, question.getC());
        values.put(KEY_D, question.getD());
        values.put(KEY_ANSWER, question.getAnswer());

        database.insert(TABLE_CIVICQUESTIONS, null, values);

    }

    public List<CivicQuestion> getAllQuestions(){

        List<CivicQuestion> questions = new ArrayList<CivicQuestion>();

        String query = "SELECT * FROM " + TABLE_CIVICQUESTIONS;

        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        CivicQuestion civicQuestion = null;
        if(cursor.moveToFirst()){
            do{
                civicQuestion = new CivicQuestion();
                civicQuestion.setID(cursor.getInt(0));
                civicQuestion.setQuestion(cursor.getString(1));
                civicQuestion.setA(cursor.getString(2));
                civicQuestion.setB(cursor.getString(3));
                civicQuestion.setC(cursor.getString(4));
                civicQuestion.setD(cursor.getString(5));
                civicQuestion.setAnswer(cursor.getString(6));

                questions.add(civicQuestion);
            } while (cursor.moveToNext());
        }
        return questions;

    }

    public void deleteQuestion(CivicQuestion question) {
        database = this.getWritableDatabase();

        database.delete(TABLE_CIVICQUESTIONS, KEY_ID + " = ?",
                new String[]{String.valueOf(question.getID())});
        database.close();
        Log.d("deleteBook", question.toString());
    }

}
