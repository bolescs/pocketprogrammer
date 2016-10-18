package cameron.boles.android.pocketprogrammer;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by yellowpepper83 on 10/4/16.
 */
public class SearchResultsActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent)
    {

        if (Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query = intent.getStringExtra(SearchManager.QUERY);

            if (query.toLowerCase().equals("arraylist"))
            {
                Intent i = new Intent(this, WebActivity.class);
                i.putExtra("search", query);
                startActivity(i);
            }
        }
    }
}
