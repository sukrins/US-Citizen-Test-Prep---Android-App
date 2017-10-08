package com.example.sukrins.citizenship;

/**
 * Created by sukrins on 12/5/15.
 */
public class CivicQuestion {

    private int ID;
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private String answer;

    public CivicQuestion(){
        ID = 0;
        question = " ";
        a = " ";
        b = " ";
        c = " ";
        d = " ";
        answer = " ";
    }


    public CivicQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
