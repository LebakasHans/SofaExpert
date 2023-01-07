package at.htlgkr.sofaexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String jsonFile = "movies.json";
    private GridView gridView_Pictures;
    private MovieAdapter mMovieAdapter;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpGridView();
    }

    private void setUpGridView() {
        MyJsonParser myJsonParser = null;
        try {
            myJsonParser = new MyJsonParser(getAssets().open(jsonFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        gridView_Pictures = findViewById(R.id.gridView_Pictures);
        mMovieAdapter = new MovieAdapter(this, R.layout.gridview_pictures_items_layout, myJsonParser.getMovies());
        gridView_Pictures.setAdapter(mMovieAdapter);

        gridView_Pictures.setOnItemClickListener((parent, view, position, id) ->{

                });
    }
}