package com.example.jawad_dallashe_intent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView result;
    Button Back;
    String str;
    Float num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result=findViewById(R.id.result);
        Back=findViewById(R.id.Back);
        Back.setBackgroundColor(Color.rgb(110, 110, 107));
        Intent gi = getIntent();
        if(gi.hasExtra("error"))
            result.setText("Error");
        else {
            num = gi.getFloatExtra("num", 0);
            result.setText("The result is:"+num + "");
        }



    }

    public void back(View view) {
        finish();
    }
}


