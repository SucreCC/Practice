package com.coding.core;

import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: dengKai
 * @date: 2022/05/24 23:29
 * @description:
 */

public class QueryBaiDuTest {

    /**
     *  threadNumber: how many thread you want to use
     * @throws Exception
     */

    @Test
    public void sendTest() throws Exception {
        QueryBaiDu queryBaiDu = new QueryBaiDu();
        queryBaiDu.executeQuery(10);
    }

    /**
     * to define how many query you want to send, now I have set 100 queries in file.
     * @throws IOException
     */

    @Test
    public void writeQueryToFile() throws IOException {
        StringBuilder queryContent = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            queryContent.append(i).append(",");
        }
        String filePath = "src/main/resources/query.txt";
        File queryFile = new File(filePath);
        if (!queryFile.exists()) {
            queryFile.createNewFile();
        }
        writeByFileWrite(filePath, queryContent.toString());
    }



    public static void writeByFileWrite(String _sDestFile, String _sContent)
        throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(_sDestFile);
            fw.write(_sContent);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fw != null) {
                fw.close();
            }
        }
    }

}
