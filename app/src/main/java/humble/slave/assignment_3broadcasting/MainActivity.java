package humble.slave.assignment_3broadcasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner broadCastOption;
    private ArrayList<String> broadCast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        broadCastOption = findViewById(R.id.broadcastOption);

        broadCast = new ArrayList<>();
        broadCast.add("Choose a Broadcast type");
        broadCast.add("1. Custom");
        broadCast.add("2. Wifi RTT");
        broadCast.add("3. System Battery");

        ArrayAdapter<String> broadCastList = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                broadCast
        );

        broadCastOption.setAdapter(broadCastList);

//        Toast.makeText(this, broadCastOption.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        broadCastOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, broadCast.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        implement(findViewById(R.id.btn));
    }

    private void implement(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                if(broadCastOption.getSelectedItem().toString().equals(broadCast.get(0))){
                    final Toast toast = Toast.makeText(MainActivity.this, broadCast.get(0), Toast.LENGTH_SHORT);
                    toast.show();

                    // TODO : This part is for shortening the Toast Duration (since the actual toast could not be modified) => https://stackoverflow.com/questions/3775074/set-toast-appear-length/9715422#9715422
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                } else if (broadCastOption.getSelectedItem().toString().equals(broadCast.get(1))) {
                    intent = new Intent(MainActivity.this, Custom_broadcast_2.class);
                    startActivity(intent);
                } else if (broadCastOption.getSelectedItem().toString().equals(broadCast.get(2))) {
                    intent = new Intent(MainActivity.this, Wifi_RTT_3.class);
                    startActivity(intent);
                } else {
                    intent = new Intent(MainActivity.this, Battery_broadcast_2.class);
                    startActivity(intent);
                }
            }
        });
    }
}