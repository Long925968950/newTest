package com.example.demo.controller;

import com.example.demo.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class HelloWord {

    @GetMapping("Hello")
    public String hello() {
        return "Hello World";
    }


    public static void main(String[] args) {
//        // 示例数据，其中有些时间点的数据缺失
//        List<Map.Entry<Integer, Integer>> data = Arrays.asList(
//                new AbstractMap.SimpleEntry<>(0, 99),
//                new AbstractMap.SimpleEntry<>(1, 99),
//                new AbstractMap.SimpleEntry<>(3, 99),
//                new AbstractMap.SimpleEntry<>(4, 99)
//        );
//
//        // 填充缺失数据并打印结果
//        IntStream.range(0, 30)
//                .mapToObj(minute -> new AbstractMap.SimpleEntry<>(
//                        minute,
//                        data.stream()
//                                .filter(entry -> entry.getKey() == minute)
//                                .findFirst()
//                                .map(Map.Entry::getValue)
//                                .orElse(1)
//                ))
//                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


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
