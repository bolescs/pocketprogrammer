package cameron.boles.android.pocketprogrammer;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Cameron Boles on 10/4/16.
 *
 * Home page activity.  Allows for choosing between list of options, searching for topic,
 *      and using voice search.
 */
public class ChooseClassActivity extends AppCompatActivity
{
    private final int SPEECH_RECOGNITION_CODE = 1;

    private ListView mclassList;
    private ImageButton mSpeech;
    //Array of choices.
    String[] classes = {"Notes", "Converter", "Calculator", "Java", "Systems", "Database", "Quizzes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_class);

        mSpeech = (ImageButton) findViewById(R.id.speech_button);
        mSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                startSpeechToText();
            }
        });

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_class_listview, classes);

        mclassList = (ListView) findViewById(R.id.class_list);
        mclassList.setAdapter(adapter);

        //allow for list of topics to be clicked.  When clicked, launch specified activity.
        mclassList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    //Notes
                    case 0:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent = new Intent(parent.getContext(), NoteListActivity.class);
                        startActivity(intent);
                        break;

                    //Converter
                    case 1:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent1 = new Intent(parent.getContext(), ConverterTabActivity.class);
                        startActivity(intent1);
                        break;

                    //Calculator
                    case 2:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent2 = new Intent(parent.getContext(), CalculatorTabActivity.class);
                        startActivity(intent2);
                        break;

                    //Java
                    case 3:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent3 = new Intent(parent.getContext(), JavaActivity.class);
                        startActivity(intent3);
                        break;

                    //Systems
                    case 4:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent4 = new Intent(parent.getContext(), SystemsActivity.class);
                        startActivity(intent4);
                        break;

                    //Database
                    case 5:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent5 = new Intent(parent.getContext(), DatabaseActivity.class);
                        startActivity(intent5);
                        break;

                    //Quizzes
                    case 6:
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent6 = new Intent(parent.getContext(), QuizListActivity.class);
                        startActivity(intent6);
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

            case R.id.menu_item_recents:
                Intent intent2 = new Intent(this, RecentsActivity.class);
                startActivity(intent2);
                return true;

            case R.id.menu_item_settings:
                Intent intent3 = new Intent(this, SettingsActivity.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Start speech to text intent. This opens up Google Speech Recognition API dialog box to listen the speech input.
     * */
    private void startSpeechToText() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Speak something...");
        try {
            startActivityForResult(intent, SPEECH_RECOGNITION_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Speech recognition is not supported in this device.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Callback for speech recognition activity
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case SPEECH_RECOGNITION_CODE:
            {
                if (resultCode == RESULT_OK && null != data)
                {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String text = result.get(0);
                    Intent webIntent = new Intent(this, WebActivity.class);
                    webIntent.putExtra("search", text);
                    startActivity(webIntent);
                }
                break;
            }
        }
    }
}
