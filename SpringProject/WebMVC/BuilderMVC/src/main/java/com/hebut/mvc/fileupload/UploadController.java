package com.hebut.mvc.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    @RequestMapping("/toUpload.form")
    public String toUpload(){
        return "upload";
    }
    @RequestMapping(value = "/upload.form")
    public String upload (
            @RequestParam(value = "file",required = false)
            MultipartFile file,
            HttpServletRequest req,
            ModelMap model
        )throws Exception{
        String path = req.getSession().getServletContext().getRealPath("upload");
        System.out.println("path"+path);
        String fileName = file.getOriginalFilename();
        System.out.println("fileName"+fileName);
        File targetPath = new File(path);
        if(!targetPath.exists())
            targetPath.mkdir();
        File targetFile = new File(targetPath, fileName);
        //保存
        file.transferTo(targetFile);
        model.addAttribute("fileUrl",req.getContextPath()+"/upload/"+fileName);

        return "result";
    }
    @RequestMapping(value = "/uploads.form")
    public String uploads(
           @RequestParam(value = "file",required = false)
           MultipartFile[] files,
           HttpServletRequest req,
           ModelMap model
           ){
        ArrayList<String> urls = new ArrayList<String>();
        for (MultipartFile file:files) {
            String path = req.getSession().getServletContext().getRealPath("upload");
            String fileName = file.getOriginalFilename();
            File targetPath = new File(path);
            if(!targetPath.exists())
                targetPath.mkdir();
            File targetFile = new File(path, fileName);
            //保存
            try{
                file.transferTo(targetFile);
                urls.add(req.getContextPath()+"/upload/"+fileName);
            }catch (Exception e){
                e.printStackTrace();
                return "error";
            }
        }
        model.addAttribute("fileUrls",urls);
        return "result";
    }
    //当上面的一个方法抛出异常时，下面方法将会起作用
    @ExceptionHandler
    public ModelAndView doException(Exception ex){
        Map<String, Object> data = new HashMap<String, Object>();
        if(ex instanceof MaxUploadSizeExceededException){
            long maxSize = ((MaxUploadSizeExceededException) ex).getMaxUploadSize();
            data.put("error","上传失败,文件应该小于 "+maxSize+" 字节");
        }else{
            data.put("error","上传失败，拥有其他为知错误: "+ex.getMessage());
        }

        return new ModelAndView("upload",data);
    }
}
