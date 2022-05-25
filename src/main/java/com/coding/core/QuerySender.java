package com.coding.core;

import com.coding.domain.QueryResponse;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author: dengKai
 * @date: 2022/05/24 21:45
 * @description: to build sender thread
 */

@Data
@Accessors(chain = true)
public class QuerySender {
    private static final IHttpClient I_HTTP_CLIENT = new IHttpClient();

    public List<Runnable> buildSenderList(int number, BlockingQueue<String> queryQueue, List<QueryResponse> queryResponses) {
        List<Runnable> runnableList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Runnable runnable = () -> {
                while (!queryQueue.isEmpty()) {
                    synchronized (queryQueue) {
                        if(!queryQueue.isEmpty()){
                            String query = queryQueue.poll();
                            System.out.println(Thread.currentThread().getName() + " <- total response -> " + queryResponses.size());
                            ResponseEntity<String> response = I_HTTP_CLIENT.doGet(query);
                            QueryResponse queryResponse = new QueryResponse()
                                .setQuery(query)
                                .setResponse(response);
                            queryResponses.add(queryResponse);
                        }
                    }
                }
            };
            runnableList.add(runnable);
        }
        return runnableList;
    }
}
