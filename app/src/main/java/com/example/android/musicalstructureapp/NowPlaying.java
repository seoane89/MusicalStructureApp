package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlaying extends AppCompatActivity {
    final static String SONG_KEY = "song_key";
    final static String ARTIST_KEY = "artist_key";
    final static String ALBUM_SRC_KEY = "album_art_src";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

//we take the extras from the previous activity
        Bundle extras = getIntent().getExtras();
        //we find the IDs of the views
        ImageView albumArtBig = (ImageView) findViewById(R.id.album_art_big);
        TextView songNameView = (TextView) findViewById(R.id.song_text_view2);
        TextView artistNameView = (TextView) findViewById(R.id.artist_text_view2);
        // Set the content we have passed trough activities
        albumArtBig.setImageResource(extras.getInt(ALBUM_SRC_KEY));
        songNameView.setText(extras.getString(SONG_KEY));
        artistNameView.setText(extras.getString(ARTIST_KEY));

        //find the image views for the buttons
        ImageView skipBackButton = (ImageView) findViewById(R.id.large_skip_back_button);
        ImageView skipForwardButton = (ImageView) findViewById(R.id.large_skip_forward_button);
        ImageView playButton = (ImageView) findViewById(R.id.large_play_button);
        ImageView playlistButton = (ImageView) findViewById(R.id.playlist_button);

        //set the onClick listeners for each button

        skipBackButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), R.string.skip_previous_song,
                        Toast.LENGTH_SHORT).show();
            }
        });

        skipForwardButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), R.string.skip_next_song,
                        Toast.LENGTH_SHORT).show();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), R.string.play_song,
                        Toast.LENGTH_SHORT).show();
            }
        });
        playlistButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(NowPlaying.this, YourMusic.class);
                startActivity(ii);
            }
        });
    }
}



