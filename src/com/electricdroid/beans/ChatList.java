package com.electricdroid.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "chat_list")
public class ChatList implements Serializable {

	// important
	// @Id @GeneratedValue
	private Integer _id;
	// @Column
	private String key_remote_jid;
	// @Column
	private Integer message_table_id;
	// @Column
	private String subject;
	// @Column
	private Integer creation;
	// @Column
	private Integer last_read_message_table_id;
	// @Column
	private Integer last_read_receipt_sent_message_table_id;
	// @Column
	private Integer archived;
	// @Column
	private Integer sort_timestamp;
	// @Column
	private Integer mod_tag;
	
	
	public Integer getGen() {
		return gen;
	}
	public void setGen(Integer gen) {
		this.gen = gen;
	}
	public Integer getMy_messages() {
		return my_messages;
	}
	public void setMy_messages(Integer my_messages) {
		this.my_messages = my_messages;
	}
	// @Column
    private Integer gen;
	// @Column
	private Integer my_messages;
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
	public Integer getMessage_table_id() {
		return message_table_id;
	}
	public void setMessage_table_id(Integer message_table_id) {
		this.message_table_id = message_table_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getCreation() {
		return creation;
	}
	public void setCreation(Integer creation) {
		this.creation = creation;
	}
	public Integer getLast_read_message_table_id() {
		return last_read_message_table_id;
	}
	public void setLast_read_message_table_id(Integer last_read_message_table_id) {
		this.last_read_message_table_id = last_read_message_table_id;
	}
	public Integer getLast_read_receipt_sent_message_table_id() {
		return last_read_receipt_sent_message_table_id;
	}
	public void setLast_read_receipt_sent_message_table_id(
			Integer last_read_receipt_sent_message_table_id) {
		this.last_read_receipt_sent_message_table_id = last_read_receipt_sent_message_table_id;
	}
	public Integer getArchived() {
		return archived;
	}
	public void setArchived(Integer archived) {
		this.archived = archived;
	}
	public Integer getSort_timestamp() {
		return sort_timestamp;
	}
	public void setSort_timestamp(Integer sort_timestamp) {
		this.sort_timestamp = sort_timestamp;
	}
	public Integer getMod_tag() {
		return mod_tag;
	}
	public void setMod_tag(Integer mod_tag) {
		this.mod_tag = mod_tag;
	}

	
}
