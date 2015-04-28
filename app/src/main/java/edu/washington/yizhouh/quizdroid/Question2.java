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
import android.widget.Toast;


public class Question2 extends ActionBarActivity {
    static String  yourAnswer;
    int selectedOption, myValue;
    Button submit2,back2;
    LinearLayout math2,physics2,msh2;
    RadioGroup radioMathId2,radioPhysicsId2,radiomshId2;
    RadioButton radioMathBtn2,radioPhysicsbtn2,radioMshbtn2;
    Questions questions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        submit2 = (Button) findViewById(R.id.submit2);
        back2 = (Button) findViewById(R.id.back2);
        radioMathId2 = (RadioGroup) findViewById(R.id.radiomath2);
        radioPhysicsId2 = (RadioGroup) findViewById(R.id.radiophysics2);
        radiomshId2 = (RadioGroup) findViewById(R.id.radiomsh2);

        Intent topics = getIntent();
        myValue = topics.getIntExtra("question2",0);
        switch(myValue){
            case 0:
                math2 = (LinearLayout) findViewById(R.id.math2);
                math2.setVisibility(View.VISIBLE);
                break;
            case 1:
                physics2 = (LinearLayout) findViewById(R.id.physics2);
                physics2.setVisibility(View.VISIBLE);
                break;
            case 2:
                msh2 = (LinearLayout) findViewById(R.id.msh2);
                msh2.setVisibility(View.VISIBLE);
                break;

        }

        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(myValue){
                    case 0:
                        selectedOption = radioMathId2.getCheckedRadioButtonId();
                        break;
                    case 1:
                        selectedOption = radioPhysicsId2.getCheckedRadioButtonId();
                        break;
                    case 2:
                        selectedOption = radiomshId2.getCheckedRadioButtonId();
                        break;
                }
                if(selectedOption > 0){
                    switch(myValue){
                        case 0:
                            questions.mquestionNum++;
                            radioMathBtn2 = (RadioButton) findViewById(selectedOption);
                            yourAnswer = radioMathBtn2.getText().toString();
                            break;
                        case 1:
                            questions.pquestionNum++;
                            radioPhysicsbtn2 = (RadioButton) findViewById(selectedOption);
                            yourAnswer = radioPhysicsbtn2.getText().toString();
                            break;
                        case 2:
                            questions.mshquestionNum++;
                            radioMshbtn2 = (RadioButton) findViewById(selectedOption);
                            yourAnswer = radioMshbtn2.getText().toString();
                            break;
                    }


                    Intent question = new Intent(Question2.this, Answers2.class);
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
                        case R.id.m2radioq3:
                            questions.mcounter++;
                            break;
                        case R.id.p2radioq1:
                            questions.pcounter++;
                            break;
                        case R.id.msh2radioq4:
                            questions.mshcounter++;
                            break;
                    }
                }else{
                    yourAnswer = "Please select one answer";
                    Toast.makeText(Question2.this, yourAnswer, Toast.LENGTH_SHORT).show();

                }
            }
        });

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back2 = new Intent(Question2.this,Questions.class);
                switch(myValue){
                    case 0:
                        back2.putExtra("question",myValue);
                        break;
                    case 1:
                        back2.putExtra("question",myValue);
                        break;
                    case 2:
                        back2.putExtra("question",myValue);
                        break;
                }
                startActivity(back2);

                switch(myValue){
                    case 0:
                        questions.mquestionNum=0;
                        questions.mcounter=0;
                        break;
                    case 1:
                        questions.pquestionNum=0;
                        questions.pcounter=0;
                        break;
                    case 2:
                        questions.mshquestionNum=0;
                        questions.mshcounter=0;
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question2, menu);
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
