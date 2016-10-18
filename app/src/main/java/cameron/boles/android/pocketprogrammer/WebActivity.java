package cameron.boles.android.pocketprogrammer;

/**
 * Created by yellowpepper83 on 10/13/16.
 */

import android.content.Context;
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

        //These lines will allow us to check for an internet connection.
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (hasInternetAccess())
        {
            if (search.equals("arraylist"))
            {
                setTitle("ArrayList");
                mWebView.loadUrl("https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html");
            }
        }

        else
        {
            Toast.makeText(getApplicationContext(), "Please enter a decimal value", Toast.LENGTH_SHORT)
                    .show();

            if (search.equals("arraylist")) {
                setTitle("ArrayList");
                mWebView.loadUrl("file:///android_asset/arraylist.html");
            } else if (search.equals("array")) {
                setTitle("Array");
                mWebView.loadUrl("file:///android_asset/array.html");
            }

        }
        /**
        else if (search.equals("linkedlist"))
        {
            setTitle("Array");
            mWebView.loadUrl("file:///android_asset/linkedlist.html");
        }
        else if (search.equals("hashmap"))
        {
            setTitle("Array");
            mWebView.loadUrl("file:///android_asset/hashmap.html");
        }
        else if (search.equals(""))
        {
            setTitle("Array");
            mWebView.loadUrl("file:///android_asset/array.html");
        }
        else if (search.equals("array"))
        {
            setTitle("Array");
            mWebView.loadUrl("file:///android_asset/array.html");
        }
        else if (search.equals("array"))
        {
            setTitle("Array");
            mWebView.loadUrl("file:///android_asset/array.html");
        }
        else if (search.equals("array"))
        {
            setTitle("Array");
            mWebView.loadUrl("file:///android_asset/array.html");
        }
        else if (search.equals("array"))
        {
            setTitle("Array");
            mWebView.loadUrl("file:///android_asset/array.html");
        }
        else if (search.equals("array"))
        {
            setTitle("Array");
            mWebView.loadUrl("file:///android_asset/array.html");
        }
         */
    }

    private boolean hasInternetAccess()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
