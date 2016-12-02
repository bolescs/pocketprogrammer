package cameron.boles.android.pocketprogrammer;

/**
 * Created by Cameron Boles on 10/13/16.
 *
 * This activity receives a search query and will open up the appropriate
 *      URL in a WebView.  It will also open up Notes and quiz activities.
 *      The class also checks if the device has an internet connection,
 *      if it does we make use of it, if it does not then we load a cached version
 *      of the appropriate website.
 */

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity
{
    private WebView mWebView = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(false);

        String search = getIntent().getStringExtra("search").toLowerCase();

        //simple voice commands for opening activities
        if (search.equals("speed quizzes"))
        {
            Intent x = new Intent(this, QuizListActivity.class);
            finish();
            startActivity(x);
            return;
        }
        else if (search.equals("open my notes"))
        {
            Intent y = new Intent(this, NotePagerActivity.class);
            finish();
            startActivity(y);
            return;
        }

        setTitle(search);

        //if we have internet, use it.
        if (hasInternetAccess())
        {
            switch (search) {
                //Java searches
                case "java arraylist":
                    mWebView.loadUrl("https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html");
                    break;
                case "java array":
                    mWebView.loadUrl("https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html");
                    break;
                case "java linkedlist":
                    mWebView.loadUrl("https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html");
                    break;
                case "java stack":
                    mWebView.loadUrl("http://docs.oracle.com/javase/7/docs/api/java/util/Stack.html");
                    break;
                case "java data types":
                    mWebView.loadUrl("https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html");
                    break;

                //database searches
                case "sql commands":
                case "sql insert":
                case "sql delete":
                case "sql create table":
                case "sql query":
                    mWebView.loadUrl("https://www.codecademy.com/articles/sql-commands?r=master");
                    break;

                //systems searches
                case "linux commands":
                    mWebView.loadUrl("http://www.mediacollege.com/linux/command/linux-command.html");
                    break;
                case "gdb":
                case "gdb commands":
                case "gdb tutorial":
                    mWebView.loadUrl("http://heather.cs.ucdavis.edu/~matloff/UnixAndC/CLanguage/Debug.html");
                    break;
                case "x86 assembly":
                    mWebView.loadUrl("http://www.cs.virginia.edu/~evans/cs216/guides/x86.html");
                    break;
                case "c structs":
                    mWebView.loadUrl("https://www.tutorialspoint.com/cprogramming/c_structures.htm");
                    break;
                case "c data types":
                    mWebView.loadUrl("https://www.tutorialspoint.com/cprogramming/c_data_types.htm");
                    break;
                case "c strings":
                    mWebView.loadUrl("https://www.tutorialspoint.com/cprogramming/c_strings.htm");
                    break;
                case "c++ data types":
                    mWebView.loadUrl("https://www.tutorialspoint.com/cplusplus/cpp_data_types.htm");
                    break;
                case "c++ data structures":
                    mWebView.loadUrl("http://www.cplusplus.com/doc/tutorial/structures/");
                    break;
                default:
                    String error = "Sorry, we couldn't find anything about ";
                    Toast.makeText(getApplicationContext(), error + search + " :(", Toast.LENGTH_SHORT)
                            .show();

            }
        }

        //if we don't have internet, access cached files.
        else
        {
            switch (search)
            {
                //Java searches
                case "arraylist":
                case "java arraylist":
                    mWebView.loadUrl("file:///android_asset/arraylist.html");
                    break;
                case "java array":
                    mWebView.loadUrl("file:///android_asset/array.html");
                    break;
                case "java linkedlist":
                    mWebView.loadUrl("file:///android_asset/linkedlist.html");
                    break;
                case "java stack":
                    mWebView.loadUrl("file:///android_asset/linkedlist.html");
                    break;
                case "java data types":
                    mWebView.loadUrl("file:///android_asset/javadatatypes.html");

                //database searches
                case "sql commands":
                case "sql insert":
                case "sql delete":
                case "sql create table":
                case "sql query":
                    mWebView.loadUrl("file:///android_asset/database.html");
                    break;

                //systems searches
                case "linux commands":
                    mWebView.loadUrl("file:///android_asset/linux.html");
                    break;
                case "gdb":
                case "gdb commands":
                case "gdb tutorial":
                    mWebView.loadUrl("file:///android_asset/gdb.html");
                    break;
                case "x86 assembly":
                    mWebView.loadUrl("file:///android_asset/x86.html");
                    break;
                case "c structs":
                    mWebView.loadUrl("file:///android_asset/cstructs.html");
                    break;
                case "c data types":
                    mWebView.loadUrl("file:///android_asset/cdatatypes.html");
                    break;
                case "c strings":
                    mWebView.loadUrl("file:///android_asset/cstrings.html");
                    break;
                case "c++ data types":
                    mWebView.loadUrl("file:///android_asset/cppdatatypes.html");
                    break;
                case "c++ data structures":
                    mWebView.loadUrl("file:///android_asset/cppdatastructs.html");
                    break;
                default:
                    String error = "Sorry, we couldn't find anything about ";
                    Toast.makeText(getApplicationContext(), error + search + " :(", Toast.LENGTH_SHORT)
                            .show();
            }

        }
    }

    //helper method to check for network access.
    private boolean hasInternetAccess()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
