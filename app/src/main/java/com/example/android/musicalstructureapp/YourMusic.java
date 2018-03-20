package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class YourMusic extends AppCompatActivity {
    final static String SONG_KEY = "song_key";
    final static String ARTIST_KEY = "artist_key";
    final static String ALBUM_SRC_KEY = "album_art_src";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_music);

        //Create an ArrayList of songs
        ArrayList<Music> songs = new ArrayList<Music>();
        songs.add(new Music("Lion For Real", "Kate Boy", R.drawable.lion_for_real));
        songs.add(new Music("Battles", "Emika", R.drawable.battles));
        songs.add(new Music("Reykjavik", "Brolin", R.drawable.reykjavik));
        songs.add(new Music("Silence for You", "Mononoke", R.drawable.silence_for_you));
        songs.add(new Music("Serpentine", "Oyinda", R.drawable.serpentine));
        songs.add(new Music("Crystaleyes", "AViVa", R.drawable.crystaleyes));
        songs.add(new Music("Scary People", "Georgi Kay", R.drawable.scary_people));
        songs.add(new Music("Too much", "Pale", R.drawable.too_much));
        songs.add(new Music("Fortify", "Kate Miller", R.drawable.fortify));
        songs.add(new Music("Heads Above", "WhoMadeWho", R.drawable.heads_above));
        songs.add(new Music("Expectations", "Sir Sly", R.drawable.expectations));
        songs.add(new Music("Kilometer", "Easter", R.drawable.kilometer));
        songs.add(new Music("Svitanok", "ONUKA", R.drawable.svitanok));
        songs.add(new Music("Wanted 2 Say", "Samaris", R.drawable.wanted_to_say));
        songs.add(new Music("Dalí", "Tanerélle", R.drawable.dali));
        songs.add(new Music("Heartburn", "IYES", R.drawable.heartburn_infatuate));
        songs.add(new Music("Blind", "SLO", R.drawable.blind));
        songs.add(new Music("Sleepwalker", "Blackchords", R.drawable.sleepwalker));
        songs.add(new Music("Free Fall", "GEMS", R.drawable.free_fall));
        songs.add(new Music("I Am", "T.O.", R.drawable.i_am));
        songs.add(new Music("Infatuate", "IYES", R.drawable.heartburn_infatuate));
        songs.add(new Music("Symmetry", "Klangkarussel", R.drawable.symmetry));
        songs.add(new Music("Metaphysical", "Autograf & Janelle Kroll", R.drawable.metaphysical));
        songs.add(new Music("Dreams", "Bastille & Gabrielle Aplin", R.drawable.dreams));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // list_item layout file.
        // This list item layout contains a two TextViews and an ImageView, which the adapter will fill with the data from our ArrayList
        MusicAdapter adapter = new MusicAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // your_music.xml file.
        final ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Music selectedSong = (Music) listView.getItemAtPosition(position);
                Intent i = new Intent(YourMusic.this, NowPlaying.class);
                i.putExtra(SONG_KEY, selectedSong.getsongTitle());
                i.putExtra(ARTIST_KEY, selectedSong.getartistName());
                i.putExtra(ALBUM_SRC_KEY, selectedSong.getalbumArtId());
                startActivity(i);
            }


        });
        //find the image views for the buttons
        ImageView skipBackButton = (ImageView) findViewById(R.id.small_skip_back_button);
        ImageView skipForwardButton = (ImageView) findViewById(R.id.small_skip_forward_button);
        ImageView playButton = (ImageView) findViewById(R.id.small_play_button);

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
    }
}
