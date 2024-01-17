package com.example.videocallingapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class AdminActivity extends AppCompatActivity {
    private TextView tvManagePatient,tvManageDoctor,tvVideoCall,tvCallSms,tvChatMessage,tvUsers,tvSendNotify;
    private static int SIGN_IN_REQUEST_CODE = 1;
    ConstraintLayout activity_admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        //action bar and its title
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Admin Management");
        //Enable back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        activity_admin = (ConstraintLayout) findViewById(R.id.activity_admin);
        tvManagePatient=(TextView)findViewById(R.id.tvManagePatient);
        tvManageDoctor=(TextView)findViewById(R.id.tvManageDoctor);
        tvSendNotify=(TextView)findViewById(R.id.tvSendNotify);
        tvSendNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this,SendnotificationActivity.class));
            }
        });
        tvVideoCall=(TextView)findViewById(R.id.tvVideoCall);
        tvVideoCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this,MainActivity.class));
            }
        });
        tvCallSms=(TextView)findViewById(R.id.tvCallSms);

        tvChatMessage=(TextView)findViewById(R.id.tvChatMessage);

        tvChatMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this,ChatmessageActivity.class));
            }
        });
        tvUsers=(TextView)findViewById(R.id.tvUsers);

        tvUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(AdminActivity.this,UsersActivity.class));
                startActivity(new Intent(AdminActivity.this,ShowusersActivity.class));
            }
        });
        tvManagePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (AdminActivity.this,ManagepatientActivity.class));
            }
        });
        tvManageDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this,ManagedoctorActivity.class));
            }
        });
        tvCallSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this,SendsmsActivity.class));
            }
        });
        /*
        //Another simpler way of sign in and registration without creating registration and login activities
        //--checking whether signed in or not at the start of the admin activity
        //check if not signed in then navigate Sign in page
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_REQUEST_CODE);
        }
        else
        {
            Snackbar.make(activity_admin, "Welcome" + FirebaseAuth.getInstance().getCurrentUser().getEmail(), Snackbar.LENGTH_LONG).show();
        }
        // signed in checking finish
        */
    }
    //for three dot menu------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_profile) {
            //startActivity(new Intent(AdminActivity.this,FragmentProfileActivity.class));
            startActivity(new Intent(AdminActivity.this,ShowuserprofileActivity.class));
        }
        if (item.getItemId() == R.id.menu_sign_out) {
            FirebaseAuth.getInstance().signOut();
            Snackbar.make(activity_admin, "You have been signed out!", Snackbar.LENGTH_LONG).show();
            finish();
            startActivity(new Intent(AdminActivity.this,StartActivity.class));

        }
        if (item.getItemId() == R.id.menu_patient) {
            startActivity(new Intent(AdminActivity.this,ManagepatientActivity.class));
        }
        if (item.getItemId() == R.id.menu_doctor) {
            startActivity(new Intent(AdminActivity.this,ManagedoctorActivity.class));
        }
        if (item.getItemId() == R.id.menu_video) {
            startActivity(new Intent(AdminActivity.this,MainActivity.class));
        }
        if (item.getItemId() == R.id.menu_callsms) {
            startActivity(new Intent(AdminActivity.this,SendsmsActivity.class));
        }
        if (item.getItemId() == R.id.menu_chat) {
            //startActivity(new Intent(AdminActivity.this,ChatroomActivity.class));
            startActivity(new Intent(AdminActivity.this,ChatmessageActivity.class));
        }
        return true;
    }
    //end for three dot menu------------------------------
}