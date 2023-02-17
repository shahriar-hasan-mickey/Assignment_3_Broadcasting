package humble.slave.assignment_3broadcasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class Battery_broadcast_3 extends AppCompatActivity {


    private TextView output1, output2;
    private String battery;
    private BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

//            TODO : for receiving battery broadcast information : https://stackoverflow.com/questions/14405726/get-battery-level-with-broadcastreceiver-in-android-service
            int level = intent.getIntExtra("level", 0);
            battery = String.valueOf(level) + "%";
            output2.setText("Battery percentage : "+battery);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        TODO : for changing the actionbar title
        getSupportActionBar().setTitle("Battery-Broadcast");

//        TODO : for changing the actionbar color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff6600")));
        setContentView(R.layout.activity_battery_broadcast3);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);

        Bundle extra = getIntent().getExtras();
        output1.setText("User input : "+extra.getString("percentage")+ "%");

        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }


//    TODO : for vertical orientation use the orientation attribute in the linearLayout : https://developer.android.com/develop/ui/views/layout/linear
}