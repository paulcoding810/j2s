import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.Toast;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String ip = NetworkUtils.getLocalIpAddress(this);
        Toast.makeText(this, ip, Toast.LENGTH_LONG).show();
    }
}

class NetworkUtils {
    public static String getLocalIpAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        int ipInt = wifiManager.getConnectionInfo().getIpAddress();
        return Formatter.formatIpAddress(ipInt);
    }
}