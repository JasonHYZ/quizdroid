package edu.washington.yizhouh.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Target;


public class Questions extends ActionBarActivity {

    static String  yourAnswer;
    static int mcounter;
    static int pcounter;
    static int mshcounter;
    static int mquestionNum;
    static int pquestionNum;
    static int mshquestionNum;
    int selectedOption, myValue;
    LinearLayout math1,physics1,msh1;
    Button submit1,back1;
    RadioGroup radioMathId1,radioPhysics1,radiomsh1;
    RadioButton radioMathBtn1,radioPhysicsbtn1,radioMshbtn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);


        submit1 = (Button) findViewById(R.id.submit1);
        back1 = (Button) findViewById(R.id.back1);
        radioMathId1 = (RadioGroup) findViewById(R.id.radiomath1);
        radioPhysics1 = (RadioGroup) findViewById(R.id.radioPhysics1);
        radiomsh1 = (RadioGroup) findViewById(R.id.radiomsh1);

        Intent topics = getIntent();
        myValue = topics.getIntExtra("question",0);
        switch(myValue){
            case 0:
                math1 = (LinearLayout) findViewById(R.id.math1);
                math1.setVisibility(View.VISIBLE);
                break;
            case 1:
                physics1 = (LinearLayout) findViewById(R.id.physics1);
                physics1.setVisibility(View.VISIBLE);
                break;
            case 2:
                msh1 = (LinearLayout) findViewById(R.id.msh1);
                msh1.setVisibility(View.VISIBLE);
                break;
        }

        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(myValue){
                    case 0:
                        selectedOption = radioMathId1.getCheckedRadioButtonId();
                        break;
                    case 1:
                        selectedOption = radioPhysics1.getCheckedRadioButtonId();
                        break;
                    case 2:
                        selectedOption = radiomsh1.getCheckedRadioButtonId();
                        break;
                }
                if(selectedOption > 0){
                    switch(myValue){
                        case 0:
                            mquestionNum++;
                            radioMathBtn1 = (RadioButton) findViewById(selectedOption);
                            yourAnswer = radioMathBtn1.getText().toString();
                            break;
                        case 1:
                            pquestionNum++;
                            radioPhysicsbtn1 = (RadioButton) findViewById(selectedOption);
                            yourAnswer = radioPhysicsbtn1.getText().toString();
                            break;
                        case 2:
                            mshquestionNum++;
                            radioMshbtn1 = (RadioButton) findViewById(selectedOption);
                            yourAnswer = radioMshbtn1.getText().toString();
                            break;
                    }

                    Intent question = new Intent(Questions.this, Answers.class);
                    switch(myValue){
                        case 0:
                            question.putExtra("topics",myValue);
                            break;
                        case 1:
                            question.putExtra("topics",myValue);
                            break;
                        case 2:
                            question.putExtra("topics",myValue);
                            break;
                    }
                    startActivity(question);
                    switch(selectedOption) {
                        case R.id.m1radioq1:
                            mcounter++;
                            break;
                        case R.id.p1radioq1:
                            pcounter++;
                            break;
                        case R.id.msh1radioq1:
                            mshcounter++;
                            break;
                    }
                }else{
                    yourAnswer = "Please select one answer";
                    Toast.makeText(Questions.this,yourAnswer,Toast.LENGTH_SHORT).show();

                }
            }
        });

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back1 = new Intent(Questions.this, MainActivity.class);
                startActivity(back1);
                switch (myValue) {
                    case 0:
                        mquestionNum=0;
                        mcounter=0;
                        break;
                    case 1:
                        pquestionNum=0;
                        pcounter=0;
                        break;
                    case 2:
                        mshquestionNum=0;
                        mshcounter=0;
                        break;
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
