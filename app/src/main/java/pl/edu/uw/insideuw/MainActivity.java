package pl.edu.uw.insideuw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ServerAPIClient(getApplicationContext()).setSampleJSON((TextView)findViewById(R.id.textView1));
    }
}
