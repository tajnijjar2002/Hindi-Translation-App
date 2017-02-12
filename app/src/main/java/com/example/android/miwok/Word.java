package com.example.android.miwok;

/**
 * Created by bmj on 2/5/2017.
 */

public class Word
{
    private String mPunjabiTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mMediaResourceId;

    public Word(String defaultTranslation, String punjabiTranslation)
    {
        mDefaultTranslation = defaultTranslation;
        mPunjabiTranslation = punjabiTranslation;

    }

    public Word(String defaultTranslation, String punjabiTranslation, int imageResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mPunjabiTranslation = punjabiTranslation;
        mImageResourceId = imageResourceId;
    }

    public Word(String defaultTranslation, String punjabiTranslation, int imageResourceId, int mediaResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mPunjabiTranslation = punjabiTranslation;
        mImageResourceId = imageResourceId;
        mMediaResourceId = mediaResourceId;
    }

    public String GetPunjabiTranslation()
    {
        return mPunjabiTranslation;
    }

    public String GetDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public int GetImageResourceId()
    {
        return mImageResourceId;
    }

    public int GetMediaResourceId() { return mMediaResourceId; }

    @Override
    public String toString() {
        return "Word{" +
                "mPunjabiTranslation='" + mPunjabiTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mMediaResourceId=" + mMediaResourceId +
                '}';
    }

    public boolean HasImage()
    {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
