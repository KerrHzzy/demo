package net.xdclass.demo.controller;

import net.xdclass.demo.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 功能描述：文件测试
 *
 * <p> 创建时间：Apr 22, 2018 11:22:29 PM </p>
 * @author hdz
 */
@RestController
@PropertySource({"classpath:application.properties"})
public class FileController {

    @RequestMapping(value = "/api/v1/go_page")
    public Object index() {
        return "index";
    }

    /**
     * 文件保存路径
     */
    @Value("${web.file.path}")
    private String filePath;
    //private static final String FILE_PATH = "C:\\Users\\mid0801\\IdeaProjects\\demo\\src\\main\\resources\\static\\images\\";

    @RequestMapping(value = "upload")
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

        //file.isEmpty(); 判断图片是否为空
        //file.getSize(); 图片大小进行判断

        System.out.println("配置注入答应，文件上传路径为："+filePath);

        String name = request.getParameter("name");
        System.out.println("用户名："+name);

        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

        // 获取文件的后缀名,比如图片的jpeg,png
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);

        // 文件上传后的路径
        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称:"+fileName);

        File dest = new File(filePath + fileName);

        try {

            file.transferTo(dest);
            return new JsonData(0, fileName);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        return  new JsonData(-1, "fail to save ", null);
    }
}
