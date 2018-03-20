package com.example.android.musicalstructureapp;

/**
 * Created by ti6a on 17-Mar-18.
 */
//Create a new Music class
public class Music {
    //Name of the song
    private String mSongTitle;
    //Name of the artist
    private String mArtistName;
    //Album art resourse ID
    private int mAlbumArtId;

    /*Create a new Music Object with 3 params
    *@param songTitle - which contains the song title
    *@param artistName - which contains the artist name
    *@param albumArtId - which contains the album art */
    public Music(String songTitle, String artistName, int albumArtId) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumArtId = albumArtId;
    }

    //Get the song title
    public String getsongTitle() {
        return mSongTitle;
    }

    //Get the Artist name
    public String getartistName() {
        return mArtistName;
    }

    //Get the Album Art ID
    public int getalbumArtId() {
        return mAlbumArtId;
    }
}
