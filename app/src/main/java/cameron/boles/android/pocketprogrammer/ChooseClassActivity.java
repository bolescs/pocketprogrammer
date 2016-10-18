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
 * Created by yellowpepper83 on 10/4/16.
 */
public class ChooseClassActivity extends AppCompatActivity
{
    private ListView mclassList;
    //Array of classes.
    String[] classes = {"Java", "Database", "Systems", "Calculator", "Converter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, classes);

        mclassList = (ListView) findViewById(R.id.class_list);
        mclassList.setAdapter(adapter);

        mclassList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    //Java
                    case 0:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent = new Intent(parent.getContext(), JavaActivity.class);
                        startActivity(intent);
                        break;

                    //Database
                    case 1:
                        Intent intent1 = new Intent(parent.getContext(), JavaActivity.class);
                        startActivity(intent1);
                        break;

                    //Systems
                    case 2:
                        Intent intent2 = new Intent(parent.getContext(), ConversionActivity.class);
                        startActivity(intent2);
                        break;

                    //Calculator
                    case 3:
                        break;

                    //Converter
                    case 4:
                        break;

                    default:
                        break;
                }
            }
        });

        mclassList.clearChoices();
        mclassList.requestLayout();
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
