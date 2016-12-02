package cameron.boles.android.pocketprogrammer;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Cameron Boles on 10/4/16.
 *
 * This class interprets the search queries made in ChooseClassActivity and passes them to WebActivity.
 */
public class SearchResultsActivity extends Activity
{
    static String[] searches = new String[] {"<empty>", "<empty>", "<empty>", "<empty>", "<empty>"};

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
            setSearches(query);

            Intent i = new Intent(this, WebActivity.class);
            i.putExtra("search", query);
            startActivity(i);

        }
    }

    //sets your recent searches.
    public void setSearches(String recentSearch)
    {
        if (searches[0].equals("<empty>"))
        {
            searches[0] = recentSearch;
        }
        else
        {
            for (int i = searches.length - 1; i > 0; i--)
            {
                searches[i] = searches[i - 1];
            }
            searches[0] = recentSearch;
        }
    }

    public String[] getSearches()
    {
        return searches;
    }
}
