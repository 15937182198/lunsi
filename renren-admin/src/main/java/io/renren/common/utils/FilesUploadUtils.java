package io.renren.common.utils;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件上传及修改工具类
 */

@Component
public class FilesUploadUtils {

    @Transactional
    public List<String> upload(MultipartFile...files) throws IOException {
        System.out.println("文件上传执行");
        if (files.length==0){
            return null;
        }
        List<String> list=new ArrayList<String>();
        for (MultipartFile file : files) {
            String filePath = "C:/Users/Administrator.USER-20180311XA/Desktop/springboot-plus/img/";
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
            String fileName = simpleDateFormat.format(new Date())+file.getOriginalFilename();
            File dest = new File(filePath + fileName);
            file.transferTo(dest);
            list.add(filePath+fileName);
        }
        return list;
    }

    @Transactional
    public void deleteImg(String...imgAddress){
        if (imgAddress.length==0){
            return;
        }
        for (String address : imgAddress) {
            File file=new File(address);
            file.delete();
        }
    }
}
