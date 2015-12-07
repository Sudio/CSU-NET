package com.example.flim.csu_net.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.flim.csu_net.R;
import com.example.flim.csu_net.util.RSAUtil;


public class MainActivity extends Activity {
    private final static String KNOCK = "http://www.baidu.com";
    private final static String REFER = "http://61.137.86.87:8080/portalNat444/index.jsp";
    private final static String LOGIN = "http://61.137.86.87:8080/portalNat444/AccessServices/login";
    private EditText usernameEdit;

    private EditText passwordEdit;

    private CheckBox remem_password;

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        usernameEdit = (EditText)findViewById(R.id.username);
        passwordEdit = (EditText)findViewById(R.id.password);
        remem_password = (CheckBox)findViewById(R.id.is_remember);
        login = (Button)findViewById(R.id.login);
        //获取储存的账号密码
        final SharedPreferences sharedPreferences  = getSharedPreferences("data",MODE_PRIVATE);
        usernameEdit.setText(sharedPreferences.getString("account", null));
        passwordEdit.setText(sharedPreferences.getString("password",null));
        remem_password.setChecked(sharedPreferences.getBoolean("is_remember",false));
        //设置监听点击事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存账户密码
                if(remem_password.isChecked()){
                    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putString("account",usernameEdit.getText().toString());
                    editor.putString("password",passwordEdit.getText().toString());
                    editor.putBoolean("is_remember",true);
                    editor.commit();
                }

                String account = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                String accountID = account+"@zndx.inter";
                String passwordEntity = new RSAUtil().getEncrypt(password);
                Log.i("information",passwordEntity);
                Intent intent = new Intent(MainActivity.this,Logged.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
