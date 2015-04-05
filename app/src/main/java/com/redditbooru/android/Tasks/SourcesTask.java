package com.redditbooru.android.Tasks;

import android.os.AsyncTask;

import com.goebl.david.Webb;
import com.redditbooru.android.Interfaces.IRequestCallback;
import com.redditbooru.android.Util.Constants;

/**
 * Created by peder_000 on 4/4/2015.
 */
public class SourcesTask extends AsyncTask<Void, Void, String>{

    IRequestCallback callback;
    Webb webb;

    public SourcesTask(IRequestCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        webb = Webb.create();
        webb.setBaseUri(Constants.REDDITBOORU_URL);
    }

    @Override
    protected String doInBackground(Void... params) {
        //TODO: Get sources
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        callback.OnJsonReceived(s);
    }
}
