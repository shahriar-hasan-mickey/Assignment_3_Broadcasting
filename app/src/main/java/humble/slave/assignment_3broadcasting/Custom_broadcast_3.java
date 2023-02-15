package humble.slave.assignment_3broadcasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class Custom_broadcast_3 extends AppCompatActivity {

    ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_custom_broadcast3);

        IntentFilter filter = new IntentFilter("humble.slave.CUSTOM_ACTION");
        registerReceiver(exampleBroadcastReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(exampleBroadcastReceiver);
    }
}