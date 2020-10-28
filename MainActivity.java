package com.example.assignment1;

import android.app.DialogFragment;
import android.os.Bundle;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import org.w3c.dom.Text;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    TextView questionsText;
    Button trueButton;
    Button falseButton;
    AlertDialog.Builder builder;
    ProgressBar progressBar;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();


        FragmentQuestion thirdFragmentObject = (FragmentQuestion) fm.findFragmentById(R.id.swich_area_for_fragments);
        androidx.fragment.app.FragmentTransaction transaction = fm.beginTransaction();
        if(thirdFragmentObject != null){

            FragmentQuestion questionFrag = FragmentQuestion.newInstance("IT'S THE OG", 3);


            getSupportFragmentManager().beginTransaction().replace(R.id.swich_area_for_fragments, questionFrag).addToBackStack(null).commit();

        }else{
            transaction.remove(thirdFragmentObject);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        }
        transaction.commit();

        questionsText = (TextView)findViewById(R.id.textView2);
        trueButton = (Button)findViewById(R.id.trueButtonId);
        falseButton = (Button)findViewById(R.id.falseButtonId);
        builder = new AlertDialog.Builder(this);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);




        progressBar.setMax(5);

        final Quiz quiz = new Quiz();
        questionsText.setText(quiz.questions.get(0).question);
        final int numQuestions = quiz.questions.size();


        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!quiz.answeredTrue()){
                    Toast.makeText(getApplicationContext(),"Incorrect", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Correct", Toast.LENGTH_SHORT).show();
                }
                quiz.numberOfQuestionsAns++;
                progressBar.incrementProgressBy(1);
                if(quiz.numberOfQuestionsAns < quiz.NUMBEROFQUESTIONS){
                    questionsText.setText(quiz.questions.get(quiz.numberOfQuestionsAns).question);
                }

                if (quiz.numberOfQuestionsAns == quiz.NUMBEROFQUESTIONS){
                    builder.setMessage("Your score is: " + quiz.score + " out of " + numQuestions)
                            .setCancelable(true)
                            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    quiz.cancelPressed();
                                    quiz.numberOfQuestionsAns = 0;
                                    quiz.score = 0;
                                    questionsText.setText(quiz.questions.get(0).question);
                                }
                            })
                            .setPositiveButton("REPEAT", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    quiz.numberOfQuestionsAns = 0;
                                    quiz.score = 0;
                                    Collections.shuffle(quiz.questions);
                                    questionsText.setText(quiz.questions.get(0).question);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Result");
                    alert.show();
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!quiz.answeredFalse()){
                    Toast.makeText(getApplicationContext(),"Incorrect", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Correct", Toast.LENGTH_SHORT).show();
                }
                quiz.numberOfQuestionsAns++;
                progressBar.incrementProgressBy(1);
                if(quiz.numberOfQuestionsAns < quiz.NUMBEROFQUESTIONS){
                    questionsText.setText(quiz.questions.get(quiz.numberOfQuestionsAns).question);
                }

                if (quiz.numberOfQuestionsAns == quiz.NUMBEROFQUESTIONS){
                    builder.setMessage("Your score is: " + quiz.score + " out of " + numQuestions)
                            .setCancelable(true)
                            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    quiz.cancelPressed();
                                    quiz.numberOfQuestionsAns = 0;
                                    quiz.score = 0;
                                    questionsText.setText(quiz.questions.get(0).question);
                                }
                            })
                            .setPositiveButton("REPEAT", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    quiz.numberOfQuestionsAns = 0;
                                    quiz.score = 0;
                                    Collections.shuffle(quiz.questions);
                                    questionsText.setText(quiz.questions.get(0).question);
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Result");
                    alert.show();
                }
            }
        });
    }
}