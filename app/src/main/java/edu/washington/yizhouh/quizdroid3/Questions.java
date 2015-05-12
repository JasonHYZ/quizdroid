package edu.washington.yizhouh.quizdroid3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Questions extends ActionBarActivity {
    private static int myValue;
    Topic[] topicName = {new Topic(),new Topic(),new Topic()};
    //Quiz[] quizName = {new Quiz(),new Quiz(),new Quiz()};

    private static int j;
    private int selectedOption;
    private static String yourAnswer;
    TextView topic,answer;
    RadioButton r1,r2,r3,r4;
    RadioGroup radio;
    Button next,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        QuizApp quizApp = (QuizApp)getApplication();
        quizApp.readJson("topicData.json",topicName);


        Intent choice = getIntent();
        myValue = choice.getIntExtra("choice", 0);

        topic = (TextView) findViewById(R.id.question);
        answer = (TextView) findViewById(R.id.answer);
        r1 = (RadioButton) findViewById(R.id.radioc1);
        r2 = (RadioButton) findViewById(R.id.radioc2);
        r3 = (RadioButton) findViewById(R.id.radioc3);
        r4 = (RadioButton) findViewById(R.id.radioc4);


        topic.setText(topicName[myValue].getQuestion(j).getText());
        r1.setText(topicName[myValue].getQuestion(j).getAnswer1());
        r2.setText(topicName[myValue].getQuestion(j).getAnswer2());
        r3.setText(topicName[myValue].getQuestion(j).getAnswer3());
        r4.setText(topicName[myValue].getQuestion(j).getAnswer4());
        answer.setText("The correct choice is "+ topicName[myValue].getQuestion(j).getAnswer());

        radio = (RadioGroup) findViewById(R.id.radiobtn);
        next = (Button) findViewById(R.id.next);
        submit = (Button) findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedOption = radio.getCheckedRadioButtonId();

                    if (selectedOption > 0) {

                        answer.setVisibility(View.VISIBLE);

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                j++;
                                
                                if (j < topicName[myValue].getLength()-3) {

                                    Intent nextQuestion = new Intent(Questions.this, Questions.class);
                                    nextQuestion.putExtra("choice", myValue);
                                    startActivity(nextQuestion);

                                } else {
                                    j = 0;
                                    Intent back = new Intent(Questions.this, MainActivity.class);
                                    startActivity(back);
                                }


                            }
                        });
                    } else {
                        yourAnswer = "Please select one answer";
                        Toast.makeText(Questions.this, yourAnswer, Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

}
