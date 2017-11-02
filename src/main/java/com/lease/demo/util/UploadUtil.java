package com.lease.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by lzk on 2017/5/12.
 */
@Component
public class UploadUtil
{
    @Autowired
    HttpServletRequest request;
    public String uploadImage(MultipartFile img)
    {
        try
        {
            String relativePath="/image";
            String savePath = request.getServletContext().getRealPath(relativePath);
            String filename =img.getOriginalFilename().substring(img.getOriginalFilename().indexOf("/")+1);
            // 创建保存的文件

            //判断保存的文件路径是否存在  不存在就新建一个
            File savaFile = new File(savePath);
            if (!savaFile.exists())
                savaFile.mkdirs();

            File file = new File(savePath, filename);

            img.transferTo(file);
            return "/image/"+filename;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
