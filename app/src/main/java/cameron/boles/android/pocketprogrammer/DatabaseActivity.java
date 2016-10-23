package apps.real.pocketprogrammer;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.HapticFeedbackConstants;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Eric Moore and Cameron Boles on 10/11/16.
 */
public class DatabaseActivity extends AppCompatActivity
{
    private ListView mDatabaseList;
    private WebView mDatabaseWebView = null;

    //Array of Database Topics.
    String[] topics = {"SQL Commands", "Example Code"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, topics);

        mDatabaseList = (ListView) findViewById(R.id.database_list);
        mDatabaseList.setAdapter(adapter);


        mDatabaseList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    //SQL Commands
                    case 0:
                        setTitle("SQL Commands");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        setContentView(R.layout.activity_webview);
                        mDatabaseWebView = (WebView) findViewById(R.id.webView);
                        mDatabaseWebView.getSettings().setJavaScriptEnabled(true);
                        mDatabaseWebView.getSettings().setBuiltInZoomControls(true);
                        mDatabaseWebView.getSettings().setDisplayZoomControls(false);
                        mDatabaseWebView.loadUrl("https://www.codecademy.com/articles/sql-commands?r=master");
                        break;

                    //Example Code
                    case 1:
                        setTitle("Example Code");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        setContentView(R.layout.activity_webview);
                        mDatabaseWebView = (WebView) findViewById(R.id.webView);
                        mDatabaseWebView.getSettings().setJavaScriptEnabled(true);
                        mDatabaseWebView.getSettings().setBuiltInZoomControls(true);
                        mDatabaseWebView.getSettings().setDisplayZoomControls(false);
                        mDatabaseWebView.loadUrl("https://www.google.com");
                        break;

                    default:
                        break;
                }
            }
        });

        mDatabaseList.clearChoices();
        mDatabaseList.requestLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.welcome_options_menu, menu);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.menu_item_search));
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchResultsActivity.class)));
        searchView.setQueryHint(getResources().getString(R.string.search_hint));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.menu_item_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
