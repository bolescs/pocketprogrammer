package cameron.boles.android.pocketprogrammer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Eric and Cameron on 9/3/2016.
 */
public class CalculatorActivity extends AppCompatActivity {

    private Button decimalButton;
    private Button hexButton;
    private Button binaryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        decimalButton = (Button) findViewById(R.id.decimal_button);
        decimalButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(CalculatorActivity.this, DecCalcActivity.class);
                startActivity(i);
            }
        });

        hexButton = (Button) findViewById(R.id.hex_button);
        hexButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(CalculatorActivity.this, HexCalcActivity.class);
                startActivity(i);
            }
        });

        binaryButton = (Button) findViewById(R.id.binary_button);
        binaryButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(CalculatorActivity.this, BinCalcActivity.class);
                startActivity(i);
            }
        });
    }
}
