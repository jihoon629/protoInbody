package com.example.demo.RepoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoTest extends JpaRepository<EntityName, Long> {
    // 테스트용 레포에요 무시
}
