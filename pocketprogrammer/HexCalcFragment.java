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

import org.w3c.dom.Text;


/**
 * Created by Cameron Boles
 *
 * A simple {@link Fragment} subclass used for hex tab of calculator.
 */
public class HexCalcFragment extends Fragment
{
    //enter operands
    private EditText mLeftOperand;
    private EditText mRightOperand;

    //chose operation
    private Button mAddHex;
    private Button mSubHex;
    private Button mMultHex;
    private Button mDivHex;
    private Button mLeftShift;
    private Button mRightShift;

    //display answer
    private TextView mHexAnswer;
    private TextView mDecConvert;
    private TextView mBinConvert;

    //constructor
    public HexCalcFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_hex_calc, container, false);

        mLeftOperand = (EditText) view.findViewById(R.id.hex_left_operand);
        mRightOperand = (EditText) view.findViewById(R.id.hex_right_operand);
        mAddHex = (Button) view.findViewById(R.id.hex_add_button);
        mSubHex = (Button) view.findViewById(R.id.hex_sub_button);
        mMultHex = (Button) view.findViewById(R.id.hex_mult_button);
        mDivHex = (Button) view.findViewById(R.id.hex_div_button);
        mLeftShift = (Button) view.findViewById(R.id.hex_left_shift_button);
        mRightShift = (Button) view.findViewById(R.id.hex_right_shift_button);
        mHexAnswer = (TextView) view.findViewById(R.id.hex_answer);
        mDecConvert = (TextView) view.findViewById(R.id.dec_convert);
        mBinConvert = (TextView) view.findViewById(R.id.bin_convert);


        //add hex
        mAddHex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long hexNum1 = Long.parseLong(leftInput, 16);
                    long hexNum2 = Long.parseLong(rightInput, 16);
                    String hexAnswer = Long.toHexString(hexNum1 + hexNum2);
                    String decAnswer = Long.toString(hexNum1 + hexNum2);  //Long.toString(Integer.parseInt(hexAnswer, 16));
                    String binAnswer = Long.toBinaryString(hexNum1 + hexNum2);
                    mHexAnswer.setText("Hex:  " + hexAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Hex Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //subtract hex
        mSubHex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long hexNum1 = Long.parseLong(leftInput, 16);
                    long hexNum2 = Long.parseLong(rightInput, 16);
                    String hexAnswer = Long.toHexString(hexNum1 - hexNum2);
                    String decAnswer = Long.toString(hexNum1 - hexNum2);
                    String binAnswer = Long.toBinaryString(hexNum1 - hexNum2);
                    mHexAnswer.setText("Hex:  " + hexAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Hex Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //multiply hex
        mMultHex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long hexNum1 = Long.parseLong(leftInput, 16);
                    long hexNum2 = Long.parseLong(rightInput, 16);
                    String hexAnswer = Long.toHexString(hexNum1 * hexNum2);
                    String decAnswer = Long.toString(hexNum1 * hexNum2);
                    String binAnswer = Long.toBinaryString(hexNum1 * hexNum2);
                    mHexAnswer.setText("Hex:  " + hexAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Hex Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //divide hex
        mDivHex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long hexNum1 = Long.parseLong(leftInput, 16);
                    long hexNum2 = Long.parseLong(rightInput, 16);
                    String hexAnswer = Long.toHexString(hexNum1 / hexNum2);
                    String decAnswer = Long.toString(hexNum1 / hexNum2);
                    String binAnswer = Long.toBinaryString(hexNum1 / hexNum2);
                    mHexAnswer.setText("Hex:  " + hexAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Hex Numbers Only", Toast.LENGTH_SHORT).show();
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
                    long hexNum1 = Long.parseLong(leftInput, 16);
                    long hexNum2 = Long.parseLong(rightInput, 16);
                    String hexAnswer = Long.toHexString(hexNum1 << hexNum2);
                    String decAnswer = Long.toString(hexNum1 << hexNum2);
                    String binAnswer = Long.toBinaryString(hexNum1 << hexNum2);
                    mHexAnswer.setText("Hex:  " + hexAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Hex Numbers Only", Toast.LENGTH_SHORT).show();
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
                    long hexNum1 = Long.parseLong(leftInput, 16);
                    long hexNum2 = Long.parseLong(rightInput, 16);
                    String hexAnswer = Long.toHexString(hexNum1 >> hexNum2);
                    String decAnswer = Long.toString(hexNum1 >> hexNum2);
                    String binAnswer = Long.toBinaryString(hexNum1 >> hexNum2);
                    mHexAnswer.setText("Hex:  " + hexAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mBinConvert.setText("Binary:  " + binAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Hex Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
