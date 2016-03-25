/**********
 * author: Tanvi@
 * description: Login Activity
 **********/
package com.tp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper helper=new DatabaseHelper(this);
    Button login_btn;
    EditText UserName;
    EditText Password;
    TextView Register_link;
    //UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn=(Button) findViewById(R.id.login_btn);
        Register_link=(TextView)findViewById(R.id.Register_link);

        login_btn.setOnClickListener(this);
        Register_link.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.login_btn) {

            UserName = (EditText) findViewById(R.id.ET_Username);
            Password = (EditText) findViewById(R.id.ET_password);

            String uname = UserName.getText().toString();
            String pass = Password.getText().toString();

            String pwd = helper.searchpass(uname);
            if (pass.equals(pwd))
            {
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
            else
            {
                Toast pwd1 = Toast.makeText(Login.this, "Username or Password don't match", Toast.LENGTH_SHORT);
                pwd1.show();
            }
        }

            if(v.getId()== R.id.Register_link)
            {
                Intent intent=new Intent(this,Register.class);
                startActivity(intent);
            }
    }
}
