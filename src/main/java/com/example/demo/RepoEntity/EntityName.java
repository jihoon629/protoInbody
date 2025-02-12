package com.example.demo.RepoEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity // 테스트용 엔티티에요 무시
public class EntityName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
