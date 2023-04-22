package com.semi.sample.vo;

//import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class sampleVO {
	int id;
//	@ApiParam(value = "사용자 이름", required = false, example = "홍길동")
    String name;
    String email;
    String phone;
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
