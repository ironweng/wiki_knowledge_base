package com.zhaopei.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaopei.wiki.entity.Ebook;
import com.zhaopei.wiki.entity.EbookExample;
import com.zhaopei.wiki.mapper.EbookMapper;
import com.zhaopei.wiki.req.EbookReq;
import com.zhaopei.wiki.resp.EbookResp;
import com.zhaopei.wiki.resp.PageResp;
import com.zhaopei.wiki.util.CopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
@Slf4j
@Service
public class EbookService {

    @Autowired
    private EbookMapper ebookMapper;

    public PageResp<EbookResp> list(EbookReq req){
        //以下两句是固定写法
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");
        }
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo=new PageInfo<>(ebookList);
        log.info("总条数:{}",pageInfo.getTotal());
        //查询出来的ebookList赋给respList返回给前端
        //(这样做是为了规范,实体类+Req是前端传来的封装查询参数的类,实体类+Resp是后端封装了返回数据的类)

        List<EbookResp> respList= CopyUtil.copyList(ebookList,EbookResp.class);
        PageResp<EbookResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(respList);
        return pageResp;
    }
}
