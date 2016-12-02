package cameron.boles.android.pocketprogrammer;

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
 *
 * Activity containing database info form home page.
 */
public class DatabaseActivity extends AppCompatActivity
{
    private ListView mDatabaseList;

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
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent = new Intent(parent.getContext(), WebActivity.class);
                        intent.putExtra("search", "sql commands");
                        startActivity(intent);
                        break;

                    //Example Code
                    case 1:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
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