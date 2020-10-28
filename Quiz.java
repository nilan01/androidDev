package com.example.assignment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Quiz {
    //Globl Variables
    Questions Q1 = new Questions(R.string.q1);
    Questions Q2 = new Questions(R.string.q2);
    Questions Q3 = new Questions(R.string.q3);
    Questions Q4 = new Questions(R.string.q4);
    Questions Q5 = new Questions(R.string.q5);

    int NUMBEROFQUESTIONS = 5;

    ArrayList<Questions> questions = new ArrayList<Questions>(NUMBEROFQUESTIONS);
    int score = 0;
    int numberOfQuestionsAns = 0;

    public Quiz(){
        questions.add(Q1); //true
        questions.add(Q2); //false
        questions.add(Q3); //true
        questions.add(Q4); //true
        questions.add(Q5); //false
    }

    public int getNextQuestion(int i){
        return questions.get(i).question;
    }

    public boolean answeredTrue(){
        boolean flag = false;
        while(numberOfQuestionsAns < NUMBEROFQUESTIONS){
            if (questions.get(numberOfQuestionsAns).equals(Q1)){
                score++;
                System.out.println(score);
                flag = true;
                return flag;
                //break;
            }else if(questions.get(numberOfQuestionsAns).equals(Q3)){
                score++;
                System.out.println(score);
                flag = true;
                return flag;
                //break;
            }else if(questions.get(numberOfQuestionsAns).equals(Q4)){
                score++;
                System.out.println(score);
                flag = true;
                return flag;
                //break;
            }else{
                return flag;
                //break;
            }
        }
        return flag;
    }

    public boolean answeredFalse(){
        boolean flag = false;
        while(numberOfQuestionsAns < NUMBEROFQUESTIONS){
            if (questions.get(numberOfQuestionsAns).equals(Q2)){
                score++;
                System.out.println(score);
                flag = true;
                return flag;
                //break;
            }else if(questions.get(numberOfQuestionsAns).equals(Q5)){
                score++;
                System.out.println(score);
                flag = true;
                return flag;
                //break;
            }else{
                return flag;
                //break;
            }
        }
        return flag;
    }

    public void cancelPressed(){
        questions.clear();
        questions.add(Q1); //true
        questions.add(Q2); //false
        questions.add(Q3); //true
        questions.add(Q4); //true
        questions.add(Q5); //false
    }
}
