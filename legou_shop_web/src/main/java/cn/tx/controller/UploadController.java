package cn.tx.controller;

import cn.tx.entity.Result;
import cn.tx.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    // 从application.properties配置文件中读取配置文件
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {
        // 获取上传文件的名称
        String originalFilename = file.getOriginalFilename();
        // 获取上传文件的后缀名
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            // 创建一个 FastDFS 的客户端对象
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            // 执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);
            // 拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = FILE_SERVER_URL + path;
            return new Result(true, "上传成功", url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }
}
