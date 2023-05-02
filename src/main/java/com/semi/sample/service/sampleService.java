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

    public List<sampleVO> getSampleList(sampleVO sampleVO) {

        List<sampleVO> sampleList = sampleDao.getSampleList(sampleVO);

        return sampleList;
    }

	public int sampleInsert(sampleVO sampleVO) {
		return sampleDao.sampleInsert(sampleVO);
	}

	public int sampleUpdate(sampleVO sampleVO) {
		return sampleDao.sampleUpdate(sampleVO);
	}

	public int sampleDelete(int id) {
		return sampleDao.sampleDelete(id);
	}
}