package com.semi.sample.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.semi.sample.vo.sampleVO;

import java.util.List;

@Repository
@Mapper
public interface sampleDao {

	List<sampleVO> getSampleList();

}