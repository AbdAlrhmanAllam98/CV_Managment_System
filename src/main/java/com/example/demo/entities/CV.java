package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CV implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="cv_name")
	private String cvName;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="user_email",referencedColumnName="email")  
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Section> sections;
	
	public CV(){}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCvName() {
		return cvName;
	}

	public void setCvName(String cvName) {
		this.cvName = cvName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
