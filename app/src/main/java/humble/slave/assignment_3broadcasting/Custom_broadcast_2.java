package humble.slave.assignment_3broadcasting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class Custom_broadcast_2 extends AppCompatActivity {

    IntentFilter filter;
//    Bundle extras;
    TextView output;

    EditText input;
//    public Intent nextIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_custom_broadcast2);


        nextIntent(findViewById(R.id.forward));

        filter = new IntentFilter("humble.slave.CUSTOM_ACTION");

        output = findViewById(R.id.output);

        input = findViewById(R.id.input);

    }

    private void nextIntent(Button forward) {

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              TODO : Hiding the keyboard on clicking the button by setting the flag to 0  : https://stackoverflow.com/questions/13593069/androidhide-keyboard-after-button-click
                InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);


                if(input.getText().toString().equals("")){
                    Toast.makeText(Custom_broadcast_2.this, "Cannot Forward Empty Field", Toast.LENGTH_SHORT).show();
                }else{
                    Intent custom_broadcast_3 = new Intent(Custom_broadcast_2.this, Custom_broadcast_3.class);

                    custom_broadcast_3.putExtra("humble.slave.EXTRA_TEXT", input.getText().toString());
                    startActivity(custom_broadcast_3);
                }

//                TODO : Hiding the visibility of the editText and Button on finishing the 3rd Activity : https://stackoverflow.com/questions/36078795/android-text-view-and-edit-text-visible-on-button-click
//                TODO : https://stackoverflow.com/questions/7222380/how-can-i-remove-a-button-in-its-own-onclick-method
                v.setVisibility(View.GONE);
                input.setVisibility(View.GONE);


            }
        });

    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, intent.getStringExtra("humble.slave.EXTRA_TEXT"), Toast.LENGTH_SHORT).show();
            output.setText(intent.getStringExtra("humble.slave.EXTRA_TEXT"));
        }
    };


//    TODO : onResume() because we are returning back to the second activity after sending the broadcast from the 3rd activity
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, filter);
    }
}