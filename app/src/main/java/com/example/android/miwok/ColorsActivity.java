package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener()
    {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer)
        {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);




        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red", "Laal", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Black", "Kala", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("Brown", "Bhura", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Green", "Hara", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Pink", "Gulabi", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Orange", "Santari", R.drawable.color_gray, R.raw.color_gray));





//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {

                Word currentWord = words.get(position);

                releaseMediaPlayer();

                int mediaId = currentWord.GetMediaResourceId();

                mediaPlayer = MediaPlayer.create(ColorsActivity.this, mediaId);
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(mCompletionListener);


            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }




    private void releaseMediaPlayer()
    {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
