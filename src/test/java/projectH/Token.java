package projectH;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "oauth")
class JaxbOAuth2AccessToken {
	private String accessToken;

	private Long expiresIn;

	private String refreshToken;

	@XmlElement(name = "access_token")
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@XmlElement(name = "expires_in")
	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public void setExpriation(Date expiration) {
		if(expiration == null) {
			setExpiresIn(null);
			return;
		}
		long now = System.currentTimeMillis();
		setExpiresIn((expiration.getTime() - now) / 1000);
	}

	@XmlTransient
	public Date getExpiration() {
		if(expiresIn == null) {
			return null;
		}
		long now = System.currentTimeMillis();
		return new Date(now + (expiresIn * 1000));
	}

	@XmlElement(name = "refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}