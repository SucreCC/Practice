package com.coding.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.ResponseEntity;

/**
 * @author: dengKai
 * @date: 2022/05/24 21:53
 * @description: receive return value
 */
@Data
@Accessors(chain = true)
public class QueryResponse {
    private String query;
    private ResponseEntity<String> response;

    @Override
    public String toString(){
        return query ;
    }
}
