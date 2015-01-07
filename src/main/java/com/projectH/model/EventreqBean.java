package com.projectH.model;

public class EventreqBean {

	private String user_id;
	private String cs_time;
	private String cs_date;
	private int cs_state;
	private String event;
	private String company_id;
	private String user_name;
	private String user_phone;
	
	/*쪽나누기(페이징)*/
	private int startrow;
	private int endrow;
	
	/*검색필드와 검색어 저장변수*/
	private String find_field;//검색필드
	private String find_name;//검색어
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCs_time() {
		return cs_time;
	}
	public void setCs_time(String cs_time) {
		this.cs_time = cs_time;
	}
	public String getCs_date() {
		return cs_date;
	}
	public void setCs_date(String cs_date) {
		this.cs_date = cs_date;
	}
	public int getCs_state() {
		return cs_state;
	}
	public void setCs_state(int cs_state) {
		this.cs_state = cs_state;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	public String getFind_field() {
		return find_field;
	}
	public void setFind_field(String find_field) {
		this.find_field = find_field;
	}
	public String getFind_name() {
		return find_name;
	}
	public void setFind_name(String find_name) {
		this.find_name = find_name;
	}
	
	
}
