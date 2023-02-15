package humble.slave.assignment_3broadcasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class Custom_broadcast_3 extends AppCompatActivity {

    ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_custom_broadcast3);

//        IntentFilter filter = new IntentFilter("humble.slave.CUSTOM_ACTION");
//        registerReceiver(exampleBroadcastReceiver, filter);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView output = findViewById(R.id.output);
            output.setText(intent.getStringExtra("humble.slave.EXTRA_TEXT"));
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("humble.slave.CUSTOM_ACTION");
        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    //    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(exampleBroadcastReceiver);
//    }
}