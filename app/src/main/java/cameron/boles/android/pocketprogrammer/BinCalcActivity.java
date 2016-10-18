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
public class BinCalcActivity extends AppCompatActivity {

    private EditText bin_left_add_operand;
    private EditText bin_right_add_operand;
    private EditText bin_left_sub_operand;
    private EditText bin_right_sub_operand;
    private EditText bin_left_mult_operand;
    private EditText bin_right_mult_operand;
    private EditText bin_left_div_operand;
    private EditText bin_right_div_operand;

    private Button bin_add_button;
    private Button bin_sub_button;
    private Button bin_mult_button;
    private Button bin_div_button;

    private TextView bin_add_answer;
    private TextView bin_sub_answer;
    private TextView bin_mult_answer;
    private TextView bin_div_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin_calculator);

        bin_left_add_operand = (EditText) findViewById(R.id.bin_left_add_operand);
        bin_right_add_operand = (EditText) findViewById(R.id.bin_right_add_operand);
        bin_add_answer = (TextView) findViewById(R.id.bin_add_answer);

        bin_add_button = (Button) findViewById(R.id.add_bin_button);
        bin_add_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(bin_left_add_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(bin_right_add_operand.getWindowToken(), 0);
                try {
                    String bin_left_add_input = bin_left_add_operand.getText().toString();
                    String bin_right_add_input = bin_right_add_operand.getText().toString();
                    int bin_left_add = Integer.parseInt(bin_left_add_input, 2);
                    int bin_right_add = Integer.parseInt(bin_right_add_input, 2);
                    String answer = Integer.toBinaryString(bin_left_add + bin_right_add);
                    bin_add_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(BinCalcActivity.this, "Binary Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bin_left_sub_operand = (EditText) findViewById(R.id.bin_left_sub_operand);
        bin_right_sub_operand = (EditText) findViewById(R.id.bin_right_sub_operand);
        bin_sub_answer = (TextView) findViewById(R.id.bin_sub_answer);

        bin_sub_button = (Button) findViewById(R.id.sub_bin_button);
        bin_sub_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(bin_left_sub_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(bin_right_sub_operand.getWindowToken(), 0);
                try {
                    String bin_left_sub_input = bin_left_sub_operand.getText().toString();
                    String bin_right_sub_input = bin_right_sub_operand.getText().toString();
                    int bin_left_sub = Integer.parseInt(bin_left_sub_input, 2);
                    int bin_right_sub = Integer.parseInt(bin_right_sub_input, 2);
                    String answer = Integer.toBinaryString(bin_left_sub - bin_right_sub);
                    bin_sub_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(BinCalcActivity.this, "Binary Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bin_left_mult_operand = (EditText) findViewById(R.id.bin_left_mult_operand);
        bin_right_mult_operand = (EditText) findViewById(R.id.bin_right_mult_operand);
        bin_mult_answer = (TextView) findViewById(R.id.bin_mult_answer);

        bin_mult_button = (Button) findViewById(R.id.mult_bin_button);
        bin_mult_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(bin_left_mult_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(bin_right_mult_operand.getWindowToken(), 0);
                try {
                    String bin_left_mult_input = bin_left_mult_operand.getText().toString();
                    String bin_right_mult_input = bin_right_mult_operand.getText().toString();
                    int bin_left_mult = Integer.parseInt(bin_left_mult_input, 2);
                    int bin_right_mult = Integer.parseInt(bin_right_mult_input, 2);
                    String answer = Integer.toBinaryString(bin_left_mult * bin_right_mult);
                    bin_mult_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(BinCalcActivity.this, "Binary Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bin_left_div_operand = (EditText) findViewById(R.id.bin_left_div_operand);
        bin_right_div_operand = (EditText) findViewById(R.id.bin_right_div_operand);
        bin_div_answer = (TextView) findViewById(R.id.bin_div_answer);

        bin_div_button = (Button) findViewById(R.id.div_bin_button);
        bin_div_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(bin_left_div_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(bin_right_div_operand.getWindowToken(), 0);
                try {
                    String bin_left_div_input = bin_left_div_operand.getText().toString();
                    String bin_right_div_input = bin_right_div_operand.getText().toString();
                    int bin_left_div = Integer.parseInt(bin_left_div_input, 2);
                    int bin_right_div = Integer.parseInt(bin_right_div_input, 2);
                    String answer = Integer.toBinaryString(bin_left_div / bin_right_div);
                    bin_div_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(BinCalcActivity.this, "Binary Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
