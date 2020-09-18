package com.app.notify.service.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="categories")
public class Category implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String Name;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creadtedAt;
	
	@OneToMany(mappedBy="category")
	private List<Notification> notifications;
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	public Date getCreadtedAt() {
		return creadtedAt;
	}
	public void setCreadtedAt(Date creadtedAt) {
		this.creadtedAt = creadtedAt;
	}

}
