package com.app.notify.service.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    
	@ManyToOne
	@JoinColumn(name="category_id", nullable=true)
    private Category category;
    
    private String title;
    private String message;
    
    @Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creadtedAt;
    
    @Column(name="deleted_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreadtedAt() {
		return creadtedAt;
	}
	public void setCreadtedAt(Date creadtedAt) {
		this.creadtedAt = creadtedAt;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
