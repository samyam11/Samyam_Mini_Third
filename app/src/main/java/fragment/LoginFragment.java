package fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ushan_mini_third.AfterLoginActivity;
import com.example.ushan_mini_third.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText etUsername, etPassword;
    Button btnLogin;





    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        btnLogin = view.findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });




        return view;
    }
    private void Login(){

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("User", Context.MODE_PRIVATE);
        String Username =sharedPreferences.getString("username","");
        String Password =sharedPreferences.getString("password","");

        if(Username.equals(etUsername.getText().toString()) && Password.equals(etPassword.getText().toString())){
            Intent intent = new Intent(getContext(), AfterLoginActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getContext(),"Incorrect Credentials.",Toast.LENGTH_LONG).show();

        }
    }

}
