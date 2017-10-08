package com.example.sukrins.citizenship;

/**
 * Created by sukrins on 12/5/15.
 */
public class N400Question {

    private int ID;
    private String question;
    private String yes;
    private String no;
    private String answer;

    public N400Question() {
        ID = 0;
        yes = " ";
        question = " ";
        no = " ";
        answer = " ";
    }

    public N400Question(String question, String answer) {
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

    public String getYes() {

        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getNo() {

        return no;
    }

    public void setNo(String no) {

        this.no = no;
    }

    public String getAnswer() {

        return answer;
    }

    public void setAnswer(String answer) {

        this.answer = answer;
    }
}
