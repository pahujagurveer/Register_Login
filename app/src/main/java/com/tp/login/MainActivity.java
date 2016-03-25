/**********
 * author: Tanvi@
 * description: The application opens a logged in activity with logout button.
 **********/
package com.tp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button logout_btn;
    EditText Name,U_name;
   // UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText) findViewById(R.id.Name);
        U_name=(EditText) findViewById(R.id.U_name);
        logout_btn=(Button) findViewById(R.id.logout_btn);

        logout_btn.setOnClickListener(this);
        //userLocalStore=new UserLocalStore(this);

    }



    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.logout_btn:
                //userLocalStore.ClearUserData();
                //userLocalStore.setUserLoggedIn(false);
                Intent intent=new Intent(this,Login.class);
                startActivity(intent);
                break;


        }
    }
}
