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
 * Fragment used in decimal tab of converter.
 */

public class DecConvertFragment extends Fragment
{
    private EditText decEnter;
    private Button decConvert;
    private TextView hexAnswer;
    private TextView binAnswer;

    public DecConvertFragment()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_dec_conv, container, false);

        decEnter = (EditText) view.findViewById(R.id.dec_enter_convert);
        decConvert = (Button) view.findViewById(R.id.dec_convert);
        hexAnswer = (TextView) view.findViewById(R.id.dec_to_hex_text);
        binAnswer = (TextView) view.findViewById(R.id.dec_to_bin_text);

        decConvert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(decEnter.getWindowToken(), 0);
                try
                {
                    int decInput = Integer.parseInt(decEnter.getText().toString());
                    String hex = Integer.toHexString(decInput);
                    String bin = Integer.toBinaryString(decInput);
                    hexAnswer.setText("Hex:  " + hex);
                    binAnswer.setText("Binary:  " + bin);
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(getActivity(), "Please enter a decimal value", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        return view;
    }

}
