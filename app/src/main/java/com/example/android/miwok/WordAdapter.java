package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bmj on 2/5/2017.
 */

public class WordAdapter extends ArrayAdapter<Word>
{
    private int mBackgroundColor;
    public WordAdapter(Context context, ArrayList<Word> words, int backgroundColor)
    {
        super(context, 0, words);
        mBackgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Word currentWord = getItem(position);


        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.englishTextView);
        defaultTextView.setText(currentWord.GetDefaultTranslation());

        TextView punjabiTextView = (TextView) listItemView.findViewById(R.id.punjabiTextView);
        punjabiTextView.setText(currentWord.GetPunjabiTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);


        if(currentWord.HasImage())
        {
            imageView.setImageResource(currentWord.GetImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.right_panel_listItem);
        //This is done to convert the colorResource name into hexadecimal number
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        textContainer.setBackgroundColor(color);



        return listItemView;
    }


}
