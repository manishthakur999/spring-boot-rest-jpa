package com.talent.exchange.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class MoBase{

	public static final String ATTR_ID = "id";
	public static final String ATTR_LAST_MODIFIED_DATE = "lastModificationDate";
	public static final String ATTR_CREATION_DATE = "creationDate";

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;

	@Version
	@Column(name = "object_version")
	private int version;

	@Column(name = "creation_date", nullable = false, updatable = false, columnDefinition = "DATETIME(3)")
	private Date creationDate;

	@Column(name = "last_modified_date", nullable = false, columnDefinition = "DATETIME(3)")
	private Date lastModificationDate;

	public MoBase() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	@PrePersist
	protected void onCreate() {
		if (creationDate == null) {
			creationDate = new Date();
		}
		if (lastModificationDate == null) {
			lastModificationDate = new Date();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoBase other = (MoBase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
