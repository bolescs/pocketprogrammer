package cameron.boles.android.pocketprogrammer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by Cameron Boles on 11/29/16.
 */

public class ExampleCodeActivity extends AppCompatActivity
{
    private TextView codeText;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_code);

        codeText = (TextView) findViewById(R.id.code_text);

        String code = getIntent().getStringExtra("caller");

        if (code.equals("java")) {

            codeText.setText("/* Hello World program */\n" +
                    "\n" +
                    "public static void main(String[] args)\n" +
                    "{\n" +
                    "\tSystem.out.println(\"Hello World\");\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "/* Sum array program */\n" +
                    "\n" +
                    "public static void main(String[] args)\n" +
                    "{\n" +
                    "\tint[] array = {1,2,3,4,5};\n" +
                    "\tint sum = 0;\n" +
                    "\t\n" +
                    "\tfor(int i = 0; i < array.length(); i++)\n" +
                    "\t{\n" +
                    "\t\tsum += array[i];\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\tSystem.out.println(sum);\t\n" +
                    "}");
        }
        else if (code.equals("c"))
        {
            codeText.setText("/* Hello World program */\n" +
                    "\n" +
                    "#include<stdio.h>\n" +
                    "\n" +
                    "void main()\n" +
                    "{\n" +
                    "\tprintf(%s, \"Hello World\");\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "/* Sum array program */\n" +
                    "\n" +
                    "#include<stdio.h>\n" +
                    "\n" +
                    "void main()\n" +
                    "{\n" +
                    "\tint array[] = {1,2,3,4,5};\n" +
                    "\tint sum = 0;\n" +
                    "\tint i;\n" +
                    "\t\n" +
                    "\tfor(i = 0; i < sizeof(array); i++)\n" +
                    "\t{\n" +
                    "\t\tsum += array[i];\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\tprintf(%d, sum);\n" +
                    "}");
        }
        else
        {
            codeText.setText("/* Hello World program */\n" +
                    "\n" +
                    "#include <iostream>\n" +
                    "\n" +
                    "int main()\n" +
                    "{\n" +
                    "\tstd::cout << \"Hello World\" << std::endl;\n" +
                    "\t\n" +
                    "\treturn 0;\n" +
                    "}\n" +
                    "\n" +
                    "/* Sum array program */\n" +
                    "\n" +
                    "#include <iostream>\n" +
                    "\n" +
                    "int main()\n" +
                    "{\n" +
                    "\tint array[] = {1,2,3,4,5};\n" +
                    "\tint sum = 0;\n" +
                    "\tint i;\n" +
                    "\t\n" +
                    "\tfor(i = 0; i < sizeof(array); i++)\n" +
                    "\t{\n" +
                    "\t\tsum += array[i];\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\tstd::cout << sum << std::endl;\n" +
                    "\t\n" +
                    "\treturn 0;\n" +
                    "}");
        }
    }
}
