package hungnd.booking_system.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	@Expose
	@SerializedName("accessToken")
	private String accessToken;

	@Expose
	@SerializedName("expirationTime")
	private Long expirationTime;

	public JwtResponse(String accessToken, Long expirationTime) {
		this.accessToken = accessToken;
		this.expirationTime = expirationTime;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public Long getExpirationTime() {
		return expirationTime;
	}
}