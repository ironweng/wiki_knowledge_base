package com.zhaopei.wiki.controller;

import com.zhaopei.wiki.req.EbookReq;
import com.zhaopei.wiki.resp.CommonResp;
import com.zhaopei.wiki.resp.EbookResp;
import com.zhaopei.wiki.resp.PageResp;
import com.zhaopei.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    //通过id或name查询电子书，因为EbookReq(封装查询参数的类)中有id和name两个成员变量
    public CommonResp list(EbookReq req){
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list=ebookService.list(req);
        resp.setContent(list);
        return resp;
    }
}
