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
 * Created by Eric Moore and Cameron Boles on 9/13/16.
 *
 * Contains info for Java activity launched from home page.
 *
 */
public class JavaActivity extends AppCompatActivity
{
    private ListView mJavaList;

    //Array of Java Topics.
    String[] structures = {"Arrays", "Array Lists", "Linked Lists", "Stacks", "Data Types", "Example Code"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, structures);

        mJavaList = (ListView) findViewById(R.id.java_list);
        mJavaList.setAdapter(adapter);


        mJavaList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    //Arrays
                    case 0:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent = new Intent(parent.getContext(), WebActivity.class);
                        intent.putExtra("search", "java array");
                        startActivity(intent);
                        break;

                    //Array Lists
                    case 1:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent2 = new Intent(parent.getContext(), WebActivity.class);
                        intent2.putExtra("search", "java arraylist");
                        startActivity(intent2);
                        break;

                    //Linked Lists
                    case 2:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent3 = new Intent(parent.getContext(), WebActivity.class);
                        intent3.putExtra("search", "java linkedlist");
                        startActivity(intent3);
                        break;

                    //Stacks
                    case 3:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent4 = new Intent(parent.getContext(), WebActivity.class);
                        intent4.putExtra("search", "java stack");
                        startActivity(intent4);
                        break;

                    //Data Types
                    case 4:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent5 = new Intent(parent.getContext(), WebActivity.class);
                        intent5.putExtra("search", "java data types");
                        startActivity(intent5);
                        break;

                    //Example Code
                    case 5:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent6 = new Intent(parent.getContext(), ExampleCodeActivity.class);
                        intent6.putExtra("caller", "java");
                        startActivity(intent6);
                        break;

                    default:
                        break;
                }
            }
        });

        mJavaList.clearChoices();
        mJavaList.requestLayout();
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