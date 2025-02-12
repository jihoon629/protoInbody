package com.example.demo.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.RepoEntity.EntityName;
import com.example.demo.RepoEntity.RepoTest;
import com.example.demo.RepoEntity.RepoUserBodyInfo;
import com.example.demo.RepoEntity.RepoUserInfo;
import com.example.demo.RepoEntity.UserBodyInfo;
import com.example.demo.RepoEntity.UserInfo;

@Service // 여기는 실질적인 기능을 구현하는 부분입니다 필요시 새 클래스 파서 서비스 생성가능
public class SeriveceTest {
    @Autowired
    private RepoTest RepoTest;

    @Autowired
    private RepoUserInfo RepoUserInfo;

    @Autowired
    private RepoUserBodyInfo RepoUserBodyInfo;

    public List<EntityName> getall() {
        return RepoTest.findAll();
    }

    public List<UserInfo> getAllEntities() {
        return RepoUserInfo.findAll();
    }

    public UserInfo registerUser(UserInfo userInfo) {
        return RepoUserInfo.save(userInfo);
    }

    public UserBodyInfo recordeUserBodyInfo(UserBodyInfo UserBodyInfo) {
        double fatMass = UserBodyInfo.getWeight() * (UserBodyInfo.getFatpercentage() / 100);

        UserBodyInfo.setFatMass(Math.round(fatMass * 100.0) / 100.0);

        double inbodyScore = 1557;
        UserBodyInfo.setInbodyScore(inbodyScore);

        UserBodyInfo.setDate(new Date());

        return RepoUserBodyInfo.save(UserBodyInfo);
    }

    public boolean authenticateUser(String userid, String password) {
        UserInfo user = RepoUserInfo.findByUserid(userid);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
