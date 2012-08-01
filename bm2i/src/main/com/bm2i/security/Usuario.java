package com.bm2i.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bm2i.comun.model.Persona;



@Entity
@TableGenerator(name = "UsuarioGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Usuario", initialValue = 1, allocationSize = 1)
@NamedQueries(value = {
		@NamedQuery(name = "Usuario.findByUsernameAndPassword", query = "select u from Usuario u where u.name = :name and u.password = :password"),
		@NamedQuery(name = "Usuario.findPersonByUserId", query = "select u.persona from Usuario u where u.id = :userId"),
		@NamedQuery(name = "Usuario.findUsuarioByPersona", query = "select u from Usuario u where u.persona = :persona")})
public class Usuario {
	@Id
	@GeneratedValue(generator = "UsuarioGenerator", strategy = GenerationType.TABLE)
	private Long id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false)
	private String password;

	private Boolean isActive;
	@Temporal(TemporalType.DATE)
	private Date expirationDate;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Persona persona;

	@ManyToMany(mappedBy = "users")
	private List<Role> roles;

	public Usuario() {
		roles = new ArrayList<Role>();
		expirationDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void add(Role role) {
		if (role != null && !roles.contains(role)) {
			this.roles.add(role);
			role.add(this);
		}
	}

	public void remove(Role role) {
		if (role != null && roles.contains(role)) {
			this.roles.remove(role);
			role.remove(this);
		}
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
