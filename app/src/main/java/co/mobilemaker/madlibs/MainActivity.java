package co.mobilemaker.madlibs;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    final static String LOG_TAG = MainActivity.class.getSimpleName();
    Button mShowMeButtom;
    EditText[] editTexts = new EditText[10];
    String[] words = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, String.valueOf(getIntent()));
        prepareButton();
        prepareEditTextsParameters();
    }

    private void prepareButton() {
        mShowMeButtom = (Button)findViewById(R.id.showMe_button);
        mShowMeButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ResultsActivity.class);
                for(int i = 0; i < 10; i++){
                    words[i] = editTexts[i].getText().toString();
                }
                intent.putExtra(Intent.EXTRA_TEXT,words);
                startActivity(intent);
            }
        });
    }

    private void prepareEditTextsParameters() {
        GenericTextWatcher gw = new GenericTextWatcher();
        editTexts[0] = (EditText)findViewById(R.id.relative_1_editText);
        editTexts[1] = (EditText)findViewById(R.id.adjective_1_editText);
        editTexts[2] = (EditText)findViewById(R.id.adjective_2_editText);
        editTexts[3] = (EditText)findViewById(R.id.nameOfPersonInRoom_editText);
        editTexts[4] = (EditText)findViewById(R.id.adjective_3_editText);
        editTexts[5] = (EditText)findViewById(R.id.verbEndingED_editText);
        editTexts[6] = (EditText)findViewById(R.id.bodyPart_editText);
        editTexts[7] = (EditText)findViewById(R.id.verbEndingING_editText);
        editTexts[8] = (EditText)findViewById(R.id.relative_2_editText);
        editTexts[9] = (EditText)findViewById(R.id.name_editText);
        for (int i = 0; i < 10 ; i++) {
            editTexts[i].addTextChangedListener(gw);
        }
    }

    private class GenericTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean allFill = false;
            for (int i = 0; i < 10; i++){
                if(TextUtils.isEmpty(editTexts[i].getText())){
                    toggleButton(false);
                    i = 10;
                }
                else{
                    toggleButton(true);
                }
            }
        }
    }

    private void toggleButton(Boolean state){
        mShowMeButtom.setEnabled(state);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
