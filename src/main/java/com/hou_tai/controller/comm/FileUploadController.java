package com.hou_tai.controller.comm;

import com.hou_tai.enums.ResultCode;
import com.hou_tai.response.ResponseData;
import com.hou_tai.response.ResultVO;
import com.hou_tai.service.IFileUploadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: GaoLu
 * @Date: 2023-10-24 14:03
 * @Description: 图片上传controller
 */
@Controller
@RequestMapping("/comm/fileUpload")
@Tag(name = "文件上传")
public class FileUploadController {

    @Resource
    private IFileUploadService fileUploadService;

    @ResponseBody
    @Operation(summary = "文件上传")
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultVO<Object> uploadFile(@RequestPart("files") MultipartFile[] files) //1返回图片相对路径 2返回图片绝对路径
    {
        if (files == null || (files.length == 1 && files[0].getSize() == 0)) {
            return ResponseData.error("文件为空", ResultCode.FAILED);
        }
        List<String> map = fileUploadService.upload(files);
        //System.out.println(map);
        return ResponseData.success(map);

    }
}
