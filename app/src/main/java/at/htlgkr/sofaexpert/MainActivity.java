package at.htlgkr.sofaexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String jsonFile = "movies.json";
    private GridView gridView_Pictures;
    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpGridView();
    }

    private void setUpGridView() {
        MyJSONParser myJsonParser = null;

        try {
            myJsonParser = new MyJSONParser(getAssets().open(jsonFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Movie> movies = myJsonParser.getMovies();
        gridView_Pictures = findViewById(R.id.gridView_Pictures);
        mMovieAdapter = new MovieAdapter(this, R.layout.gridview_pictures_items_layout, movies);
        gridView_Pictures.setAdapter(mMovieAdapter);

        gridView_Pictures.setOnItemClickListener((parent, view, position, id) ->{
            Intent intent = new Intent(this, Detailed_Movie_Activity.class);
            intent.putExtra("movie", movies.get(position));
            startActivity(intent);
        });
    }
}