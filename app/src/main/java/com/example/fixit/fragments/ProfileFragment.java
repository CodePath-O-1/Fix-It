package com.example.fixit.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fixit.EditProfileActivity;
import com.example.fixit.LoginActivity;
import com.example.fixit.MainActivity;
import com.example.fixit.Post;
import com.example.fixit.R;
import com.example.fixit.SignUpActivity;
import com.example.fixit.User;
import com.example.fixit.databinding.FragmentPostsBinding;
import com.example.fixit.databinding.FragmentProfileBinding;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private FragmentProfileBinding fragmentProfileBinding;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentProfileBinding = FragmentProfileBinding.bind(view);
        fragmentProfileBinding.ivEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), EditProfileActivity.class);
                startActivity(i);
            }
        });
        fragmentProfileBinding.topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
        ParseUser currentUser = ParseUser.getCurrentUser();
        User user = new User();
//        user.setEmail(currentUser.getString(user.KEY_EMAIL));
        Log.i("ProfileFragment", currentUser.getEmail());
//        user.setFirstName(currentUser.getString(user.KEY_FIRST_NAME));
//        user.setLastName(currentUser.getString(user.KEY_LAST_NAME));
//        user.setUsername(currentUser.getString(user.KEY_USERNAME));
//        user.setIsProfessional(currentUser.getBoolean(user.KEY_IS_PROFESSIONAL));
//        fragmentProfileBinding.setUser(user);
    }
}