package cameron.boles.android.pocketprogrammer;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Cameron Boles
 *
 * A simple {@link Fragment} subclass subclass used for decimal tab of calculator
 */
public class DecCalcFragment extends Fragment
{
    //enter operands
    private EditText mLeftOperand;
    private EditText mRightOperand;

    //chose operation
    private Button mAddDec;
    private Button mSubDec;
    private Button mMultDec;
    private Button mDivDec;
    private Button mLeftShift;
    private Button mRightShift;

    //display answer
    private TextView mDecAnswer;
    private TextView mHexConvert;
    private TextView mBinConvert;

    //constructor
    public DecCalcFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_dec_calc, container, false);

        mLeftOperand = (EditText) view.findViewById(R.id.dec_left_operand);
        mRightOperand = (EditText) view.findViewById(R.id.dec_right_operand);
        mAddDec = (Button) view.findViewById(R.id.dec_add_button);
        mSubDec = (Button) view.findViewById(R.id.dec_sub_button);
        mMultDec = (Button) view.findViewById(R.id.dec_mult_button);
        mDivDec = (Button) view.findViewById(R.id.dec_div_button);
        mLeftShift = (Button) view.findViewById(R.id.dec_left_shift_button);
        mRightShift = (Button) view.findViewById(R.id.dec_right_shift_button);
        mDecAnswer = (TextView) view.findViewById(R.id.dec_answer);
        mHexConvert = (TextView) view.findViewById(R.id.hex_convert);
        mBinConvert = (TextView) view.findViewById(R.id.bin_convert);


        //add dec
        mAddDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long decNum1 = Long.parseLong(leftInput);
                    long decNum2 = Long.parseLong(rightInput);
                    String decAnswer = Long.toString(decNum1 + decNum2);
                    String hexAnswer = Long.toHexString(decNum1 + decNum2);  //Long.toString(Integer.parseInt(decAnswer));
                    String binAnswer = Long.toBinaryString(decNum1 + decNum2);
                    mDecAnswer.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //subtract dec
        mSubDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long decNum1 = Long.parseLong(leftInput);
                    long decNum2 = Long.parseLong(rightInput);
                    String decAnswer = Long.toString(decNum1 - decNum2);
                    String hexAnswer = Long.toHexString(decNum1 - decNum2);
                    String binAnswer = Long.toBinaryString(decNum1 - decNum2);
                    mDecAnswer.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //multiply dec
        mMultDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long decNum1 = Long.parseLong(leftInput);
                    long decNum2 = Long.parseLong(rightInput);
                    String decAnswer = Long.toString(decNum1 * decNum2);
                    String hexAnswer = Long.toHexString(decNum1 * decNum2);
                    String binAnswer = Long.toBinaryString(decNum1 * decNum2);
                    mDecAnswer.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //divide dec
        mDivDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long decNum1 = Long.parseLong(leftInput);
                    long decNum2 = Long.parseLong(rightInput);
                    String decAnswer = Long.toString(decNum1 / decNum2);
                    String hexAnswer = Long.toHexString(decNum1 / decNum2);
                    String binAnswer = Long.toBinaryString(decNum1 / decNum2);
                    mDecAnswer.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //shift left
        mLeftShift.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long decNum1 = Long.parseLong(leftInput);
                    long decNum2 = Long.parseLong(rightInput);
                    String decAnswer = Long.toString(decNum1 << decNum2);
                    String hexAnswer = Long.toHexString(decNum1 << decNum2);
                    String binAnswer = Long.toBinaryString(decNum1 << decNum2);
                    mDecAnswer.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //shift right
        mRightShift.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long decNum1 = Long.parseLong(leftInput);
                    long decNum2 = Long.parseLong(rightInput);
                    String decAnswer = Long.toString(decNum1 >> decNum2);
                    String hexAnswer = Long.toHexString(decNum1 >> decNum2);
                    String binAnswer = Long.toBinaryString(decNum1 >> decNum2);
                    mDecAnswer.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Decimal Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
