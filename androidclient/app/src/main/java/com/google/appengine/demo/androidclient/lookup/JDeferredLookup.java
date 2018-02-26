package com.google.appengine.demo.androidclient.lookup;

import android.os.AsyncTask;
import android.widget.TextView;

import org.jdeferred.Promise;
import org.jdeferred.android.AndroidDeferredManager;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Callable;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by rayt on 2/26/18.
 */

public class JDeferredLookup {
    AndroidDeferredManager dm = new AndroidDeferredManager();

    public Promise<String, Throwable, Void> lookup(final String name) {
        return dm.when(new Callable<String>() {
            @Override
            public String call() throws Exception {
                URL url = new URL("http://kotlin-java8.appspot.com/lookup?name=" + name);
                byte[] bytes;
                try (ByteArrayOutputStream bout = new ByteArrayOutputStream();
                     InputStream in = url.openStream()) {
                    int b;
                    while ((b = in.read()) >= 0) {
                        bout.write(b);
                    }
                    bytes = bout.toByteArray();
                    return "JDeferred: " + new String(bytes, UTF_8);
                }
            }
        });
    }
}
