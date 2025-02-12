package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RepoEntity.EntityName;
import com.example.demo.RepoEntity.UserBodyInfo;
import com.example.demo.RepoEntity.UserInfo;
import com.example.demo.Service.SeriveceTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // api 보내고 받는 클래스입니다 세부적인 기능구현은 서비스 클래스 가서해주세요
public class ApiTest {

    @Autowired
    SeriveceTest SeriveceTest;

    @GetMapping("/test")
    public List<EntityName> getall() {
        return SeriveceTest.getall();
    }

    @GetMapping("/user")
    public List<UserInfo> getEntities() {
        return SeriveceTest.getAllEntities();
    }

    @PostMapping("/register")
    public UserInfo registerUser(@RequestBody UserInfo userInfo) {
        return SeriveceTest.registerUser(userInfo);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserInfo userInfo) {
        boolean isAuthenticated = SeriveceTest.authenticateUser(userInfo.getUserid(), userInfo.getPassword());
        if (isAuthenticated) {
            System.out.println("로그인성공");
            return ResponseEntity.ok("Login successful");
        } else {
            System.out.println("로그인실패");

            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/recoduserbody")
    public UserBodyInfo UserBodyInfo(@RequestBody UserBodyInfo UserBodyInfo) {

        return SeriveceTest.recordeUserBodyInfo(UserBodyInfo);
    }

}
