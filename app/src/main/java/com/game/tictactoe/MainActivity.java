package com.game.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();

        btn1.setOnClickListener(this::check);
        btn2.setOnClickListener(this::check);
        btn3.setOnClickListener(this::check);
        btn4.setOnClickListener(this::check);
        btn5.setOnClickListener(this::check);
        btn6.setOnClickListener(this::check);
        btn7.setOnClickListener(this::check);
        btn8.setOnClickListener(this::check);
        btn9.setOnClickListener(this::check);
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void check(View view) {
        Button btnCurr = (Button) view;
        if (btnCurr.getText().toString().isEmpty()) {
            if (flag == 0) {
                btnCurr.setText("X");
                flag = 1;
            } else {
                btnCurr.setText("O");
                flag = 0;
            }
            count++;
            if (count >= 5) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if (b1.equals(b2) && b2.equals(b3) && !b1.isEmpty()) {
                    setWinner(btn1, btn2, btn3);
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.isEmpty()) {
                    setWinner(btn4, btn5, btn6);
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.isEmpty()) {
                    setWinner(btn7, btn8, btn9);
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.isEmpty()) {
                    setWinner(btn1, btn4, btn7);
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.isEmpty()) {
                    setWinner(btn2, btn5, btn8);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.isEmpty()) {
                    setWinner(btn3, btn6, btn9);
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.isEmpty()) {
                    setWinner(btn1, btn5, btn9);
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.isEmpty()) {
                    setWinner(btn3, btn5, btn7);
                }
            }
        }
    }

    private void setWinner(Button b1, Button b2, Button b3) {
        int greenColor = getResources().getColor(R.color.green);
        b1.setBackgroundColor(greenColor);
        b2.setBackgroundColor(greenColor);
        b3.setBackgroundColor(greenColor);
        Toast.makeText(this, "Winner: " + b1.getText().toString(), Toast.LENGTH_LONG).show();
        disableButtons();
    }

    private void disableButtons() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }
}