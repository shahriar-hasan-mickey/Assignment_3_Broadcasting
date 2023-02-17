package humble.slave.assignment_3broadcasting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;



public class Custom_broadcast_3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_custom_broadcast3);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Bundle extra = getIntent().getExtras();
        Intent broadcasting = new Intent("humble.slave.CUSTOM_ACTION");
        broadcasting.putExtra("humble.slave.EXTRA_TEXT", extra.getString("humble.slave.EXTRA_TEXT"));
        sendBroadcast(broadcasting);
        finish();
    }



}