package at.htlgkr.sofaexpert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class MyJsonParser {
    private List<Movie> movies = new ArrayList<>();

    public MyJsonParser(InputStream inputStream) {
        parse(inputStream);
    }

    private void parse(InputStream inputStream){
        String jsonString = null;

        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            jsonString = new String(buffer, "UTF-8");
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray results = jsonObject.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                int vote_count = result.getInt("vote_count");
                int id = result.getInt("id");
                boolean video = result.getBoolean("video");
                double vote_average = result.getDouble("vote_average");
                String title = result.getString("title");
                double popularity = result.getDouble("popularity");
                String poster_path = result.getString("poster_path");
                String original_language = result.getString("original_language");
                String original_title = result.getString("original_title");
                JSONArray jsonArray_genre_ids = result.getJSONArray("genre_ids");
                int[] genre_ids = new int[jsonArray_genre_ids.length()];
                for (int j = 0; j < jsonArray_genre_ids.length(); j++) {
                    genre_ids[j] = jsonArray_genre_ids.getInt(j);
                }
                String backdrop_path = result.getString("backdrop_path");
                boolean adult = result.getBoolean("adult");
                String overview = result.getString("overview");
                LocalDate release_date = LocalDate.parse(result.getString("release_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                movies.add(new Movie(vote_count
                        ,id
                        ,video
                        ,vote_average
                        ,title
                        ,popularity
                        ,poster_path
                        ,original_language
                        ,original_title
                        ,genre_ids
                        ,backdrop_path
                        ,adult
                        ,overview
                        ,release_date));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
