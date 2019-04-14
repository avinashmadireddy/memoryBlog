package com.rest.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Memory {

	private int id;
	private String description;
	private String createdBy;
	private Date created;

	public Memory() {
		super();
	}

	public Memory(Memory memory) {
		this.id = memory.id;
		this.description = memory.description;
		this.createdBy = memory.createdBy;
		this.created = memory.created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "desc")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Memory [id=" + id + ", description=" + description + ", createdBy=" + createdBy + ", created=" + created
				+ "]";
	}

}
