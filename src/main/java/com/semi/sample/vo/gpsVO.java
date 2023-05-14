package com.semi.sample.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "GPS넣기")
@Data
public class gpsVO {
	
    @Schema(description = "X좌표")
    private Long latitude;

    @Schema(description = "Y좌표")
    private Long longitude;

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

    
}
