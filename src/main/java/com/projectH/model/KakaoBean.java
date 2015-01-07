package com.projectH.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class KakaoBean {
	
	private String id;
	private String nickname;
	private String thumbnail_image;
	private String profile_image;
	@JsonProperty
	public String getId() {
		return id;
	}
	@JsonProperty
	public void setId(String id) {
		this.id = id;
	}
	@JsonProperty
	public String getNickname() {
		return nickname;
	}
	@JsonProperty
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@JsonProperty
	public String getThumbnail_image() {
		return thumbnail_image;
	}
	@JsonProperty
	public void setThumbnail_image(String thumbnail_image) {
		this.thumbnail_image = thumbnail_image;
	}
	@JsonProperty
	public String getProfile_image() {
		return profile_image;
	}
	@JsonProperty
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
}
