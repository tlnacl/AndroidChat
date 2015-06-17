package com.firebase.androidchat;

import com.firebase.client.Firebase;

/**
 * Created by tlnacl on 17/06/15.
 */
public class FireBaseHelper {
    private static final String FIREBASE_URL = "https://resplendent-heat-8281.firebaseio.com";

    private static Firebase mFirebase;

    public static Firebase getInstance() {
        if (mFirebase == null) {
            mFirebase = new Firebase(FIREBASE_URL);
        }
        return mFirebase;
    }
}
