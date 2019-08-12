package com.github.springbootmiaosha.house;

import com.github.springbootmiaosha.SpringbootMiaoshaApplicationTests;
import com.github.springbootmiaosha.service.house.IQiNiuService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * 七牛云服务相关测试类
 */
public class QiNiuServiceTests extends SpringbootMiaoshaApplicationTests {

    @Autowired
    private IQiNiuService qiNiuService;

    @Test
    public void testUploadFile(){

        String fileName = "F:\\idea resource code\\springboot-miaosha\\src\\main\\resources\\temp\\1-1Z10GQ517.jpg";

        File file = new File(fileName);

        Assert.assertTrue(file.exists());

        try {
            Response response = qiNiuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        }catch (QiniuException e){
            e.printStackTrace();
        }

    }


}
