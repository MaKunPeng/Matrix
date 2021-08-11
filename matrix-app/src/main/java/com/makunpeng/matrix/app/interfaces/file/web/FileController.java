package com.makunpeng.matrix.app.interfaces.file.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 文件下载测试
     *
     * @return
     */
    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> getFileTest(HttpServletRequest request,
                                                HttpServletResponse response,
                                                @PathVariable("filename") String fileName) {
        logger.debug("Download start");
        String contentType = null;
        Resource resource = null;
        try {
            resource = getFile(fileName);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        } catch (Exception e) {
            logger.error("/download 接口失败", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + URLEncoder.encode(resource.getFilename(), Charset.forName("UTF-8")) + "\"")
                .body(resource);
    }

    /**
     * 获取文件资源
     * @param fileName
     * @return
     * @throws Exception
     */
    private Resource getFile(String fileName) throws Exception {
        Path filePath = Paths.get(fileName);
        try {
            UrlResource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException();
            }
        } catch (Exception e) {
            logger.warn("获取文件失败", e);
            throw new Exception(e);
        }
    }
}
