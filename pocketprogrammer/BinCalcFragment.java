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
 *
 * Created by Cameron Boles
 *
 * A simple {@link Fragment} subclass used for Binary tab of calculator
 *
 */
public class BinCalcFragment extends Fragment 
{
    //enter operands
    private EditText mLeftOperand;
    private EditText mRightOperand;

    //chose operation
    private Button mAddBin;
    private Button mSubBin;
    private Button mMultBin;
    private Button mDivBin;
    private Button mLeftShift;
    private Button mRightShift;

    //display answer
    private TextView mBinAnswer;
    private TextView mDecConvert;
    private TextView mHexConvert;
    

    //constructor
    public BinCalcFragment() 
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) 
    {
        View view = inflater.inflate(R.layout.fragment_bin_calc, container, false);

        mLeftOperand = (EditText) view.findViewById(R.id.bin_left_operand);
        mRightOperand = (EditText) view.findViewById(R.id.bin_right_operand);
        mAddBin = (Button) view.findViewById(R.id.bin_add_button);
        mSubBin = (Button) view.findViewById(R.id.bin_sub_button);
        mMultBin = (Button) view.findViewById(R.id.bin_mult_button);
        mDivBin = (Button) view.findViewById(R.id.bin_div_button);
        mLeftShift = (Button) view.findViewById(R.id.bin_left_shift_button);
        mRightShift = (Button) view.findViewById(R.id.bin_right_shift_button);
        mBinAnswer = (TextView) view.findViewById(R.id.bin_answer);
        mDecConvert = (TextView) view.findViewById(R.id.dec_convert);
        mHexConvert = (TextView) view.findViewById(R.id.hex_convert);


        //add bin
        mAddBin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long binNum1 = Long.parseLong(leftInput, 2);
                    long binNum2 = Long.parseLong(rightInput, 2);
                    String binAnswer = Long.toBinaryString(binNum1 + binNum2);
                    String decAnswer = Long.toString(binNum1 + binNum2);  //Long.toString(Integer.parseInt(binAnswer, 2));
                    String hexAnswer = Long.toHexString(binNum1 + binNum2);
                    mBinAnswer.setText("Binary:  " + binAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Binary Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //subtract bin
        mSubBin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long binNum1 = Long.parseLong(leftInput, 2);
                    long binNum2 = Long.parseLong(rightInput, 2);
                    String binAnswer = Long.toBinaryString(binNum1 - binNum2);
                    String decAnswer = Long.toString(binNum1 - binNum2);
                    String hexAnswer = Long.toHexString(binNum1 - binNum2);
                    mBinAnswer.setText("Binary:  " + binAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Binary Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //multiply bin
        mMultBin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long binNum1 = Long.parseLong(leftInput, 2);
                    long binNum2 = Long.parseLong(rightInput, 2);
                    String binAnswer = Long.toBinaryString(binNum1 * binNum2);
                    String decAnswer = Long.toString(binNum1 * binNum2);
                    String hexAnswer = Long.toHexString(binNum1 * binNum2);
                    mBinAnswer.setText("Binary:  " + binAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Binary Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //divide bin
        mDivBin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(mLeftOperand.getWindowToken(), 0);
                mgr.hideSoftInputFromWindow(mRightOperand.getWindowToken(), 0);
                try
                {
                    String leftInput = mLeftOperand.getText().toString();
                    String rightInput = mRightOperand.getText().toString();
                    long binNum1 = Long.parseLong(leftInput, 2);
                    long binNum2 = Long.parseLong(rightInput, 2);
                    String binAnswer = Long.toBinaryString(binNum1 / binNum2);
                    String decAnswer = Long.toString(binNum1 / binNum2);
                    String hexAnswer = Long.toHexString(binNum1 / binNum2);
                    mBinAnswer.setText("Binary:  " + binAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Binary Numbers Only", Toast.LENGTH_SHORT).show();
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
                    long binNum1 = Long.parseLong(leftInput, 2);
                    long binNum2 = Long.parseLong(rightInput, 2);
                    String binAnswer = Long.toBinaryString(binNum1 << binNum2);
                    String decAnswer = Long.toString(binNum1 << binNum2);
                    String hexAnswer = Long.toHexString(binNum1 << binNum2);
                    mBinAnswer.setText("Binary:  " + binAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Binary Numbers Only", Toast.LENGTH_SHORT).show();
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
                    long binNum1 = Long.parseLong(leftInput, 2);
                    long binNum2 = Long.parseLong(rightInput, 2);
                    String binAnswer = Long.toBinaryString(binNum1 >> binNum2);
                    String decAnswer = Long.toString(binNum1 >> binNum2);
                    String hexAnswer = Long.toHexString(binNum1 >> binNum2);
                    mBinAnswer.setText("Binary:  " + binAnswer);
                    mDecConvert.setText("Dec:  " + decAnswer);
                    mHexConvert.setText("Hex:  " + hexAnswer);
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Binary Numbers Only", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
        
    }

}
