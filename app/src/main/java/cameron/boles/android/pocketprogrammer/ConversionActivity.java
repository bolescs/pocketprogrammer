package cameron.boles.android.pocketprogrammer;

/**
 * Created by yellowpepper83 on 9/20/16.
 */
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
 * Created by Eric Moore and Cameron Boles on 9/3/2016.
 */
public class ConversionActivity extends AppCompatActivity {

    private EditText dec2hexText;
    private EditText hex2decText;
    private EditText bin2decText;

    private Button dec2hexButt;
    private Button hex2decButt;
    private Button bin2decButt;

    private TextView dec2hexAnswer;
    private TextView hex2decAnswer;
    private TextView bin2decAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        dec2hexText = (EditText) findViewById(R.id.dec_hex_editText);
        dec2hexAnswer = (TextView) findViewById(R.id.dec_hex_answer_textView);

        dec2hexButt = (Button) findViewById(R.id.dec_hex_button);
        dec2hexButt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(dec2hexText.getWindowToken(), 0);
                try {
                    int decInput = Integer.parseInt(dec2hexText.getText().toString());
                    String hex = Integer.toHexString(decInput);
                    dec2hexAnswer.setText(hex);
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(), "Please enter a decimal value", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });


        hex2decText = (EditText) findViewById(R.id.hex_dec_editText);
        hex2decAnswer = (TextView) findViewById(R.id.hex_dec_answer_textView);

        hex2decButt = (Button) findViewById(R.id.hex_dec_button);
        hex2decButt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(hex2decText.getWindowToken(), 0);
                try {
                    String hexInput = hex2decText.getText().toString();
                    int decimal = Integer.parseInt(hexInput, 16);
                    hex2decAnswer.setText(decimal + "");
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(), "Please enter a hex value", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        bin2decText = (EditText) findViewById(R.id.bin_dec_editText);
        bin2decAnswer = (TextView) findViewById(R.id.bin_dec_answer_textView);

        bin2decButt = (Button) findViewById(R.id.bin_dec_button);
        bin2decButt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(bin2decText.getWindowToken(), 0);
                try {
                    String binInput = bin2decText.getText().toString();
                    int dec = Integer.parseInt(binInput, 2);
                    bin2decAnswer.setText(dec + "");
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(), "Please enter a binary value", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}