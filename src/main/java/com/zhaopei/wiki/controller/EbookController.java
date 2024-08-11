package com.zhaopei.wiki.controller;

import com.zhaopei.wiki.req.EbookQueryReq;
import com.zhaopei.wiki.req.EbookSaveReq;
import com.zhaopei.wiki.resp.CommonResp;
import com.zhaopei.wiki.resp.EbookQueryResp;
import com.zhaopei.wiki.resp.PageResp;
import com.zhaopei.wiki.service.EbookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    private static final Logger LOG = LoggerFactory.getLogger(EbookController.class);

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(@Valid EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        ebookService.delete(id);
        return resp;
    }

    @RequestMapping("/upload/avatar")
    public CommonResp upload(@RequestParam MultipartFile avatar) throws IOException {
        LOG.info("上传文件开始：{}", avatar);
        LOG.info("文件名：{}", avatar.getOriginalFilename());
        LOG.info("文件大小：{}", avatar.getSize());

        // 保存文件到本地
        String fileName = avatar.getOriginalFilename();
        String fullPath = "D:/file/wiki/" + fileName;
        File dest = new File(fullPath);
        avatar.transferTo(dest);
        LOG.info(dest.getAbsolutePath());

        return new CommonResp();
    }
}
