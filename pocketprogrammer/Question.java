package cameron.boles.android.pocketprogrammer;

/**
 * Created by Eric Moore on 10/30/2016.
 *
 * Class for Question object.
 */

public class Question {

    private String mRandomQuestion;
    private int mAnswerQuestion;

    public Question(String randomQuestion, int answerQuestion)
    {
        mRandomQuestion = randomQuestion;
        mAnswerQuestion = answerQuestion;
    }

    public String getRandomQuestion() {
        return mRandomQuestion;
    }

    public void setRandomQuestion(String randomQuestion) {
        mRandomQuestion = randomQuestion;
    }

    public int isAnswerTrue() {
        return mAnswerQuestion;
    }

    public void setAnswerQuestion(int answerQuestion) {
        mAnswerQuestion = answerQuestion;
    }
}
