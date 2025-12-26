package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;

public interface UserService {

    Object register(RegisterRequest request);

    Object login(AuthRequest request);

    Object getByEmail(String email);
}










// package com.example.demo.service;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.User;

// public interface UserService {

//     User register(RegisterRequest request);

//     AuthResponse login(AuthRequest request);

//     User getByEmail(String email);   //  THIS MUST BE IMPLEMENTED
// }
