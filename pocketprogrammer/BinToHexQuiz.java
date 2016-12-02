package cameron.boles.android.pocketprogrammer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Eric Moore on 11/5/2016.
 *
 * activity to handle binary to hex quiz.
 */

public class BinToHexQuiz extends AppCompatActivity {

    private long beginTime;
    private long endTime;

    private TextView questionText;
    private EditText answerText;
    private Button answerButton;
    private TextView resultsText;
    private TextView timeTakenText;
    private TextView totalText;
    private TextView introText;
    private Button beginButton;
    private Button tryAgain;

    private int binaryQuestionAnswer;
    private int currentIndex = 0;
    private int correctCount = 0;


    //random question
    public String generateRandomBinaryQuestion() {
        Random randomBin = new Random();
        int num = randomBin.nextInt(256);
        String answer = Integer.toBinaryString(num);
        binaryQuestionAnswer = num;
        return answer;
    }

    //10 questions
    private Question[] questionBank = new Question[]{
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer),
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer),
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer),
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer),
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer),
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer),
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer),
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer),
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer),
            new Question(generateRandomBinaryQuestion(), binaryQuestionAnswer)
    };

    private void updateQuestion() {
        String question = questionBank[currentIndex].getRandomQuestion();
        questionText.setText(question);
    }

    private void checkAnswer(String userAnswer) {
        int trueAnswer = questionBank[currentIndex].isAnswerTrue();
        String answer = Integer.toHexString(trueAnswer);
        int toastMessage = 0;

        if(userAnswer.compareTo(answer) == 0) {
            toastMessage = R.string.correct_toast;
            correctCount++;
        }
        else {
            toastMessage = R.string.incorrect_toast;
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_intro);
        introText = (TextView) findViewById(R.id.quiz_convert_info);
        beginButton = (Button) findViewById(R.id.begin_button);
        String intro = "Convert the following binary numbers to hex.\n"
                + "\nYou have 45 seconds";
        introText.setText(intro);

        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setContentView(R.layout.activity_quiz);

                questionText = (TextView) findViewById(R.id.question_text);
                answerText = (EditText) findViewById(R.id.question_answer);
                //answerButton = (Button) findViewById(R.id.quiz_answer_button);

                beginTime = System.currentTimeMillis() / 1000;

                updateQuestion();

                answerText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_DONE)
                        {
                            endTime = System.currentTimeMillis() / 1000;
                            //if time is up
                            if ((endTime -  beginTime) >= 45)
                            {
                                setContentView(R.layout.activity_quiz_results);
                                timeTakenText = (TextView) findViewById(R.id.timer_header);
                                resultsText = (TextView) findViewById(R.id.results_count);
                                totalText = (TextView) findViewById(R.id.total_count);
                                tryAgain = (Button) findViewById(R.id.try_again_button);

                                String count = Integer.toString(correctCount);
                                String correctCount = "CORRECT:" + "\t" + "\t" + "\t" + "\t" + count;
                                resultsText.setText(correctCount);

                                String totalQuest = "OUT OF:" + "\t" + "\t" + "\t" + "\t" + questionBank.length;
                                totalText.setText(totalQuest);

                                String timeOver = Long.toString((endTime -  beginTime) - 45);
                                String timeTaken = "TIME:" + "\t" + "\t" + "\t" + "\tOver by " + timeOver + " seconds.";
                                timeTakenText.setText(timeTaken);

                                tryAgain.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(getApplicationContext(), BinToHexQuiz.class);
                                        finish();
                                        startActivity(i);
                                    }
                                });
                            }
                            //if quiz finished
                            else if(currentIndex == questionBank.length - 1) {
                                String answer = answerText.getText().toString();
                                int parse = Integer.parseInt(answer, 16);
                                String answer2 = Integer.toHexString(parse);
                                checkAnswer(answer2);

                                endTime = System.currentTimeMillis() / 1000;
                                setContentView(R.layout.activity_quiz_results);
                                timeTakenText = (TextView) findViewById(R.id.timer_header);
                                resultsText = (TextView) findViewById(R.id.results_count);
                                totalText = (TextView) findViewById(R.id.total_count);
                                tryAgain = (Button) findViewById(R.id.try_again_button);

                                String count = Integer.toString(correctCount);
                                String correctCount = "CORRECT:" + "\t" + "\t" + "\t" + "\t" + count;
                                resultsText.setText(correctCount);

                                String totalQuest = "OUT OF:" + "\t" + "\t" + "\t" + "\t" + questionBank.length;
                                totalText.setText(totalQuest);

                                String timer = Long.toString(endTime - beginTime);
                                String timeTaken = "TIME:" + "\t" + "\t" + "\t" + "\t" + timer + " seconds";
                                timeTakenText.setText(timeTaken);

                                tryAgain.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(getApplicationContext(), BinToHexQuiz.class);
                                        finish();
                                        startActivity(i);
                                    }
                                });
                            }
                            //check answer, next question
                            else
                            {
                                try {
                                    String answer = answerText.getText().toString();
                                    int parse = Integer.parseInt(answer, 16);
                                    String answer2 = Integer.toHexString(parse);
                                    checkAnswer(answer2);
                                    currentIndex++;
                                    updateQuestion();
                                    answerText.getText().clear();
                                }
                                catch (NumberFormatException e)
                                {
                                    Toast.makeText(getApplicationContext(), "Enter a hex value", Toast.LENGTH_SHORT)
                                            .show();
                                }
                            }
                            handled = true;
                        }
                        return handled;
                    }
                });

            }
        });
    }
}
