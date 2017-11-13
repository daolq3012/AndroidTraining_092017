package com.example.sony.training;

import android.os.AsyncTask;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.json.JSONException;

/**
 * Created by Admin on 11/08/17.
 */

//Chuyen JSON thanh Object
public class FetchDataFromUrl extends AsyncTask<String,Void,List<Item>> {

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
        String json = null;
        try {
            json = getJSONStringFromUrl(strings[0]);
            GithubUser userList = new Gson().fromJson(json,GithubUser.class);
            return userList.getItems();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Item> items) {
        super.onPostExecute(items);
        mOnFetchDataListener.onFetchDataSuccess(items);
    }

    //Retrofit se ho tro phan nay
    private String getJSONStringFromUrl(String urlString) throws IOException,JSONException {
        HttpURLConnection urlConnection = null;
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000);
        urlConnection.setConnectTimeout(15000);
        urlConnection.setDoOutput(true);
        urlConnection.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();
        String jsonString = sb.toString();
        urlConnection.disconnect();
        return jsonString;
    }
}
