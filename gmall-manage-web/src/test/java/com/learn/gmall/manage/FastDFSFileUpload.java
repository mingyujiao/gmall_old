package com.learn.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Jmy
 * @date 2019/12/3 15:53
 * @email jiaomingyu5778@gmail.com
 * 测试FastDFS上传
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDFSFileUpload {

    @Test
    public void textFileUpload() throws IOException, MyException, URISyntaxException {
        String file = this.getClass().getResource("/tracker.conf").toURI().getPath();
        ClientGlobal.init(file);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String orginalFilename = "C:\\Users\\29109\\Pictures\\Camera Roll\\O1CN01MZp5zh1xKEu1idjQE_!!1776456424.jpg_430x430q90.jpg";
        String[] upload_file = storageClient.upload_file(orginalFilename, "jpg", null);
        for (int i = 0; i < upload_file.length; i++) {
            String s = upload_file[i];
            System.out.println("s = " + s);
        }

    }
}
