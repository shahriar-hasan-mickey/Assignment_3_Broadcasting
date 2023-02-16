package humble.slave.assignment_3broadcasting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Custom_broadcast_2 extends AppCompatActivity {

    IntentFilter filter;
//    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_custom_broadcast2);


        nextIntent(findViewById(R.id.forward));

        filter = new IntentFilter("humble.slave.CUSTOM_ACTION");
    }

    private void nextIntent(Button forward) {
        EditText input = findViewById(R.id.input);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(Custom_broadcast_2.this, Custom_broadcast_3.class);
                if(input.getText().toString().equals("")){
                    Toast.makeText(Custom_broadcast_2.this, "Cannot Forward Empty Field", Toast.LENGTH_SHORT).show();
                }else{
                    Intent custom_broadcast_3 = new Intent();
                    custom_broadcast_3.setAction("humble.slave.CUSTOM_ACTION");
                    custom_broadcast_3.putExtra("humble.slave.EXTRA_TEXT", input.getText().toString());
                    sendBroadcast(custom_broadcast_3);
//                    startActivity(custom_broadcast_3);


                }
                startActivity(nextIntent);
            }
        });

    }

//    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
////            extras = getIntent().getExtras();
//            Toast.makeText(context, "made it till here"+intent.getAction().toString()+intent.getStringExtra("humble.slave.EXTRA_TEXT"), Toast.LENGTH_SHORT).show();
//        }
//    };

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        registerReceiver(broadcastReceiver, filter);
//    }
}