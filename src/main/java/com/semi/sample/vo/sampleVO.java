package com.semi.sample.vo;

import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.annotations.ApiParam;
import lombok.Data;

@Schema(description = "샘플데이터 VO")
@Data
public class sampleVO {
	
	@Schema(description = "아이디")
	private int id;
	
	@Schema(description = "이름")
    String name;
	
	@Schema(description = "이메일")
    String email;
	
	@Schema(description = "핸드폰번호")
    String phone;
	
	@Schema(description = "이메일")
    String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
    
}
