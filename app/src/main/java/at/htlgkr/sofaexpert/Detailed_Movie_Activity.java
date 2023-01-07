package at.htlgkr.sofaexpert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.time.format.DateTimeFormatter;

public class Detailed_Movie_Activity extends AppCompatActivity {
    private Movie movie;
    private TextView title;
    private TextView rating;
    private ImageView poster;
    private TextView realeasedate;
    private TextView overview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_movie);

        title = findViewById(R.id.txt_title);
        rating = findViewById(R.id.txt_rating);
        poster = findViewById(R.id.img_poster);
        realeasedate = findViewById(R.id.txt_releasedate);
        overview = findViewById(R.id.txt_overview);

        movie = (Movie) getIntent().getSerializableExtra("movie");
        title.setText(movie.getTitle());
        rating.setText(movie.getVote_average() + "/10");
        Picasso.get()
                .load(MovieAdapter.PICTURE_BASEPATH + movie.getPoster_path())
                .into(poster);
        realeasedate.setText(movie.getRelease_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        overview.setText(movie.getOverview());
    }
}