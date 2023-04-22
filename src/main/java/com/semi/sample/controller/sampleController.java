package com.semi.sample.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.semi.sample.service.sampleService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/sample")
public class sampleController {
	@Autowired
    sampleService sempleService;
	
	@Operation(summary = "샘플조회", description = "샘플로 만든 API입니다. 참고하세요")
    @GetMapping("")
//	@ApiOperation(value = "사용자 정보 조회", notes = "UserId를 이용하여 사용자 정보를 조회합니다.")
//	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSampleList(){
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", sempleService.getSampleList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}