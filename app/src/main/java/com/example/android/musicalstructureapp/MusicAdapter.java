package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ti6a on 17-Mar-18.
 */

public class MusicAdapter extends ArrayAdapter<Music> {
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param songs A List of Music objects to display in a list
     */
    public MusicAdapter(Activity context, ArrayList<Music> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Music} object located at this position in the list
        Music currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID song_text_view
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);
        // Get the song title from the current Music object and
        // set this text on the song TextView
        songTextView.setText(currentSong.getsongTitle());

        // Find the TextView in the list_item.xml layout with the ID artist_text_view
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the artist name from the current Music object and
        // set this text on the artist TextView
        artistTextView.setText(currentSong.getartistName());

        // Find the ImageView in the list_item.xml layout with the ID album_art_image
        ImageView albumArtView = (ImageView) listItemView.findViewById(R.id.album_art_image);
        // Get the image resource ID from the current Music object and
        // set the image to albumArtView
        albumArtView.setImageResource(currentSong.getalbumArtId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
