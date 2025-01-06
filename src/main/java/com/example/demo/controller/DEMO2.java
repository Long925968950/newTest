package com.example.demo.controller;

import com.example.demo.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class DEMO2 {

    @GetMapping("Hello")
    public String hello() {
        return "Hello World";
    }


    public static void main(String[] args) {

        //统计数据，有某学生成绩的数据结构，如何获得满足语数外三科都大于60的平均分、最高分和最低分数据
        List<Student> students = new ArrayList<>(); //获取学生列表
        Random random = new Random();
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Heidi", "Ivan", "Judy",
                "Ken", "Linda", "Mike", "Nina", "Oscar", "Paul", "Queen", "Robert", "Susan", "Tom",
                "Una", "Victor", "Wendy", "Xavier", "Yvonne", "Zebra", "Albert", "Betty", "Charlie", "Diana",
                "Edward", "Fiona", "George", "Hannah", "Ian", "Jackie", "Karen", "Larry", "Mandy", "Nelson",
                "Olivia", "Pauline", "Quincy", "Ralph", "Sophia", "Ted", "Ursula", "Vincent", "William", "Xenia"};

        // 生成50个学生数据
        for (int i = 0; i < 50; i++) {
            // 使用随机数生成器生成成绩（60-100之间）
            int chineseScore = random.nextInt(101);
            int mathScore = random.nextInt(101);
            int englishScore = random.nextInt(101);

            // 使用姓名数组中的姓名（如果姓名数组长度不够50个，可以循环使用或添加更多姓名）
            String name = names[i % names.length];

            // 创建学生对象并添加到列表中
            students.add(new Student(name, chineseScore, mathScore, englishScore));
        }

        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getChineseScore() > 60
                        && student.getMathScore() > 60
                        && student.getEnglishScore() > 60)
                .collect(Collectors.toList());

        System.out.println("高于平均分: " + filteredStudents);

        if (!filteredStudents.isEmpty()) {
            double averageScore = filteredStudents.stream()
                    .mapToInt(student -> (student.getChineseScore() + student.getMathScore() + student.getEnglishScore()) / 3)
                    .average()
                    .orElse(Double.NaN); // 如果没有学生满足条件，则返回NaN

            int maxScore = filteredStudents.stream()
                    .mapToInt(student -> Math.max(student.getChineseScore(), Math.max(student.getMathScore(), student.getEnglishScore())))
                    .max()
                    .orElse(Integer.MIN_VALUE); // 如果没有学生满足条件，则返回Integer.MIN_VALUE

            int minScore = filteredStudents.stream()
                    .mapToInt(student -> Math.min(student.getChineseScore(), Math.min(student.getMathScore(), student.getEnglishScore())))
                    .min()
                    .orElse(Integer.MAX_VALUE); // 如果没有学生满足条件，则返回Integer.MAX_VALUE

            // 输出或使用这些计算结果
            System.out.println("平均分: " + averageScore);
            System.out.println("最高分: " + maxScore);
            System.out.println("最低分: " + minScore);
        } else {
            System.out.println("没有学生满足条件。");
        }

    }

}
