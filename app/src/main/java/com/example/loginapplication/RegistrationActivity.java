package com.example.loginapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mPasswordEditText;
    private EditText mDobEditText;
    private EditText mCountryEditText;
    private EditText mPhoneEditText;
    private EditText mAddressEditText;
    private EditText mEmailEditText;
    private RadioGroup mGenderRadioGroup;
    private Button mRegisterButton;

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mNameEditText = findViewById(R.id.name_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);
        mDobEditText = findViewById(R.id.dob_edit_text);
        mCountryEditText = findViewById(R.id.country_edit_text);
        mPhoneEditText = findViewById(R.id.phone_edit_text);
        mAddressEditText = findViewById(R.id.address_edit_text);
        mEmailEditText = findViewById(R.id.email_edit_text);
        mGenderRadioGroup = findViewById(R.id.gender_radio_group);
        mRegisterButton = findViewById(R.id.register_button);

        mSharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                String dob = mDobEditText.getText().toString();
                String country = mCountryEditText.getText().toString();
                String phone = mPhoneEditText.getText().toString();
                String address = mAddressEditText.getText().toString();
                String email = mEmailEditText.getText().toString();
                String gender = mGenderRadioGroup.getCheckedRadioButtonId() == R.id.male_radio_button ? "Male" : "Female";

                saveUser(name, password, dob, country, phone, address, email, gender);

                Toast.makeText(RegistrationActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void saveUser(String name, String password, String dob, String country, String phone, String address, String email, String gender) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(name, password);
        editor.apply();
    }
}
