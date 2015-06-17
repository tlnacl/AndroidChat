package com.firebase.androidchat.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.firebase.androidchat.R;
import com.firebase.androidchat.module.Room;
import com.firebase.client.Query;

/**
 * Created by tlnacl on 17/06/15.
 */
public class ChatRoomAdapter extends FirebaseListAdapter<Room> {
    /**
     * @param mRef        The Firebase location to watch for data changes. Can also be a slice of a location, using some
     *                    combination of <code>limit()</code>, <code>startAt()</code>, and <code>endAt()</code>,
     * @param mLayout     This is the mLayout used to represent a single list item. You will be responsible for populating an
     *                    instance of the corresponding view with the data from an instance of mModelClass.
     * @param activity    The activity containing the ListView
     */
    public ChatRoomAdapter(Query mRef, int mLayout, Activity activity) {
        super(mRef, Room.class, mLayout, activity);
    }

    @Override
    protected void populateView(View v, Room room) {
        TextView textView = (TextView) v.findViewById(R.id.room_name);
        textView.setText(room.getName());
    }
}
