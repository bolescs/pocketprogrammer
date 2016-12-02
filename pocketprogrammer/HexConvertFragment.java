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
 * Fragment used for hex tab of converter.
 */

public class HexConvertFragment extends Fragment 
{
    private EditText hexEnter;
    private Button hexConvert;
    private TextView decAnswer;
    private TextView binAnswer;

    public HexConvertFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_hex_conv, container, false);

        hexEnter = (EditText) view.findViewById(R.id.hex_enter_convert);
        hexConvert = (Button) view.findViewById(R.id.hex_convert);
        decAnswer = (TextView) view.findViewById(R.id.hex_to_dec_text);
        binAnswer = (TextView) view.findViewById(R.id.hex_to_bin_text);

        hexConvert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(hexEnter.getWindowToken(), 0);
                try
                {
                    String hexInput = hexEnter.getText().toString();
                    int decimal = Integer.parseInt(hexInput, 16);
                    String dec = Integer.toString(decimal);
                    String bin = Integer.toBinaryString(decimal);
                    decAnswer.setText("Dec:  " + dec);
                    binAnswer.setText("Binary:  " + bin);
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Please enter a hex value", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        return view;
    }
}
