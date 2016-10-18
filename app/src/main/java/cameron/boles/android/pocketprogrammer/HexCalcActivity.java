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
 * Created by Eric and Cameron on 9/20/2016.
 */
public class HexCalcActivity extends AppCompatActivity {

    private EditText hex_left_add_operand;
    private EditText hex_right_add_operand;
    private EditText hex_left_sub_operand;
    private EditText hex_right_sub_operand;
    private EditText hex_left_mult_operand;
    private EditText hex_right_mult_operand;
    private EditText hex_left_div_operand;
    private EditText hex_right_div_operand;

    private Button hex_add_button;
    private Button hex_sub_button;
    private Button hex_mult_button;
    private Button hex_div_button;

    private TextView hex_add_answer;
    private TextView hex_sub_answer;
    private TextView hex_mult_answer;
    private TextView hex_div_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_calculator);

        hex_left_add_operand = (EditText) findViewById(R.id.hex_left_add_operand);
        hex_right_add_operand = (EditText) findViewById(R.id.hex_right_add_operand);
        hex_add_answer = (TextView) findViewById(R.id.hex_add_answer);

        hex_add_button = (Button) findViewById(R.id.add_hex_button);
        hex_add_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(hex_left_add_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(hex_right_add_operand.getWindowToken(), 0);
                try {
                    String hex_left_add_input = hex_left_add_operand.getText().toString();
                    String hex_right_add_input = hex_right_add_operand.getText().toString();
                    int hex_left_add = Integer.parseInt(hex_left_add_input, 16);
                    int hex_right_add = Integer.parseInt(hex_right_add_input, 16);
                    String answer = Integer.toHexString(hex_left_add + hex_right_add);
                    hex_add_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(HexCalcActivity.this, "Hex Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        hex_left_sub_operand = (EditText) findViewById(R.id.hex_left_sub_operand);
        hex_right_sub_operand = (EditText) findViewById(R.id.hex_right_sub_operand);
        hex_sub_answer = (TextView) findViewById(R.id.hex_sub_answer);

        hex_sub_button = (Button) findViewById(R.id.sub_hex_button);
        hex_sub_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(hex_left_sub_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(hex_right_sub_operand.getWindowToken(), 0);
                try {
                    String hex_left_sub_input = hex_left_sub_operand.getText().toString();
                    String hex_right_sub_input = hex_right_sub_operand.getText().toString();
                    int hex_left_sub = Integer.parseInt(hex_left_sub_input, 16);
                    int hex_right_sub = Integer.parseInt(hex_right_sub_input, 16);
                    String answer = Integer.toHexString(hex_left_sub - hex_right_sub);
                    hex_sub_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(HexCalcActivity.this, "Hex Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        hex_left_mult_operand = (EditText) findViewById(R.id.hex_left_mult_operand);
        hex_right_mult_operand = (EditText) findViewById(R.id.hex_right_mult_operand);
        hex_mult_answer = (TextView) findViewById(R.id.hex_mult_answer);

        hex_mult_button = (Button) findViewById(R.id.mult_hex_button);
        hex_mult_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(hex_left_mult_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(hex_right_mult_operand.getWindowToken(), 0);
                try {
                    String hex_left_mult_input = hex_left_mult_operand.getText().toString();
                    String hex_right_mult_input = hex_right_mult_operand.getText().toString();
                    int hex_left_mult = Integer.parseInt(hex_left_mult_input, 16);
                    int hex_right_mult = Integer.parseInt(hex_right_mult_input, 16);
                    String answer = Integer.toHexString(hex_left_mult * hex_right_mult);
                    hex_mult_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(HexCalcActivity.this, "Hex Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        hex_left_div_operand = (EditText) findViewById(R.id.hex_left_div_operand);
        hex_right_div_operand = (EditText) findViewById(R.id.hex_right_div_operand);
        hex_div_answer = (TextView) findViewById(R.id.hex_div_answer);

        hex_div_button = (Button) findViewById(R.id.div_hex_button);
        hex_div_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(hex_left_div_operand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(hex_right_div_operand.getWindowToken(), 0);
                try {
                    String hex_left_div_input = hex_left_div_operand.getText().toString();
                    String hex_right_div_input = hex_right_div_operand.getText().toString();
                    int hex_left_div = Integer.parseInt(hex_left_div_input, 16);
                    int hex_right_div = Integer.parseInt(hex_right_div_input, 16);
                    String answer = Integer.toHexString(hex_left_div / hex_right_div);
                    hex_div_answer.setText(answer + "");
                }
                catch(NumberFormatException e) {
                    Toast.makeText(HexCalcActivity.this, "Hex Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
