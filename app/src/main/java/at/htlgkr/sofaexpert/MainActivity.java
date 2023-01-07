package at.htlgkr.sofaexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String jsonFile = "movies.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            MyJsonParser.parse(this.getAssets().open(jsonFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}