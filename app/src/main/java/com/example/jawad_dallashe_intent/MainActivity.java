package com.example.jawad_dallashe_intent;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button Exit,plus,sub,multiplication,division,equal,Clear_All,credits;
    String operator,str;
    int check,count;
    EditText screen_display;
    TextView title;
    float number,result;
    //float positiveInf ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Exit=(Button)findViewById(R.id.Exit);
        plus=(Button)findViewById(R.id.Plus);
        sub=(Button)findViewById(R.id.Sub);
        multiplication=(Button)findViewById(R.id.Multiplication);
        division=(Button)findViewById(R.id.Division);
        equal=(Button)findViewById(R.id.Equal);
        Clear_All=(Button)findViewById(R.id.Clear_All);
        credits=(Button)findViewById(R.id.Credits);
        screen_display=(EditText) findViewById(R.id.screen_display);
        title=findViewById(R.id.Title);


        plus.setBackgroundColor(Color.rgb(245, 191, 66));
        sub.setBackgroundColor(Color.rgb(245, 191, 66));
        multiplication.setBackgroundColor(Color.rgb(245, 191, 66));
        division.setBackgroundColor(Color.rgb(245, 191, 66));
        Clear_All.setBackgroundColor(Color.rgb(48, 48, 46));
        credits.setBackgroundColor(Color.rgb(48, 48, 46));
        equal.setBackgroundColor(Color.rgb(110, 110, 107));
        Exit.setBackgroundColor(Color.rgb(54, 54, 53));


        result=0;
        operator="";
        str="";
        count=0;
        check=0;
    }
    public void exit(View view) {Exit.setText(hashCode());
    }
    public void main2(View view) {
        Intent si = new Intent(this,MainActivity2.class);
        if(screen_display.getText().toString().equals("Error"))
            si.putExtra("error","Error");
        else
            si.putExtra("num",result);
        startActivity(si);

    }
    public void equal(View view) {
        //positiveInf = Float.POSITIVE_INFINITY;
        if (operator.equals("+")) {
            str = screen_display.getText().toString();
            number = Float.parseFloat(str);
            result += number;
        }
        if (operator.equals("-")) {
            str = screen_display.getText().toString();
            number = Float.parseFloat(str);
            result -= number;
        }
        if (operator.equals("*")) {
            str = screen_display.getText().toString();
            number = Float.parseFloat(str);
            result *= number;
        }
        if (operator.equals("/")) {
            str = screen_display.getText().toString();
            number = Float.parseFloat(str);
            if(number==0)
                screen_display.setText("Error");

            else {
                result /= number;
                screen_display.setText(result + "");
            }
        }
        else
            screen_display.setText(result+"");

    }
    public void add(View view) {

        str=screen_display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            number=Float.parseFloat(str);
            if(operator.equals("-"))
                result-=number;
            else if(operator.equals("*"))
                result*=number;
            else if(operator.equals("/")) {
                if (number == 0)
                    screen_display.setText("Error");
                else
                    result /= number;
            }
            else
                result+=number;
            operator="+";
        }

        screen_display.setText("");
        screen_display.getHint();

    }

    public void A_C(View view) {
        count=0;
        result=0;
        operator="";
        screen_display.setText("");
        screen_display.getHint();
    }

    public void sub(View view) {

        str=screen_display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            number=Float.parseFloat(str);
            if (number == 0)
                screen_display.setText("Error");
            else
                result /= number;
            if(operator.equals("+"))
                result+=number;
            else if(operator.equals("*"))
                result*=number;
            else if(operator.equals("/")) {

            }
            else{
                if(count==1)
                    if(operator.equals(""))
                        result=number;
                    else
                        result=Float.valueOf(-number);
                else
                    result-=number;
            }

        }

        operator="-";
        screen_display.setText("");
        screen_display.getHint();
    }

    public void multiplication(View view) {
        str=screen_display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            number=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=number;
            else if(operator.equals("-"))
                result-=number;
            else if(operator.equals("/")){
                if(number==0)
                    screen_display.setText("Error");
                else
                    result /= number;
            }
            else{
                if(count==1)
                    result=number;
                else
                    result*=number;
            }

            operator="*";

        }

        screen_display.setText("");
        screen_display.getHint();

    }

    public void division(View view) {
        str=screen_display.getText().toString();
        if(!str.isEmpty()){
            count+=1;
            number=Float.parseFloat(str);
            if(operator.equals("+"))
                result+=number;
            else if(operator.equals("-"))
                result-=number;
            else if (operator.equals("*"))
                result*=number;
            else{
                if(count==1)
                    result=number;
                else
                    result/=number;
            }

            operator="/";
        }

        screen_display.setText("");
        screen_display.getHint();

    }
    }