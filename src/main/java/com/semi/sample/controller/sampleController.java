package com.semi.sample.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semi.sample.service.sampleService;
import com.semi.sample.vo.sampleVO;
import com.semi.sample.vo.gpsVO;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/sample")
public class sampleController {
	@Autowired
    sampleService sempleService;
	
	@Operation(summary = "샘플조회", description = "샘플조회")
    @PostMapping("list")
    public HashMap<String, Object> getSampleList(@RequestBody sampleVO sampleVO ){
        HashMap<String, Object> result = new HashMap<>();
        List<sampleVO> sempleList= sempleService.getSampleList(sampleVO);
        result.put("data", sempleList);

        return result;
    }
	
	@Operation(summary = "샘플데이터 추가", description = "샘플추가")
    @PostMapping("insert")
    public HashMap<String, Object> sampleInsert(@RequestBody sampleVO sampleVO ){
        HashMap<String, Object> result = new HashMap<>();
        int cnt = sempleService.sampleInsert(sampleVO);
        if (cnt > 0) {
        	result.put("resultMsg", "삽입성공하였습니다.");
        	result.put("resultCode", "0");
        } else {
        	result.put("resultMsg", "삽입실패하였습니다.");
        	result.put("resultCode", "-1");
        }

        return result;
    }
	
	@Operation(summary = "샘플데이터 수정", description = "샘플로 만든 API입니다. 참고하세요")
	@PutMapping("update")
    public HashMap<String, Object> sampleUpdate(@RequestBody sampleVO sampleVO ){
        HashMap<String, Object> result = new HashMap<>();
        int cnt = sempleService.sampleUpdate(sampleVO);
        if (cnt > 0) {
        	result.put("resultMsg", "업데이트성공하였습니다.");
        	result.put("resultCode", "0");
        } else {
        	result.put("resultMsg", "업데이트실패하였습니다.");
        	result.put("resultCode", "-1");
        }
        return result;
    }
	
	@Operation(summary = "샘플삭제", description = "샘플로 만든 API입니다. 참고하세요")
    @DeleteMapping("delete")
    public HashMap<String, Object> sampleDelete(@RequestParam(name = "id") int id){
        HashMap<String, Object> result = new HashMap<>();
        int cnt = sempleService.sampleDelete(id);
        if (cnt > 0) {
        	result.put("resultMsg", "삭제성공하였습니다.");
        	result.put("resultCode", "0");
        } else {
        	result.put("resultMsg", "삭제실패하였습니다.");
        	result.put("resultCode", "-1");
        }
        return result;
    }
	
	@Operation(summary = "GPS정보 마지막정보 불러오기", description = "GPS정보 마지막정보 불러오기")
    @PostMapping("getGps")
    public gpsVO getGpsLastInfo(@RequestBody gpsVO gpsVO ){
        HashMap<String, Object> result = new HashMap<>();
        gpsVO gpsInfo = new gpsVO();
        gpsInfo= sempleService.getGpsLastInfo();
        return gpsInfo;
    }
	
	@Operation(summary = "GPS정보 집어넣기", description = "GPS정보 넣기")
    @PostMapping("gpsInsert")
    public HashMap<String, Object> gpsInsert(@RequestBody gpsVO gpsVO ){
        HashMap<String, Object> result = new HashMap<>();
        int cnt = sempleService.gpsInsert(gpsVO);
        if (cnt > 0) {
        	result.put("resultMsg", "삽입성공하였습니다.");
        	result.put("resultCode", "0");
        } else {
        	result.put("resultMsg", "삽입실패하였습니다.");
        	result.put("resultCode", "-1");
        }

        return result;
    }
	
}