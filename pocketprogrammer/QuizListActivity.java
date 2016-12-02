package cameron.boles.android.pocketprogrammer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Cameron Boles on 11/5/16.
 *
 * Class for displaying each quiz you can take.
 */

public class QuizListActivity extends AppCompatActivity
{
    private ListView mQuizList;

    //Array of choices
    String[] chooseQuiz = {"Binary to Decimal", "Binary to Hex"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, chooseQuiz);

        mQuizList = (ListView) findViewById(R.id.quiz_list);
        mQuizList.setAdapter(adapter);

        mQuizList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    //Bin to Dec
                    case 0:
                        setTitle("Binary to Decimal");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent = new Intent(parent.getContext(), BinToDecQuiz.class);
                        startActivity(intent);
                        break;

                    //Bin to Hex
                    case 1:
                        setTitle("Binary to Hex");
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                        Intent intent1 = new Intent(parent.getContext(), BinToHexQuiz.class);
                        startActivity(intent1);
                        break;

                    default:
                        break;
                }
            }
        });
    }
}
