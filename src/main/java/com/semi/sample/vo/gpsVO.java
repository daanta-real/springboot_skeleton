package com.semi.sample.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "GPS넣기")
@Data
public class gpsVO {
	
    @Schema(description = "X좌표")
    private double latitude;

    @Schema(description = "Y좌표")
    private double longitude;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
