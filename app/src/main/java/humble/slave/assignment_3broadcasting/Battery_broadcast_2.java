package humble.slave.assignment_3broadcasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Battery_broadcast_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_battery_broadcast2);

        nextIntent(findViewById(R.id.forward));
    }

    private void nextIntent(Button forward) {
        EditText input = findViewById(R.id.input);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TODO : In this part to simply get the numeric keypad we need to make the type tobe number : https://stackoverflow.com/questions/1119583/how-do-i-show-the-number-keyboard-on-an-edittext-in-android
                if(Integer.parseInt(input.getText().toString()) < 100 && Integer.parseInt(input.getText().toString()) > 0){
                    Intent nextIntent = new Intent(Battery_broadcast_2.this, Battery_broadcast_3.class);
                    startActivity(nextIntent);
                }else{
                    Toast.makeText(Battery_broadcast_2.this, "Please insert a amount from 0-100", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}