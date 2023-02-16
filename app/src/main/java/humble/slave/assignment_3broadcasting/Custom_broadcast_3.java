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

//    ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();

    IntentFilter filter;

    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_custom_broadcast3);

//        IntentFilter filter = new IntentFilter("humble.slave.CUSTOM_ACTION");
//        registerReceiver(exampleBroadcastReceiver, filter);
        output = findViewById(R.id.output);

        filter = new IntentFilter("humble.slave.CUSTOM_ACTION");


    }


    ExampleBroadcastReceiver broadcastReceiver = new ExampleBroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            extras = getIntent().getExtras();
            Toast.makeText(context, "made it till here"+intent.getAction().toString()+intent.getStringExtra("humble.slave.EXTRA_TEXT"), Toast.LENGTH_SHORT).show();
            output.setText(intent.getStringExtra("humble.slave.EXTRA_TEXT"));
        }
    };

    @Override
    protected void onStart() {
        super.onStart();

//        registerReceiver(broadcastReceiver, filter);
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, filter);
        Toast.makeText(this, "here", Toast.LENGTH_SHORT).show();
    }



}