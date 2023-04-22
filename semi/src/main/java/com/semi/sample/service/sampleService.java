package com.semi.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.semi.sample.dao.sampleDao;
import com.semi.sample.vo.sampleVO;

import java.util.List;

@Service
public class sampleService {

    @Autowired
    sampleDao sampleDao;

    public List<sampleVO> getSampleList() {

        List<sampleVO> sampleList = sampleDao.getSampleList();

        return sampleList;
    }
}