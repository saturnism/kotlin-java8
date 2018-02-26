package com.google.appengine.demo.androidclient.lookup;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by rayt on 2/26/18.
 */

public class AsyncTaskLookup extends AsyncTask<String, Void, String> {
    private final TextView resultView;

    public AsyncTaskLookup(TextView resultView) {
        this.resultView = resultView;
    }

    @Override
    protected void onPreExecute() {
        resultView.setText("");
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL("http://kotlin-java8.appspot.com/lookup?name=" + strings[0]);
            byte[] bytes;
            try (ByteArrayOutputStream bout = new ByteArrayOutputStream();
                 InputStream in = url.openStream()) {
                int b;
                while ((b = in.read()) >= 0) {
                    bout.write(b);
                }
                bytes = bout.toByteArray();
            }
            return "Java: " + new String(bytes, UTF_8);
        } catch (Exception e) {
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        resultView.setText(s);
    }
}
