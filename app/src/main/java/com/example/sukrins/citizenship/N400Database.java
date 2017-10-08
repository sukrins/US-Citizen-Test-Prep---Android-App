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
public class N400Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "N400 Questions";
    private static final String TABLE_N400QUESTIONS = "n400Questions";
    private static final String KEY_ID = "id";
    private static final String KEY_QUESTION = "questions";
    private static final String KEY_YES = "yes";
    private static final String KEY_NO = "no";
    private static final String KEY_ANSWER = "answer";

    private SQLiteDatabase database;

    public N400Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_N400_TABLE = "CREATE TABLE n400Questions ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "questions TEXT, " +
                "yes TEXT, " +
                "no TEXT, " +
                "answer TEXT)";

        db.execSQL(CREATE_N400_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS n400Questions");
        this.onCreate(db);
    }

    public void addQuestion(N400Question question){

        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, question.getQuestion());
        values.put(KEY_YES, question.getYes());
        values.put(KEY_NO, question.getNo());
        values.put(KEY_ANSWER, question.getAnswer());

        database.insert(TABLE_N400QUESTIONS, null, values);

    }

    public List<N400Question> getAllQuestions(){

        List<N400Question> questions = new ArrayList<N400Question>();

        String query = "SELECT * FROM " + TABLE_N400QUESTIONS;

        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        N400Question n400Question = null;
        if(cursor.moveToFirst()){
            do{
                n400Question = new N400Question();
                n400Question.setID(cursor.getInt(0));
                n400Question.setQuestion(cursor.getString(1));
                n400Question.setYes(cursor.getString(2));
                n400Question.setNo(cursor.getString(3));
                n400Question.setAnswer(cursor.getString(4));

                questions.add(n400Question);
            } while (cursor.moveToNext());
        }
        return questions;

    }

    public void deleteQuestion(N400Question question) {
       database = this.getWritableDatabase();

        database.delete(TABLE_N400QUESTIONS, KEY_ID + " = ?",
                new String[]{String.valueOf(question.getID())});
        database.close();
        Log.d("deleteBook", question.toString());
    }

}
