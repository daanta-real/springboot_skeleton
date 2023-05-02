package com.semi.sample.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.semi.sample.service.sampleService;
import com.semi.sample.vo.sampleVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value="/sample")
public class sampleController {
	@Autowired
    sampleService sempleService;
	
	@Operation(summary = "샘플조회", description = "샘플조회")
    @GetMapping("list")
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
        System.out.println("test" + sampleVO.toString());
        int cnt = sempleService.sampleInsert(sampleVO);
        if (cnt > 0) {
        	result.put("resultMsg", "삭제성공하였습니다.");
        	result.put("resultCode", "0");
        } else {
        	result.put("resultMsg", "삭제실패하였습니다.");
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
	
}