package cameron.boles.android.pocketprogrammer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Eric Moore and Cameron Boles on 9/20/2016.
 */
public class DecCalcActivity extends AppCompatActivity {

    private EditText dec_left_add_operand;
    private EditText dec_right_add_operand;
    private EditText dec_left_sub_operand;
    private EditText dec_right_sub_operand;
    private EditText dec_left_mult_operand;
    private EditText dec_right_mult_operand;
    private EditText dec_left_div_operand;
    private EditText dec_right_div_operand;

    private Button dec_add_button;
    private Button dec_sub_button;
    private Button dec_mult_button;
    private Button dec_div_button;

    private TextView dec_add_answer;
    private TextView dec_sub_answer;
    private TextView dec_mult_answer;
    private TextView dec_div_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_calculator);

        dec_left_add_operand = (EditText) findViewById(R.id.dec_left_add_operand);
        dec_right_add_operand = (EditText) findViewById(R.id.dec_right_add_operand);
        dec_add_answer = (TextView) findViewById(R.id.dec_add_answer);

        dec_add_button = (Button) findViewById(R.id.add_dec_button);
        dec_add_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(dec_left_add_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(dec_right_add_operand.getWindowToken(), 0);
                try {
                    int dec_add_left =  Integer.parseInt(dec_left_add_operand.getText().toString());
                    int dec_add_right =  Integer.parseInt(dec_right_add_operand.getText().toString());
                    int answer = dec_add_left + dec_add_right;
                    dec_add_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(DecCalcActivity.this, "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dec_left_sub_operand = (EditText) findViewById(R.id.dec_left_sub_operand);
        dec_right_sub_operand = (EditText) findViewById(R.id.dec_right_sub_operand);
        dec_sub_answer = (TextView) findViewById(R.id.dec_sub_answer);

        dec_sub_button = (Button) findViewById(R.id.sub_dec_button);
        dec_sub_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(dec_left_sub_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(dec_right_sub_operand.getWindowToken(), 0);
                try {
                    int dec_sub_left =  Integer.parseInt(dec_left_sub_operand.getText().toString());
                    int dec_sub_right =  Integer.parseInt(dec_right_sub_operand.getText().toString());
                    int answer = dec_sub_left - dec_sub_right;
                    dec_sub_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(DecCalcActivity.this, "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dec_left_mult_operand = (EditText) findViewById(R.id.dec_left_mult_operand);
        dec_right_mult_operand = (EditText) findViewById(R.id.dec_right_mult_operand);
        dec_mult_answer = (TextView) findViewById(R.id.dec_mult_answer);

        dec_mult_button = (Button) findViewById(R.id.mult_dec_button);
        dec_mult_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(dec_left_mult_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(dec_right_mult_operand.getWindowToken(), 0);
                try {
                    int dec_mult_left =  Integer.parseInt(dec_left_mult_operand.getText().toString());
                    int dec_mult_right =  Integer.parseInt(dec_right_mult_operand.getText().toString());
                    int answer = dec_mult_left * dec_mult_right;
                    dec_mult_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(DecCalcActivity.this, "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dec_left_div_operand = (EditText) findViewById(R.id.dec_left_div_operand);
        dec_right_div_operand = (EditText) findViewById(R.id.dec_right_div_operand);
        dec_div_answer = (TextView) findViewById(R.id.dec_div_answer);

        dec_div_button = (Button) findViewById(R.id.div_dec_button);
        dec_div_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(dec_left_div_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(dec_right_div_operand.getWindowToken(), 0);
                try {
                    int dec_div_left =  Integer.parseInt(dec_left_div_operand.getText().toString());
                    int dec_div_right =  Integer.parseInt(dec_right_div_operand.getText().toString());
                    int answer = dec_div_left / dec_div_right;
                    dec_div_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(DecCalcActivity.this, "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
