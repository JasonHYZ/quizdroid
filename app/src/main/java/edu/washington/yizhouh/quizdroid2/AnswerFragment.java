package edu.washington.yizhouh.quizdroid2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AnswerFragment extends Fragment {

    private static int i,j;
    private static int cNum, totalNum;
    private static String yourAnswer;
    private Bundle choice,correct,total,yAnswer;
    TextView ans,yourAns,result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_answer, container, false);

        choice = getArguments();
        i =choice.getInt("passValue3");

        correct = getArguments();
        cNum = correct.getInt("correct");

        total = getArguments();
        totalNum = total.getInt("total");

        yAnswer = getArguments();
        yourAnswer = yAnswer.getString("answer");

        ans = (TextView) view.findViewById(R.id.ans);
        yourAns = (TextView) view.findViewById(R.id.yourans);
        result = (TextView) view.findViewById(R.id.result);


        switch(i){
            case 0:
                if(j==0) {
                    ans.setText("The answer is 8");
                    yourAns.setText("Your answer is "+yourAnswer);
                    result.setText("You have " + cNum + " out of " + totalNum + " correct");
                }else{

                    ans.setText("The answer is 12");
                    yourAns.setText("Your answer is "+yourAnswer);
                    result.setText("You have " + cNum + " out of " + totalNum + " correct");
                }
                break;
            case 1:
                if(j==0) {
                    ans.setText("The answer is G＝mg");
                    yourAns.setText("Your answer is "+yourAnswer);
                    result.setText("You have " + cNum + " out of " + totalNum + " correct");
                }else{

                    ans.setText("The answer is s=l/t");
                    yourAns.setText("Your answer is "+yourAnswer);
                    result.setText("You have " + cNum + " out of " + totalNum + " correct");
                }
                break;
            case 2:
                if(j==0) {
                    ans.setText("The answer is Galileo Galilei");
                    yourAns.setText("Your answer is "+yourAnswer);
                    result.setText("You have " + cNum + " out of " + totalNum + " correct");
                }else{

                    ans.setText("The answer is 7");
                    yourAns.setText("Your answer is "+yourAnswer);
                    result.setText("You have " + cNum + " out of " + totalNum + " correct");
                }
                break;
            default:
                break;
        }

        if(j < 1) {
            Button next = (Button) view.findViewById(R.id.next);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    j++;
                    Intent multiple = new Intent(getActivity(), MutipleActivity.class);
                    multiple.putExtra("jumpTo", 1);
                    startActivity(multiple);

                }
            });
        }else{
            Button finish = (Button) view.findViewById(R.id.next);
            finish.setText("Finish");
            finish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    j = 0;
                    i = 0;
                    Intent mainAct = new Intent(getActivity(), MainActivity.class);
                    startActivity(mainAct);
                }
            });
        }

        return view;
    }

}
