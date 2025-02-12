package com.example.demo.RepoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUserBodyInfo extends JpaRepository<UserBodyInfo, Long> {
    // 디비랑 연결되는거 여기에 자체적인 쿼리문 작성가능해요
}
