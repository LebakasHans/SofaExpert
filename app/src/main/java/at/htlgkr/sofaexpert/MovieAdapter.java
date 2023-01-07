package at.htlgkr.sofaexpert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class MovieAdapter extends BaseAdapter {
    private List<Movie> list;
    private int layoutId;
    private LayoutInflater inflater;

    public MovieAdapter(Context context, int listViewItemLayoutId, List<Movie> list) {//TODO change list from ? to type
        this.list = list;
        this.layoutId = listViewItemLayoutId;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
