package org.christoph.mybatis.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Partner implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nif;
	private Person person;
	
	private  LocalDate entry;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public LocalDate getEntry() {
		return entry;
	}

	public void setEntry(LocalDate entry) {
		this.entry = entry;
	}
	
	public Person getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "Partner [id=" + id + ", nif=" + nif + ", entry=" + entry + "]";
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
		Partner other = (Partner) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
