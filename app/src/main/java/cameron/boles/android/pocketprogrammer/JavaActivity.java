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
 * Created by Eric Moore and Cameron Boles on 9/13/16.
 */
public class JavaActivity extends AppCompatActivity
{
    private ListView mJavaList;
    private WebView mJavaWebView = null;

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
                        setTitle("Arrays");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        setContentView(R.layout.activity_webview);
                        mJavaWebView = (WebView) findViewById(R.id.webView);
                        mJavaWebView.getSettings().setJavaScriptEnabled(true);
                        mJavaWebView.getSettings().setBuiltInZoomControls(true);
                        mJavaWebView.getSettings().setDisplayZoomControls(false);
                        mJavaWebView.loadUrl("https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html");
                        break;

                    //Array Lists
                    case 1:
                        setTitle("Array Lists");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        setContentView(R.layout.activity_webview);
                        mJavaWebView = (WebView) findViewById(R.id.webView);
                        mJavaWebView.getSettings().setJavaScriptEnabled(true);
                        mJavaWebView.getSettings().setBuiltInZoomControls(true);
                        mJavaWebView.getSettings().setDisplayZoomControls(false);
                        mJavaWebView.loadUrl("https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html");
                        break;

                    //Linked Lists
                    case 2:
                        setTitle("Linked Lists");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        setContentView(R.layout.activity_webview);
                        mJavaWebView = (WebView) findViewById(R.id.webView);
                        mJavaWebView.getSettings().setJavaScriptEnabled(true);
                        mJavaWebView.getSettings().setBuiltInZoomControls(true);
                        mJavaWebView.getSettings().setDisplayZoomControls(false);
                        mJavaWebView.loadUrl("https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html");
                        break;

                    //Stacks
                    case 3:
                        setTitle("Stacks");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        setContentView(R.layout.activity_webview);
                        mJavaWebView = (WebView) findViewById(R.id.webView);
                        mJavaWebView.getSettings().setJavaScriptEnabled(true);
                        mJavaWebView.getSettings().setBuiltInZoomControls(true);
                        mJavaWebView.getSettings().setDisplayZoomControls(false);
                        mJavaWebView.loadUrl("https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html");
                        break;

                    //Data Types
                    case 4:
                        setTitle("Data Types");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        setContentView(R.layout.activity_webview);
                        mJavaWebView = (WebView) findViewById(R.id.webView);
                        mJavaWebView.getSettings().setJavaScriptEnabled(true);
                        mJavaWebView.getSettings().setBuiltInZoomControls(true);
                        mJavaWebView.getSettings().setDisplayZoomControls(false);
                        mJavaWebView.loadUrl("https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html");
                        break;

                    //Example Code
                    case 5:
                        setTitle("Example Code");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        setContentView(R.layout.activity_webview);
                        mJavaWebView = (WebView) findViewById(R.id.webView);
                        mJavaWebView.getSettings().setJavaScriptEnabled(true);
                        mJavaWebView.getSettings().setBuiltInZoomControls(true);
                        mJavaWebView.getSettings().setDisplayZoomControls(false);
                        mJavaWebView.loadUrl("https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html");
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
