package com.zhaopei.wiki.controller;

import com.zhaopei.wiki.entity.Ebook;
import com.zhaopei.wiki.resp.CommonResp;
import com.zhaopei.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(){
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        List<Ebook> list=ebookService.list();
        resp.setContent(list);
        return resp;
    }
}
