package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@RestController
public class DEMO1 {


    public static void main(String[] args) {
        //一个30分钟的时间段，每分钟会获取数据，一串kv形式的数据，时间+数值99，其中有几个时间没有数据，用Java stream补充，时间+数值0
        // 示例数据，其中有些时间点的数据缺失
        List<Map.Entry<Integer, Integer>> data = Arrays.asList(
                new AbstractMap.SimpleEntry<>(0, 99),
                new AbstractMap.SimpleEntry<>(1, 99),
                new AbstractMap.SimpleEntry<>(3, 99),
                new AbstractMap.SimpleEntry<>(4, 99)
        );

        // 填充缺失数据并打印结果
        IntStream.range(0, 30)
                .mapToObj(minute -> new AbstractMap.SimpleEntry<>(
                        minute,
                        data.stream()
                                .filter(entry -> entry.getKey() == minute)
                                .findFirst()
                                .map(Map.Entry::getValue)
                                .orElse(1)
                ))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
