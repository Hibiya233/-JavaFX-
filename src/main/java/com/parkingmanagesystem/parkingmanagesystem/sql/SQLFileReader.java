package com.parkingmanagesystem.parkingmanagesystem.sql;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SQLFileReader {
    private String readSQL = ""; // 读取到的SQL语句

    public SQLFileReader(String sql) {
        try {
            // 读取SQL文件
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sql), StandardCharsets.UTF_8));
            String line;
            while((line = br.readLine()) != null) {
                this.readSQL = this.readSQL.concat(line + "\n");
            }

            // 关闭连接
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSQL() {
        return this.readSQL;
    }
}
