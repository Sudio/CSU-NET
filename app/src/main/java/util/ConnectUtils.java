package util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.example.flim.csu_net.app.CSUApplication;

/**
 * Created by Flim on 2015/12/6.
 */
public class ConnectUtils {
    private static Context context;

    public static String getConnectWifiSsid(){
        context = CSUApplication.getContext();
        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        Log.d("wifiInfo",wifiInfo.toString());
        Log.d("SSID",wifiInfo.getSSID());
        return wifiInfo.getSSID();
    }
}
