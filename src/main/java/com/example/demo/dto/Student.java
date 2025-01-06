package com.example.demo.dto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    private final String name;
    // Getter 方法
    @Getter
    private int chineseScore;
    @Getter
    private int mathScore;
    @Getter
    private int englishScore;

    public Student(String name, int chineseScore, int mathScore, int englishScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    // 为了方便打印，重写 toString 方法
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chineseScore=" + chineseScore +
                ", mathScore=" + mathScore +
                ", englishScore=" + englishScore +
                '}';
    }
}
