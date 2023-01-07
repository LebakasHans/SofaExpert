package at.htlgkr.sofaexpert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends BaseAdapter {
    public static final String PICTURE_BASEPATH = "http://image.tmdb.org/t/p/w154/";
    private List<Movie> movies;
    private int layoutId;
    private LayoutInflater inflater;

    public MovieAdapter(Context context, int listViewItemLayoutId, List<Movie> movies) {
        this.movies = movies;
        this.layoutId = listViewItemLayoutId;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = movies.get(position);
        View listItem = (convertView == null) ? inflater.inflate(this.layoutId, null) : convertView;
        Picasso.get()
                .load(PICTURE_BASEPATH + movie.getPoster_path())
                .into((ImageView) listItem.findViewById(R.id.moviePicture));
        return listItem;
    }
}
