package cameron.boles.android.pocketprogrammer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * SplashActivity class allows for a splash screen to be displayed before the
 *     ExhibitListFragment page is displayed (the home page).
 *
 * @author Cameron Boles
 */
public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        Intent intent = new Intent(this, ChooseClassActivity.class);
        startActivity(intent);
        finish();
    }
}