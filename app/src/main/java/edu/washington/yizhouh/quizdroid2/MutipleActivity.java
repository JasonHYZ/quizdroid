package edu.washington.yizhouh.quizdroid2;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.TextView;

public class MutipleActivity extends FragmentActivity implements QuestionFragment.SendValue {

    private static int position,jumpTo = 0;
    private static int cNum,totalNum;
    private static String yourAnswer;

    Fragment startQFragment,startAFragment,startOvFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutiple);

        Intent choice = getIntent();
        position = choice.getIntExtra("choice",position);

        Intent swap = getIntent();
        jumpTo = swap.getIntExtra("jumpTo",0);

        switch(jumpTo) {
            case 0:
                startOvFragment = passValueToOv(position);
                switchToOv();
                break;
            case 1:
                startQFragment = passValueToQ(position);
                switchToQ();
                break;
            case 2:
                startAFragment = passValueToA(position);
                switchToA();
                break;
            default:
                break;

        }


    }

    private Fragment passValueToOv(int position){
        Bundle bundle = new Bundle();
        bundle.putInt("passValue1",position);

        OvFragment topicOverview = new OvFragment();
        topicOverview.setArguments(bundle);
        return topicOverview;
    }

    private void switchToOv(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in,R.anim.slide_out)
                .add(R.id.show,startOvFragment)
                .commit();
    }

    private Fragment passValueToQ(int position){
        Bundle bundle = new Bundle();
        bundle.putInt("passValue2",position);

        QuestionFragment question = new QuestionFragment();
        question.setArguments(bundle);
        return question;
    }

    private void switchToQ(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in,R.anim.slide_out)
                .add(R.id.show,startQFragment)
                .commit();
    }

    private Fragment passValueToA(int position){
        Bundle bundle = new Bundle();
        bundle.putInt("passValue3",position);
        bundle.putInt("correct",cNum);
        bundle.putInt("total",totalNum);
        bundle.putString("answer",yourAnswer);

        AnswerFragment answer = new AnswerFragment();
        answer.setArguments(bundle);
        return answer;
    }

    private void switchToA(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in,R.anim.slide_out)
                .replace(R.id.show, startAFragment)
                .commit();
    }


    @Override
    public void passData(int correct, int total, String answer) {
        this.cNum = correct;
        this.totalNum = total;
        this.yourAnswer = answer;


    }
}
