package com.tp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper helper;
    Button login_btn;
    EditText Username;
    EditText password;
    TextView Register_link;
    //UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn=(Button) findViewById(R.id.login_btn);
        Register_link=(TextView)findViewById(R.id.Register_link);

        login_btn.setOnClickListener(this);
        Register_link.setOnClickListener(this);
       // userLocalStore=new UserLocalStore(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.login_btn:
                Username=(EditText) findViewById(R.id.Username);
                password=(EditText) findViewById(R.id.password);

                String uname=Username.getText().toString();
                String pass=password.getText().toString();

                String password=helper.searchpass(pass);
                if(pass.equals(password))
                {
                    Intent intent=new Intent(this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast pwd=Toast.makeText(Login.this, "Username or Password don't match",Toast.LENGTH_SHORT);
                    pwd.show();
                }
                break;
            case R.id.Register_link:
                Intent intent=new Intent(this,Register.class);
                startActivity(intent);



                break;
        }
    }
}
