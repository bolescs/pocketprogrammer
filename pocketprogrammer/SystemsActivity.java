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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Eric Moore on 10/11/16.
 *
 * Activity that loads Systems information when clicked.
 */
public class SystemsActivity extends AppCompatActivity
{
    private ListView mSystemsList;

    //Array of System Topics.
    String[] topics = {"C", "C++", "Linux Commands", "GDB", "x86 Assembly"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systems);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, topics);

        mSystemsList = (ListView) findViewById(R.id.systems_list);
        mSystemsList.setAdapter(adapter);

        mSystemsList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    //C
                    case 0:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent = new Intent(parent.getContext(), CActivity.class);
                        startActivity(intent);
                        break;

                    //C++
                    case 1:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent1 = new Intent(parent.getContext(), CPlusPlusActivity.class);
                        startActivity(intent1);
                        break;

                    //Linux Commands
                    case 2:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent2 = new Intent(parent.getContext(), WebActivity.class);
                        intent2.putExtra("search", "linux commands");
                        startActivity(intent2);
                        break;

                    //GDB
                    case 3:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent3 = new Intent(parent.getContext(), WebActivity.class);
                        intent3.putExtra("search", "gdb");
                        startActivity(intent3);
                        break;

                    //x86 Assembly
                    case 4:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent4 = new Intent(parent.getContext(), WebActivity.class);
                        intent4.putExtra("search", "x86 assembly");
                        startActivity(intent4);
                        break;

                    default:
                        break;
                }
            }
        });

        mSystemsList.clearChoices();
        mSystemsList.requestLayout();
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
