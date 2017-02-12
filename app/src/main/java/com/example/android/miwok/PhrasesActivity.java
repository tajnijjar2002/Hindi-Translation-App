package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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
        words.add(new Word("How are you?", "Kida?"));
        words.add(new Word("Where are you?", "Kithe?"));
        words.add(new Word("Where are you going?", "Kidar munh chakea?"));
        words.add(new Word("Good morning", "Sat Sri Akal"));
        words.add(new Word("When are you coming?", "Kado auna?"));
        words.add(new Word("How is it made?", "Eh kida banaya?"));



//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Word currentWord = words.get(position);

                releaseMediaPlayer();

                int mediaId = currentWord.GetMediaResourceId();

                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, mediaId);
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
