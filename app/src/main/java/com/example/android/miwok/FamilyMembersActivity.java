package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

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
        words.add(new Word("Father", "Peyo", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Mother", "Maa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Sister", "Bhen", R.drawable.family_younger_sister, R.raw.family_older_sister));
        words.add(new Word("Brother", "Bhra", R.drawable.family_younger_brother, R.raw.family_older_brother));
        words.add(new Word("Uncle", "Chacha", R.drawable.family_older_brother, R.raw.family_younger_brother));
        words.add(new Word("Aunty", "Chachi", R.drawable.family_older_sister, R.raw.family_younger_sister));



//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Word currentWord = words.get(position);
//                Word currentWord = adapter.getItem(position);

                releaseMediaPlayer();

                int mediaId = currentWord.GetMediaResourceId();

                mediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, mediaId);
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
