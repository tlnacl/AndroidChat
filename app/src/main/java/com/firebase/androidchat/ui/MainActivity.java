package com.firebase.androidchat.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.androidchat.FireBaseHelper;
import com.firebase.androidchat.R;
import com.firebase.androidchat.adapter.ChatRoomAdapter;
import com.firebase.androidchat.module.Room;
import com.firebase.client.Firebase;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends Activity {

    @InjectView(R.id.list)
    ListView mList;

    private ChatRoomAdapter mRoomAdapter;
    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mFirebaseRef = FireBaseHelper.getInstance().child("room");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mRoomAdapter = new ChatRoomAdapter(mFirebaseRef,R.layout.item_room,this);
        mList.setAdapter(mRoomAdapter);
    }

    @OnClick(R.id.add_room_button)
    public void onAddRoomClick() {
        final EditText inputText = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("Add Chat Room")
                .setView(inputText)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String input = inputText.getText().toString();
                        if (!input.equals("")) {
                            // Create our 'model', a Chat object
                            Room room = new Room(input);
                            // Create a new, auto-generated child of that chat location, and save our chat data there
                            mFirebaseRef.push().setValue(room);
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Canceled
                    }
                }).show();
    }

    @OnItemClick(R.id.list)
    void onItemClick(int position) {
        Room room = (Room) mRoomAdapter.getItem(position);
        startActivity(new Intent(this,ChatRoomActivity.class).putExtra(ChatRoomActivity.EXTRA_ROOM_NAME,room.getName()));
    }

}
