package com.mayseventhstudio.quickmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addsub2, addsub3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addsub2 = (Button)findViewById(R.id.addsub2);
        addsub2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), AdditionSubtraction.class);
                Bundle b = new Bundle();
                b.putInt("mode", 2);
                i.putExtras(b);
                startActivity(i);
            }
        });

        addsub3 = (Button)findViewById(R.id.addsub3);
        addsub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AdditionSubtraction.class);
                Bundle b = new Bundle();
                b.putInt("mode", 3);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
