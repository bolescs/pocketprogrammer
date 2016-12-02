package cameron.boles.android.pocketprogrammer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cameron Boles on 11/14/16.
 *
 * This activity will store your 5 most recent searches for quick access.
 */

public class RecentsActivity extends AppCompatActivity
{
    private ListView mRecentList;

    //Array of classes.
    String[] recentSearches = new String[]{};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recents);

        SearchResultsActivity searchResultsActivity = new SearchResultsActivity();
        recentSearches = searchResultsActivity.getSearches();

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, recentSearches);

        mRecentList = (ListView) findViewById(R.id.recents_list);
        mRecentList.setAdapter(adapter);


        mRecentList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    case 0:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        if (!recentSearches[position].equals("<empty>"))
                        {
                            Intent intent = new Intent(parent.getContext(), WebActivity.class);
                            intent.putExtra("search", recentSearches[position]);
                            startActivity(intent);
                        }
                        break;

                    case 1:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        if (!recentSearches[position].equals("<empty>"))
                        {
                            Intent intent1 = new Intent(parent.getContext(), WebActivity.class);
                            intent1.putExtra("search", recentSearches[position]);
                            startActivity(intent1);
                        }
                        break;

                    case 2:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        if (!recentSearches[position].equals("<empty>"))
                        {
                            Intent intent2 = new Intent(parent.getContext(), WebActivity.class);
                            intent2.putExtra("search", recentSearches[position]);
                            startActivity(intent2);
                        }
                        break;

                    case 3:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        if (!recentSearches[position].equals("<empty>"))
                        {
                            Intent intent3 = new Intent(parent.getContext(), WebActivity.class);
                            intent3.putExtra("search", recentSearches[position]);
                            startActivity(intent3);
                        }
                        break;

                    case 4:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        if (!recentSearches[position].equals("<empty>"))
                        {
                            Intent intent4 = new Intent(parent.getContext(), WebActivity.class);
                            intent4.putExtra("search", recentSearches[position]);
                            startActivity(intent4);
                        }
                        break;

                    default:
                        break;
                }
            }
        });


        mRecentList.clearChoices();
        mRecentList.requestLayout();
    }
}
