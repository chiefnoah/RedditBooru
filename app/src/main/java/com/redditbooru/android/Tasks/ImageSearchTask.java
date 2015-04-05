package com.redditbooru.android.Tasks;

import android.os.AsyncTask;

import com.goebl.david.Request;
import com.goebl.david.Response;
import com.google.gson.Gson;
import com.redditbooru.android.Interfaces.IRequestCallback;
import com.redditbooru.android.Util.Constants;
import com.goebl.david.Webb;
import com.redditbooru.android.Beans.OImageRequest;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peder_000 on 4/2/2015.
 */
public class ImageSearchTask extends AsyncTask<HashMap<String, String>, Void, String> {
Webb webb;
IRequestCallback callback;
    String cookie;

    public ImageSearchTask(IRequestCallback callback, String cookie) {
        //Constructor
        this.callback = callback;
        this.cookie = cookie;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        webb = Webb.create();
        webb.setBaseUri(Constants.REDDITBOORU_URL);
    }

    @Override
    protected String doInBackground(HashMap<String, String>... params) {
        HashMap<String, String> param = params[0];
        Request request = webb.get("/images/");
        request.header("Cookie", cookie);

        //Loops through the hashmap and sets them as request params
        for(Map.Entry<String, String> entry : param.entrySet()) {
            request.param(entry.getKey(), entry.getValue());
        }
        Response<JSONArray> response = request.ensureSuccess().asJsonArray();
        String json = response.getBody().toString();

        return json;
    }

    @Override
    protected void onPostExecute(String s) {

        super.onPostExecute(s);
        callback.OnJsonReceived(s);
    }
}
