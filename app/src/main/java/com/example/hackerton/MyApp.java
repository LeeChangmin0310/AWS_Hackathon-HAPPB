package com.example.hackerton;

import android.app.Application;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;

public class MyApp extends Application {

    String tag = "xxx";
    @Override
    public void onCreate() {
        super.onCreate();
        //xxx
        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(getApplicationContext());
            Log.i(tag, "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e(tag, "Could not initialize Amplify", error);
        }
    }
}
