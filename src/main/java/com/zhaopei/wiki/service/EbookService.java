package com.zhaopei.wiki.service;

import com.zhaopei.wiki.entity.Ebook;
import com.zhaopei.wiki.entity.EbookExample;
import com.zhaopei.wiki.mapper.EbookMapper;
import com.zhaopei.wiki.req.EbookReq;
import com.zhaopei.wiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Autowired
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        //以下两句是固定写法
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        //查询出来的ebookList赋给respList返回给前端
        //(这样做是为了规范,实体类+Req是前端传来的封装查询参数的类,实体类+Resp是后端封装了返回数据的类)
        List<EbookResp> respList=new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp=new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);
            respList.add(ebookResp);
        }
        return respList;
    }
}
