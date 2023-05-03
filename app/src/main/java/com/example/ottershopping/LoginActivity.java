package com.example.ottershopping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ottershopping.databinding.ActivityLoginBinding;

import java.util.List;


public class LoginActivity extends AppCompatActivity {
    OtterDao otterDao;
    Button loginButton;
    EditText username;
    EditText password;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        List<User> db = otterDao.getUsers();
        if(db == null)
        {
            appInitialization();
        }
        loginButton = binding.Lbutton;
        username = binding.username;
        password = binding.password;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(verify() != null){
                    User user = verify();

                       if(user.isAdmin()){
                           Intent intent = AdminLandingActivity.getIntent(getApplicationContext());
                       startActivity(intent);
                       setContentView(R.layout.activity_admin_landing_page);
                   }
                       else{
                           Intent intent = LandingActivity.getIntent(getApplicationContext());
                           startActivity(intent);
                           setContentView(R.layout.activity_landing_page);
                       }
               }
            }
        });
    }
    private User verify() {
        User use = otterDao.getUserByUsername(username.getText().toString());
        if(use == null){
            Context context = getApplicationContext();
            CharSequence text = "Username does not exist";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
            username.setText("");
            password.setText("");
            return null;
        }
        if (!use.getPassword().equals(password.getText().toString())) {
            Context context = getApplicationContext();
            CharSequence text = "Incorrect Password";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
            return null;
        }
        return use;
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }
    private void appInitialization() {
        User admin2 = new User("admin2","admin2");
        User testuser1	 = new User("testuser1	","testuser1");
        otterDao.insert(testuser1);
        otterDao.insert(admin2);
    }
}
