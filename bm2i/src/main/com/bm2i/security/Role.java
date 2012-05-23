package com.bm2i.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cascade;

@Entity
@TableGenerator(name = "RoleGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Role", initialValue = 1, allocationSize = 1)
@NamedQueries(@NamedQuery(name = "Role.findIdByUserId", query = "select o from Role o left join fetch o.users u where u.id = :userId"))
public class Role {
	@Id
	@GeneratedValue(generator = "RoleGenerator", strategy = GenerationType.TABLE)
	private Long id;
	private String name;
	private String description;

	@ManyToMany
	private List<Usuario> users;

	@OneToMany(mappedBy = "role", cascade = {CascadeType.ALL})
	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<Permission> permissions;

	public Role() {
		users = new ArrayList<Usuario>();
		permissions = new ArrayList<Permission>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public void add(Usuario user) {
		if (user != null && !users.contains(user)) {
			this.users.add(user);
			user.add(this);
		}
	}

	public void remove(Usuario user) {
		if (user != null && users.contains(user)) {
			this.users.remove(user);
			user.remove(this);
		}
	}

	public void add(Permission per) {
		if (per != null && !permissions.contains(per)) {
			this.permissions.add(per);
			per.setRole(this);
		}
	}

	public void remove(Permission per) {
		if (per != null && !permissions.contains(per)) {
			this.permissions.remove(per);
			per.setRole(null);
		}
	}

}
