package com.coding.core;

import com.coding.domain.QueryResponse;
import com.coding.utils.ThreadPoolUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;



/**
 * @author: dengKai
 * @date: 2022/05/24 22:15
 * @description: query baidu and generate summarize
 */

public class QueryBaiDu {
    private static final List<QueryResponse> SEND_RESULT = Collections.synchronizedList(new ArrayList<>());
    private static final QuerySender QUERY_SENDER = new QuerySender();
    private static final HashMap<Integer, List<QueryResponse>> SUMMARIZE = new HashMap<>();


    public void executeQuery(int threadNumber) throws Exception {
        BlockingQueue<String> queryQueue = new IFileReader().readFileToBlockingQueue();
        int querySize = queryQueue.size();
        List<Runnable> list = QUERY_SENDER.buildSenderList(threadNumber, queryQueue, SEND_RESULT);
        submitThread(list);
        generateSummarize(querySize);
        printSummarize();
    }

    private static void generateSummarize(int querySize) {
        while (true) {
            if (SEND_RESULT.size() == querySize) {
                for (QueryResponse queryResponse : SEND_RESULT) {
                    int statusCode = queryResponse.getResponse().getStatusCode().value();
                    List<QueryResponse> statusList = SUMMARIZE.get(statusCode);
                    if (Objects.isNull(statusList)) {
                        statusList = new ArrayList<>();
                    }
                    statusList.add(queryResponse);
                    SUMMARIZE.put(statusCode, statusList);
                }
                break;
            }
        }
    }

    private static void submitThread(List<Runnable> list) {
        for (Runnable querySender : list) {
            ThreadPoolUtil.submit(querySender);
        }
    }

    private static void printSummarize() {
        System.out.println("we have send " + SEND_RESULT.size() + " request");
        for (Integer integer : SUMMARIZE.keySet()) {
            List<QueryResponse> statuesList = SUMMARIZE.get(integer);
            int size = statuesList.size();
            System.out.println( "the statusCode is " + integer + " have " + size);
            System.out.println(statuesList);
        }
    }
}