package com.cropdeal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;


@Document(collection = "db_sequence")
@Data
public class db_sequence {
	
	
	@Id
	private String id;
	private long seqNo;
	
	public db_sequence() {}
	
	
	public db_sequence(String id, long seqNo) {
		super();
		this.id = id;
		this.seqNo = seqNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}
	@Override
	public String toString() {
		return "db_sequence [id=" + id + ", seqNo=" + seqNo + "]";
	}
	
	

}
