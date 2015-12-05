package task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.flim.csu_net.MainActivity;
import com.example.flim.csu_net.R;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

import org.asynchttpclient.AsyncHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.AsyncHttpProvider;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;
import org.asynchttpclient.SignatureCalculator;


/**
 * Created by Flim on 2015/9/19.
 */
public class LoginTask extends AsyncTask<String, Integer, Void>{
    private final static String KNOCK = "http://baidu.com";
    private final static String REFER = "http://61.137.86.87:8080/portalNat444/index.jsp";
    private final static String LOGIN = "http://61.137.86.87:8080/portalNat444/AccessServices/login";

    private String password;
    private String account;
    private String brasAddress;
    private String userIntranetAddress;
    private String result;

//    private AsyncHttpClient asyncHttpClient;

    private Context context;
    private boolean remember;
    private SharedPreferences preferences;

    private CircleProgressBar progressBar;

    public LoginTask(Context context,boolean remember){
        this.context = context;
        progressBar = (CircleProgressBar)((MainActivity)context).findViewById(R.id.loginProgress);
        this.remember = remember;
    }

    @Override
    protected Void doInBackground(String... params) {
        return null;
    }
}