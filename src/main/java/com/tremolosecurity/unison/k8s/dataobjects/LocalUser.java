package com.tremolosecurity.unison.k8s.dataobjects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "localUsers")
public class LocalUser {

	int userId;
	String sub;
	String mail;
	List<LocalGroup> groups;
	
	public LocalUser() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

	@Column(name = "sub", nullable = false)
	public String getSub() {
		return sub;
	}

	public void setSub(String name) {
		this.sub = name;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "userGroups",  joinColumns = {
			@JoinColumn(name = "groupId", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "userId",
					nullable = false, updatable = false) })
	public List<LocalGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<LocalGroup> groups) {
		this.groups = groups;
	}

	@Column(name = "mail", nullable = true)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}
