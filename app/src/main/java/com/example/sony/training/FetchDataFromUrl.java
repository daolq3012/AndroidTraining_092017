package com.example.sony.training;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by phong on 11/08/17.
 */

public class FetchDataFromUrl extends AsyncTask<String, Void, List<Item>> {
    private OnFetchDataListener mOnFetchDataListener;

    public FetchDataFromUrl(OnFetchDataListener onFetchDataListener) {
        mOnFetchDataListener = onFetchDataListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Item> doInBackground(String... strings) {
        try {
            String json = getJSONStringFromURL(strings[0]);
            GithubUser usersList = new Gson().fromJson(json, GithubUser.class);
            return usersList.getItems();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Item> users) {
        super.onPostExecute(users);
        Log.d("Fix now", "Fix now 1");
        mOnFetchDataListener.onFetchDataSuccess(users);
    }

    private String getJSONStringFromURL(String urlString) throws IOException, JSONException {
        HttpURLConnection urlConnection = null;
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);
        urlConnection.setDoOutput(true);
        urlConnection.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();
        String jsonString = sb.toString();
        urlConnection.disconnect();
        return jsonString;
    }
}
