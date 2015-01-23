package co.mobilemaker.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by diany_000 on 1/21/2015.
 */
public class ResultsActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        String[] results = getIntent().getStringArrayExtra(Intent.EXTRA_TEXT);
        TextView textView = (TextView)findViewById(R.id.textParameters_textView);
        textView.setText(" My " + results[0] + " bought a " + results[1] + " and " + results[2] + " ball, \n" +
                " it was a gift to "+ results[3] +". The "+ results[4] +" ball is \n" +
                " "+ results[5] +". This ball can be play with "+ results[6] +". \n" +
                " "+ results[7] +" is the best way to pick it up, then you \n" +
                " can give it to your "+ results[8] +", "+ results[9] +".");
    }
}
