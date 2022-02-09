package com.abhishekchoksi.loginapplicationwithfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {
    String user = "";
    String pass = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        EditText textUserName = view.findViewById(R.id.textUserName);
        EditText textPassword = view.findViewById(R.id.textPassword);
        Button btnLog = view.findViewById(R.id.btnLog);

        getParentFragmentManager().setFragmentResultListener("dataframerg", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                user = result.getString("USERNAME");
                pass = result.getString("USERPASSWORD");
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = textUserName.getText().toString();
                String Password = textPassword.getText().toString();
                if(Username.equals(user) && Password.equals(pass)){
                    Toast.makeText(view.getContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(view.getContext(), "Invalid User Name And Password!!", Toast.LENGTH_SHORT).show();
                }
                textUserName.setText("");
                textPassword.setText("");
            }
        });
        return view;
    }
}