package com.bm2i.security;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "PermissionGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Permission", initialValue = 1, allocationSize = 1)
@NamedQueries(value = {
		@NamedQuery(name = "Permission.findByRoleIds", query = "select o from Permission o where o.role.id in (:roleIds)"),
		@NamedQuery(name = "Permission.findRootActionsByRoleIds", query = "select o from Permission o left join fetch o.action a where o.role.id in (:roleIds) and a.parent is null") })
public class Permission {
	@Id
	@GeneratedValue(generator = "PermissionGenerator", strategy = GenerationType.TABLE)
	private Long id;
	
	private Date expirationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 5)
	private PermissionType permissionType;

	@ManyToOne
	private Role role;

	@ManyToOne
	@JoinColumn(name = "action_id")
	private Action action;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PermissionType getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(PermissionType permissionType) {
		this.permissionType = permissionType;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public int hashCode() {
		int hash = 13;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Permission that = (Permission) o;
		if (getId() != null ? !(getId().equals(that.getId()))
				: that.getId() != null) {
			return false;
		}

		if (that.getId() == null && getId() == null) {
			return false;
		}

		return true;
	}
}
