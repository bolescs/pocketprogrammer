package cameron.boles.android.pocketprogrammer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by yellowpepper83 on 9/26/16.
 */
public class AboutActivity extends AppCompatActivity
{
    private TextView about;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        about = (TextView) findViewById(R.id.copyright);
        about.setText("Copyright 2016" + "\n"
                        + "Cameron Boles and Eric Moore" + "\n"
                        + "Students, Appalchian State University" + "\n"
                        + "Senior Capstone Project");

    }
}
