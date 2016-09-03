package cameron.boles.android.pocketprogrammer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by yellowpepper83 on 8/30/16.
 */
public class LanguageActivity extends AppCompatActivity
{
    private Button java;
    private Button c;
    private Button cpp;
    private Button python;
    private Button sql;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        java = (Button) findViewById(R.id.java);
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(LanguageActivity.this, JavaInfo.class);
                startActivity(i);
            }
        });
    }
}
