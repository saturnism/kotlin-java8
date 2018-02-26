package com.google.appengine.demo.androidclient;

import static android.view.inputmethod.EditorInfo.IME_ACTION_DONE;
import static android.view.inputmethod.EditorInfo.IME_ACTION_UNSPECIFIED;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.appengine.demo.androidclient.lookup.AsyncTaskLookup;
import com.google.appengine.demo.androidclient.lookup.JDeferredLookup;

import org.jdeferred.Promise;

public class JavaHelloWorldActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        EditText nameInput = (EditText) findViewById(R.id.nameInput);
        nameInput.setText("Java Hello World");

        nameInput.setOnEditorActionListener(
                (textView, actionId, keyEvent) -> {
                    if (actionId == IME_ACTION_DONE || actionId == IME_ACTION_UNSPECIFIED) {
                        //this.callAsyncTaskLookup(textView);
                        this.callJDeferredTaskLookup(textView.getText().toString());
                        return true;
                    } else {
                        return false;
                    }
                });
    }

    public void callAsyncTaskLookup(String name) {
        AsyncTaskLookup asyncTaskLookup = new AsyncTaskLookup((TextView) findViewById(R.id.resultView));
        asyncTaskLookup.execute(name);
    }

    public void callJDeferredTaskLookup(String name) {
        JDeferredLookup lookup = new JDeferredLookup();
        Promise<String, Throwable, Void> promise = lookup.lookup(name);
        promise.done((result) -> {
            TextView resultView = (TextView) findViewById(R.id.resultView);
            resultView.setText(result);
        }).fail((t) -> {
            Log.e("HELLO", "failed to call lookup", t);
        });
    }
}
