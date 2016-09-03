package cameron.boles.android.pocketprogrammer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
    private Button languages;
    private Button conversions;
    private Button calculator;
    private Button gdb;
    private Button linux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        languages = (Button) findViewById(R.id.language);
        languages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(WelcomeActivity.this, LanguageActivity.class);
                startActivity(i);
            }
        });
    }

    /**
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_welcome, container, false);

        languages = (Button) view.findViewById(R.id.language);
        languages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = LanguageActivity.newIntent(WelcomeActivity.this);
                startActivity(i);
            }
        });

        return view;
    }
    */
}
