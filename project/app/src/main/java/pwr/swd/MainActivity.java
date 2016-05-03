package pwr.swd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private Button mButton;
    private ArrayList<EditText> editTexts = new ArrayList<EditText>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (LinearLayout) findViewById(R.id.linearlayout);
        mButton = (Button) findViewById(R.id.btnAdd);
        Button mButton2 = (Button) findViewById(R.id.btnGetAdress);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText2 = createNewEditText();
                mLayout.addView(editText2);
                editTexts.add(editText2);

            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(EditText e: editTexts )
                    Log.v("EditText", e.getText().toString());
            }
        });

    }
    private EditText createNewEditText() {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        final EditText editText = new MyEditText(this);
        editText.setLayoutParams(lparams);

        return editText;
    }
}
