package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Difficulty {
    @Id
    @GeneratedValue
    @Column(name="difficulty_id")
    private long difficultyID;

    private String difficulty;

    @OneToMany (mappedBy = "difficulty")
    @JsonManagedReference
    @Column(name="difficulty_list")
    private List<Product> difficultyList;

    public Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty() {}

    public long getDifficultyID() {
        return difficultyID;
    }

    public void setDifficultyID(long difficultyID) {
        this.difficultyID = difficultyID;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setdifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<Product> getDifficultyList() {
        return difficultyList;
    }

    public void setDifficultyList(List<Product> difficultyList) {
        this.difficultyList = difficultyList;
    }
}
