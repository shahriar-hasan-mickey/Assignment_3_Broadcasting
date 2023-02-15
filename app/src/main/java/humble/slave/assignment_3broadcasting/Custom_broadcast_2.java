package humble.slave.assignment_3broadcasting;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_custom_broadcast2);


        nextIntent(findViewById(R.id.forward));
    }

    private void nextIntent(Button forward) {
        EditText input = findViewById(R.id.input);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("")){
                    Toast.makeText(Custom_broadcast_2.this, "Cannot Forward Empty Field", Toast.LENGTH_SHORT).show();
                }else{
                    Intent custom_broadcast_3 = new Intent(Custom_broadcast_2.this, Custom_broadcast_3.class);
//                    custom_broadcast_3.setAction("");
                    custom_broadcast_3.putExtra("humble.slave.EXTRA_TEXT", input.getText());
                    sendBroadcast(custom_broadcast_3);
                    startActivity(custom_broadcast_3);
                }
            }
        });

    }


}