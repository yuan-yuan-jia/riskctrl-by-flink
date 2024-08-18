package com.jyy.riskctrl.utils.hbase;

import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class HbaseUtil {

    @Autowired
    private HbaseConf hbaseConf;


    private Connection connection = null;
    private Admin admin = null;



    public  Connection getConnection() throws IOException {
        if (connection == null) {
           synchronized (this) {
               if (connection == null) {
                   connection = ConnectionFactory.createConnection(hbaseConf.configuration());
               }
           }
        }
        return connection;
    }

    public Admin getAdmin() throws IOException {
        return getConnection().getAdmin();
    }

}
