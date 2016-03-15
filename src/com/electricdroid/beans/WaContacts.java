package com.electricdroid.beans;

import java.io.Serializable;


public class WaContacts implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Integer _id;
	private String jid;
	private Integer is_whatsapp_user;
	private String status;
	private Integer status_timestamp;
	private String display_name;
	private Integer photo_ts;
	private String wa_name;
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public Integer getIs_whatsapp_user() {
		return is_whatsapp_user;
	}
	public void setIs_whatsapp_user(Integer is_whatsapp_user) {
		this.is_whatsapp_user = is_whatsapp_user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getStatus_timestamp() {
		return status_timestamp;
	}
	public void setStatus_timestamp(Integer status_timestamp) {
		this.status_timestamp = status_timestamp;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public Integer getPhoto_ts() {
		return photo_ts;
	}
	public void setPhoto_ts(Integer photo_ts) {
		this.photo_ts = photo_ts;
	}
	public String getWa_name() {
		return wa_name;
	}
	public void setWa_name(String wa_name) {
		this.wa_name = wa_name;
	}
	@Override
	public String toString() {
		return "WaContacts [_id=" + _id + ", jid=" + jid
				+ ", is_whatsapp_user=" + is_whatsapp_user + ", status="
				+ status + ", status_timestamp=" + status_timestamp
				+ ", display_name=" + display_name + ", photo_ts=" + photo_ts
				+ ", wa_name=" + wa_name + "]";
	}
	

	
}
