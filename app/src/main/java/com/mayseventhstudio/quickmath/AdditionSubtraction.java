package com.mayseventhstudio.quickmath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class AdditionSubtraction extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8,b9;
    String answer="";
    TextView ans;

    TextView part1, part2, sign;

    int result = 0;

    TextView streak;
    int streaknum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsub);

        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);

        ans = (TextView) findViewById(R.id.ans);

        part1 = (TextView) findViewById(R.id.qpart1);
        part2 = (TextView) findViewById(R.id.qpart2);
        sign = (TextView) findViewById(R.id.qsign);

        streak = (TextView) findViewById(R.id.streak);

        generateNums();

    }

    public void getNum(View v) {
        Button b = (Button)v;
        answer += b.getText().toString();
        ans.setText(answer);
    }

    public void removeNum(View v){
        if(answer.length()>0)
            answer = answer.substring(0,answer.length()-1);
        ans.setText(answer);
    }

    public void generateNums(){
        Random rand = new Random();
        int a = rand.nextInt(101);
        int b = rand.nextInt(101);

        int c = rand.nextInt(2);
        if(c==0) {
            sign.setText("+");
            result = a+b;
        }
        else {
            sign.setText("-");
            if(b>a){
                int m = a;
                a = b;
                b = m;
            }

            result = a-b;
        }

        part1.setText(a+"");
        part2.setText(b+"");
    }

    public void compare(View v){
        //Toast.makeText(getApplicationContext(),ans.getText().toString(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(),result+"", Toast.LENGTH_SHORT).show();

        if(answer.equals(result+"")){
            streaknum++;
        }else{
            streaknum=0;
        }
        streak.setText(streaknum+"");
        answer="";
        ans.setText(answer);
        generateNums();
    }

}
