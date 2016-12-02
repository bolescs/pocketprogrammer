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
 * Created by Cameron Boles on 11/29/16.
 *
 * simple fragment for binary tab of converter.
 */

public class BinConvertFragment extends Fragment 
{
    private EditText binEnter;
    private Button binConvert;
    private TextView decAnswer;
    private TextView hexAnswer;

    public BinConvertFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_bin_conv, container, false);

        binEnter = (EditText) view.findViewById(R.id.bin_enter_convert);
        binConvert = (Button) view.findViewById(R.id.bin_convert);
        decAnswer = (TextView) view.findViewById(R.id.bin_to_dec_text);
        hexAnswer = (TextView) view.findViewById(R.id.bin_to_hex_text);

        binConvert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(binEnter.getWindowToken(), 0);
                try
                {
                    String binInput = binEnter.getText().toString();
                    int decimal = Integer.parseInt(binInput, 2);
                    String dec = Integer.toString(decimal);
                    String hex = Integer.toHexString(decimal);
                    decAnswer.setText("Dec:  " + dec);
                    hexAnswer.setText("Hex:  " + hex);
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Please enter a binary value", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        return view;
    }
}
