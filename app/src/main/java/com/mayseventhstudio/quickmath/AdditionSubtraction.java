package com.mayseventhstudio.quickmath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class AdditionSubtraction extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8,b9;
    String answer="";
    int mode=0;
    TextView ans;

    TextView part1, part2, sign;
    TextView q3part1, q3sign, q3part2, q3sign2, q3part3;

    int result = 0;

    TextView streak;
    int streaknum=0;

    ImageView bang;

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

        q3part1 = (TextView) findViewById(R.id.q3part1);
        q3sign = (TextView) findViewById(R.id.q3sign);
        q3part2 = (TextView) findViewById(R.id.q3part2);
        q3sign2 = (TextView) findViewById(R.id.q3sign2);
        q3part3 = (TextView) findViewById(R.id.q3part3);


        streak = (TextView) findViewById(R.id.streak);

        bang = (ImageView) findViewById(R.id.bang);

        mode = getIntent().getExtras().getInt("mode");

        if(mode==2){
            generateNums2();
            q3part1.setVisibility(View.GONE);
            q3sign.setVisibility(View.GONE);
            q3part2.setVisibility(View.GONE);
            q3sign2.setVisibility(View.GONE);
            q3part3.setVisibility(View.GONE);

            part1.setVisibility(View.VISIBLE);
            sign.setVisibility(View.VISIBLE);
            part2.setVisibility(View.VISIBLE);
        }
        else{
            generateNums3();
            q3part1.setVisibility(View.VISIBLE);
            q3sign.setVisibility(View.VISIBLE);
            q3part2.setVisibility(View.VISIBLE);
            q3sign2.setVisibility(View.VISIBLE);
            q3part3.setVisibility(View.VISIBLE);

            part1.setVisibility(View.GONE);
            sign.setVisibility(View.GONE);
            part2.setVisibility(View.GONE);
        }
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

    public void generateNums2(){
        Random rand = new Random();
        int a = rand.nextInt(101);
        int b = rand.nextInt(101);

        int n = rand.nextInt(2);
        if(n==0) {
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

    public void generateNums3(){
        Random rand = new Random();
        int a = rand.nextInt(101);
        int b = rand.nextInt(101);
        int c = rand.nextInt(101);

        int n = rand.nextInt(2);
        int o = rand.nextInt(2);
        if(n==0) {
            q3sign.setText("+");
            result = a+b;
        }
        else {
            q3sign.setText("-");
            if(b>a){
                int m = a;
                a = b;
                b = m;
            }

            result = a-b;
        }

        if(o==0){
            q3sign2.setText("+");
            result = result + c;
            q3part1.setText(a+"");
            q3part2.setText(b+"");
            q3part3.setText(c+"");
        }else{
            q3sign2.setText("-");
            if(c>result){
                //Toast.makeText(getApplicationContext(),"Negative!",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),result+"",Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),c+"",Toast.LENGTH_SHORT).show();
                q3sign2.setText("+");
                result = result + c;

                /*int m = a;
                a = c;
                q3sign2.setText(q3sign.getText().toString());
                q3sign.setText("-");
                c=m;
                if(q3sign2.getText().toString().equals("-"))
                    result = a-b-c;
                else
                    result = a-b+c;*/
                q3part1.setText(a+"");
                q3part2.setText(b+"");
                q3part3.setText(c+"");
            }else{
                result = result-c;
                q3part1.setText(a+"");
                q3part2.setText(b+"");
                q3part3.setText(c+"");
            }
        }

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
        /*if(streaknum==5){
            bang.setVisibility(View.VISIBLE);
        }*/
        if(mode==2)
            generateNums2();
        else
            generateNums3();
    }

}
