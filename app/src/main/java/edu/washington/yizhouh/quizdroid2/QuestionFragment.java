package edu.washington.yizhouh.quizdroid2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class QuestionFragment extends Fragment {

    private static int i,j;
    private static int mcAnswer;
    private int selectedOption;
    private static String yourAnswer;
    TextView topic;
    RadioButton r1,r2,r3,r4,rChoice;
    RadioGroup radio;
    SendValue send;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_question, container, false);
        Bundle bundle=getArguments();
        i =bundle.getInt("passValue2");

        topic = (TextView) view.findViewById(R.id.question);
        r1 = (RadioButton) view.findViewById(R.id.radioc1);
        r2 = (RadioButton) view.findViewById(R.id.radioc2);
        r3 = (RadioButton) view.findViewById(R.id.radioc3);
        r4 = (RadioButton) view.findViewById(R.id.radioc4);

        switch(i){
            case 0:
                if(j==0) {
                    topic.setText("3 + 5 = ?");
                    r1.setText("8");
                    r2.setText("7");
                    r3.setText("6");
                    r4.setText("5");
                }else{
                    topic.setText("2 x 6 = ?");
                    r1.setText("9");
                    r2.setText("10");
                    r3.setText("11");
                    r4.setText("12");
                }
                break;
            case 1:
                if(j==0) {
                    topic.setText("What is the gravity formula? g=9.8N/kg");
                    r1.setText("G＝mg");
                    r2.setText("G=m/g");
                    r3.setText("G=m+g");
                    r4.setText("G=m-g");
                }else{
                    topic.setText("What is the speed formula?");
                    r1.setText("s=l/t");
                    r2.setText("s=lxt");
                    r3.setText("s=l+t");
                    r4.setText("s=l-t");
                }
                break;
            case 2:
                if(j==0) {
                    topic.setText("Which people is not the marvel super hero?");
                    r1.setText("Galileo Galilei");
                    r2.setText("Bartolomeu Dias");
                    r3.setText("Zhenghe");
                    r4.setText("Cristoforo Colombo");
                }else{
                    topic.setText("How many times has Zhenghe traveled to the West Ocean?");
                    r1.setText("10");
                    r2.setText("9");
                    r3.setText("8");
                    r4.setText("7");
                }
                break;
        }


        radio = (RadioGroup) view.findViewById(R.id.radiobtn);
        Button submit = (Button) view.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption = radio.getCheckedRadioButtonId();

                if (selectedOption > 0) {
                    rChoice = (RadioButton) view.findViewById(selectedOption);
                    yourAnswer = rChoice.getText().toString();

                    switch (i) {
                        case 0:
                            if (j == 0 && yourAnswer == "8") {
                                mcAnswer++;
                            } else if (j == 1 && yourAnswer == "12") {
                                mcAnswer++;
                            }
                            break;
                        case 1:
                            if (j == 0 && yourAnswer == "G＝mg") {
                                mcAnswer++;
                            } else if (j == 1 && yourAnswer == "s=l/t") {
                                mcAnswer++;
                            }
                            break;
                        case 2:
                            if (j == 0 && yourAnswer == "Galileo Galilei") {
                                mcAnswer++;
                            } else if (j == 1 && yourAnswer == "7") {
                                mcAnswer++;
                            }
                            break;
                    }
                    j++;
                    send.passData(mcAnswer, j, yourAnswer);

                    if(j == 2){
                        j = 0 ;
                        mcAnswer = 0;
                    }

                    Intent multiple = new Intent(getActivity(),MutipleActivity.class);
                    multiple.putExtra("jumpTo",2 );
                    startActivity(multiple);

                }else{
                    yourAnswer = "Please select one answer";
                    Toast.makeText(getActivity(),yourAnswer,Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;

    }


   public interface SendValue{
        public void passData(int correct, int total,String answer);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            send = (SendValue) activity;
        }catch(ClassCastException e){
            throw new ClassCastException("You must to implement SendValue method!");
        }
    }
}
