package com.semi.sample.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "GPS넣기")
@Data
public class gpsVO {
	
    @Schema(description = "X좌표")
    private String latitude;

    @Schema(description = "Y좌표")
    private String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
    
}
