package com.coding.core;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: dengKai
 * @date: 2022/05/23 20:00
 * @description: read file and covert it to BlockingQueue
 */
@Data
@Accessors(chain = true)
public class IFileReader {
    private static final String FILE_NAME = "src/main/resources/query.txt";
    private static final Integer BLOCKING_QUEUE_CAPACITY = 10000;
    private static int numbersOfQuery = 0;

    public BlockingQueue<String> readFileToBlockingQueue() throws Exception {
        StringBuilder stringBuilder = convertFileToStringBuilder();
        BlockingQueue<String> queryQueue = covertToBlockingQueue(stringBuilder);
        generateReadReport(queryQueue, numbersOfQuery);
        return covertToBlockingQueue(stringBuilder);
    }

    private static StringBuilder convertFileToStringBuilder() {
        try {
            File file = new File(FILE_NAME);
            if (file.length() == 0) {
                throw new Exception("the file named query.txt is empty, filePath: " + FILE_NAME);
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder queryContents = new StringBuilder();
            String line;
            while (Objects.nonNull(line = bufferedReader.readLine())) {
                queryContents.append(line);
            }
            return queryContents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BlockingQueue<String> covertToBlockingQueue(StringBuilder queryContents) throws InterruptedException {
        String[] splits = queryContents.toString().split(",");
        ArrayBlockingQueue<String> queryQueue = new ArrayBlockingQueue<String>(BLOCKING_QUEUE_CAPACITY);
        numbersOfQuery = splits.length;
        for (String s : splits) {
            String split = s.trim();
            if (!"".equals(split)) {
                queryQueue.put(split);
            }
        }
        return queryQueue;
    }

    private static void generateReadReport(BlockingQueue<String> queryQueue, int numbersOfQuery) {
        System.out.println("the total number of query in file is: " + numbersOfQuery);
        System.out.println("the number of effect query is: " + queryQueue.size());
    }
}
