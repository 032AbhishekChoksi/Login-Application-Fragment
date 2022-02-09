package com.abhishekchoksi.loginapplicationwithfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view =  inflater.inflate(R.layout.fragment_registration, container, false);

        EditText txtName = view.findViewById(R.id.txtName);
        EditText txtUserName = view.findViewById(R.id.txtUserName);
        EditText txtPassword = view.findViewById(R.id.txtPassword);
        EditText txtContact = view.findViewById(R.id.txtContact);
        EditText txtEmail = view.findViewById(R.id.txtEmail);
        Button btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = txtUserName.getText().toString();
                String ps = txtPassword.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("USERNAME",us);
                bundle.putString("USERPASSWORD",ps);
                getParentFragmentManager().setFragmentResult("dataframerg",bundle);
                txtName.setText("");
                txtUserName.setText("");
                txtPassword.setText("");
                txtContact.setText("");
                txtEmail.setText("");
            }
        });
        return  view;
    }
}