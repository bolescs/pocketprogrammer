package cameron.boles.android.pocketprogrammer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by yellowpepper83 on 9/13/16.
 */
public class JavaActivity extends AppCompatActivity
{
    private Button java;
    private Button cpp;
    private Button c;
    private Button python;
    private Button sql;
    String buttonPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

    }
}
