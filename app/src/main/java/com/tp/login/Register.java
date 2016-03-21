package com.tp.login;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class Register extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper helper=new DatabaseHelper(this);
    Button reg_btn;
    EditText Name,U_name,pass,Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);


        reg_btn=(Button) findViewById(R.id.reg_btn);
        reg_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.reg_btn:
                Name=(EditText) findViewById(R.id.Name);
                U_name=(EditText) findViewById(R.id.U_name);
                pass=(EditText) findViewById(R.id.pass);
                Email=(EditText) findViewById(R.id.ET_email);


                String name=Name.getText().toString();
                String username=U_name.getText().toString();
                String password=pass.getText().toString();
                String email=Email.getText().toString();

                // Insert details in database
                Contact c= new Contact();
                c.setName(name);
                c.setUname(username);
                c.setEmail(email);
                c.setPass(password);
                helper.insertContact(c);
                break;
        }
    }
}
