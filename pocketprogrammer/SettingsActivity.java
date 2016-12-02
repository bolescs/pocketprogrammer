package cameron.boles.android.pocketprogrammer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by Cameron Boles on 11/19/16.
 *
 * This class currently does nothing, but can be used in future to add more app settings.
 */

public class SettingsActivity extends AppCompatActivity
{
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_LIGHT_THEME = "light_theme";

    private Switch themeSwitcher;

    protected void onCreate(Bundle savedInstanceState)
    {
        /**
        //set theme
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean userLightTheme = preferences.getBoolean(PREF_LIGHT_THEME, false);
        if (userLightTheme)
        {
            setTheme(R.style.AppThemeLight);
        }
         */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        /**
        themeSwitcher = (Switch) findViewById(R.id.theme_switch);

        themeSwitcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked)
            {
                toggleTheme(isChecked);
            }
        });
         */
    }

    /**
    private void toggleTheme(boolean lightTheme)
    {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putBoolean(PREF_LIGHT_THEME, lightTheme);
        editor.apply();

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
     */
}
