package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GoQuiz.db";
    private static final int DATBASE_VERSION = 1;

    private SQLiteDatabase db;


    QuizDbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATBASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizConact.QuestionTable.TABLE_NAME + " ( " +
                QuizConact.QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizConact.QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuizConact.QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuizConact.QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuizConact.QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuizConact.QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuizConact.QuestionTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuizConact.QuestionTable.TABLE_NAME);
        onCreate(db);

    }


    private void fillQuestionsTable()
    {

        Questions q1 = new Questions("Android is what ?","OS","Drivers","Software","Hardware",1);
        addQuestions(q1);


        Questions q2 = new Questions("Full form of PC is ?","OS","Personal Computer","Pocket Computer","Hardware",2);
        addQuestions(q2);


        Questions q3 = new Questions("Windows is what ?","Easy Software","Hardware Device","Operating System","Hardware",3);
        addQuestions(q3);


        Questions q4 = new Questions("Unity is used for what ?","Game Development","Movie Making","Firmware","Hardware",1);
        addQuestions(q4);


        Questions q5 = new Questions("RAM stands for ","Windows","Drivers","GUI","Random Access Memory",4);
        addQuestions(q5);


        Questions q6 = new Questions("Chrome is what ?","OS","Browser","Tool","New Browser",2);
        addQuestions(q6);
    }

    private void addQuestions(Questions question){

        ContentValues cv = new ContentValues();
        cv.put(QuizConact.QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuizConact.QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuizConact.QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuizConact.QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuizConact.QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuizConact.QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        db.insert(QuizConact.QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<Questions> getAllQuestions() {

        ArrayList<Questions> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuizConact.QuestionTable._ID,
                QuizConact.QuestionTable.COLUMN_QUESTION,
                QuizConact.QuestionTable.COLUMN_OPTION1,
                QuizConact.QuestionTable.COLUMN_OPTION2,
                QuizConact.QuestionTable.COLUMN_OPTION3,
                QuizConact.QuestionTable.COLUMN_OPTION4,
                QuizConact.QuestionTable.COLUMN_ANSWER_NR
        };



        Cursor c = db.query(QuizConact.QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                Questions question = new Questions();
                question.setQuestion(c.getString(c.getColumnIndex(QuizConact.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizConact.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizConact.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizConact.QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizConact.QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizConact.QuestionTable.COLUMN_ANSWER_NR)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;

    }

}


