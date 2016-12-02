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
 * Created by Eric Moore on 10/25/2016.
 *
 * Activity that launches win 'C++' is clicked within Systems activity.
 *
 */

public class CPlusPlusActivity extends AppCompatActivity {

    private ListView mCPlusPlusList;

    //Array of C++ Topics.
    String[] topics = {"Structs", "Data Types", "Example Code"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplusplus);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, topics);

        mCPlusPlusList = (ListView) findViewById(R.id.CPlusPlus_list);
        mCPlusPlusList.setAdapter(adapter);

        mCPlusPlusList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    //Structs
                    case 0:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent = new Intent(parent.getContext(), WebActivity.class);
                        intent.putExtra("search", "c++ data structures");
                        startActivity(intent);
                        break;

                    //Data Types
                    case 1:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent2 = new Intent(parent.getContext(), WebActivity.class);
                        intent2.putExtra("search", "c++ data types");
                        startActivity(intent2);
                        break;

                    //Example Code
                    case 2:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent6 = new Intent(parent.getContext(), ExampleCodeActivity.class);
                        intent6.putExtra("caller", "cpp");
                        startActivity(intent6);
                        break;

                    default:
                        break;
                }
            }
        });

        mCPlusPlusList.clearChoices();
        mCPlusPlusList.requestLayout();
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
