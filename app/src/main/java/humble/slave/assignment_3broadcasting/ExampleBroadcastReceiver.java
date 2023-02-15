package humble.slave.assignment_3broadcasting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
//            Toast.makeText(context, "Connectivity Changed", Toast.LENGTH_SHORT).show();
            boolean noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false
            );
            if(noConnectivity){
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }
        } else if ("humble.slave.CUSTOM_ACTION".equals(intent.getAction())) {
            String receivedText = intent.getStringExtra("humble.slave.EXTRA_TEXT");
            Toast.makeText(context, receivedText, Toast.LENGTH_SHORT).show();

        }
    }
}
