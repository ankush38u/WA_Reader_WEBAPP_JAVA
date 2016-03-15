package com.electricdroid.beans;

public class Message {
    private Integer _id;
	private String key_remote_jid;
	private Integer key_from_me;
	private String data;
	private Integer timestamp;
	private String media_url;
	private String media_mime_type;
	private Integer media_wa_type;
	private Integer received_timestamp;
	@Override
	public String toString() {
		return "Message [_id=" + _id + ", key_remote_jid=" + key_remote_jid
				+ ", key_from_me=" + key_from_me + ", data=" + data
				+ ", timestamp=" + timestamp + ", media_url=" + media_url
				+ ", media_mime_type=" + media_mime_type + ", media_wa_type="
				+ media_wa_type + ", received_timestamp=" + received_timestamp
				+ ", remote_resource=" + remote_resource + "]";
	}
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public String getKey_remote_jid() {
		return key_remote_jid;
	}
	public void setKey_remote_jid(String key_remote_jid) {
		this.key_remote_jid = key_remote_jid;
	}
	public Integer getKey_from_me() {
		return key_from_me;
	}
	public void setKey_from_me(Integer key_from_me) {
		this.key_from_me = key_from_me;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}
	public String getMedia_url() {
		return media_url;
	}
	public void setMedia_url(String media_url) {
		this.media_url = media_url;
	}
	public String getMedia_mime_type() {
		return media_mime_type;
	}
	public void setMedia_mime_type(String media_mime_type) {
		this.media_mime_type = media_mime_type;
	}
	public Integer getMedia_wa_type() {
		return media_wa_type;
	}
	public void setMedia_wa_type(Integer media_wa_type) {
		this.media_wa_type = media_wa_type;
	}
	public Integer getReceived_timestamp() {
		return received_timestamp;
	}
	public void setReceived_timestamp(Integer received_timestamp) {
		this.received_timestamp = received_timestamp;
	}
	public String getRemote_resource() {
		return remote_resource;
	}
	public void setRemote_resource(String remote_resource) {
		this.remote_resource = remote_resource;
	}
	private String remote_resource;
	
	
}
