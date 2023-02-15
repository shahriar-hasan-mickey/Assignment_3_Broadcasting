package humble.slave.assignment_3broadcasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Wifi_RTT_3 extends AppCompatActivity {

//    ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();

    private TextView wifiActionOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_wifi_rtt3);
        wifiActionOutput = findViewById(R.id.wifiActionOutput);
    }



//    private ExampleBroadcastReceiver broadcastReceiver = new ExampleBroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
////            Bundle extras = getIntent().getExtras();
////            if(extras != null){
//            TextView wifiActionOutput = findViewById(R.id.wifiActionOutput);
//            intent = getIntent();
//            String value = intent.getStringExtra("wifi_RTT_state");
//            wifiActionOutput.setText(value);
////            }
//        }
//    };



    BroadcastReceiver wifiBroadcasting = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
//            Toast.makeText(context, "Connectivity Changed", Toast.LENGTH_SHORT).show();
                boolean noConnectivity = intent.getBooleanExtra(
                        ConnectivityManager.EXTRA_NO_CONNECTIVITY, false
                );

//            Intent wifi = new Intent(context, Wifi_RTT_3.class);
//            wifi.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

//                    String state = "";

                if(noConnectivity){
                    Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
//                        state = "Disconnected";
                    wifiActionOutput.setText("Disconnected");
//                wifi.putExtra("wifi_RTT_state", "Disconnected");
                }else{
                    Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
//                        state = "Connected";
//                wifi.putExtra("wifi_RTT_state", "Connected");
                    wifiActionOutput.setText("Connected");
                }

//            context.startActivity(wifi);
            }
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

        registerReceiver(wifiBroadcasting, filter);

    }



    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiBroadcasting);
    }
}