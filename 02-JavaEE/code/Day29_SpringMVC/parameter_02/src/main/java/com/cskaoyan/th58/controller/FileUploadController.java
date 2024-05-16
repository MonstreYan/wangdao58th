package com.cskaoyan.th58.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 11:44
 * @Version 1.0
 */
@RestController
@RequestMapping("admin/storage")
public class FileUploadController {

    //比如页面提交了一个file：binary文件数据，key值叫做file
    //之前项目一是如何获取的呢？？？？ request.getPart(name属性)
    //形参的名称要求和文件的name属性一致
    @PostMapping("create")
    public Object create(MultipartFile file){

        String filename = file.getOriginalFilename();
        filename = UUID.randomUUID() + "-" + filename;
        //此时如果希望将文件存储到应用根目录中，略有一些麻烦，除除此之外和项目一的操作基本一致
        File f = new File("D:\\image\\" + filename);
        try {
            file.transferTo(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
