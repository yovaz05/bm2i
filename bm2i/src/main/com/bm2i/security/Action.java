package com.bm2i.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name = "ActionGenerator", table = "IdentityGenerator", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "Action", initialValue = 1, allocationSize = 1)
@NamedQueries(value = {

@NamedQuery(name = "Action.findByName", query = "select a from Action a where "
		+ "lower(a.name) like lower(concat(:sugerencia, '%'))") })
public class Action {
	@Id
	@GeneratedValue(generator = "ActionGenerator", strategy = GenerationType.TABLE)
	private Long id;
	private String icon;
	private String name;
	private String url;
	private Integer priority;

	@OrderBy("priority ASC")
	@OneToMany(mappedBy = "parent", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, fetch = FetchType.EAGER)
	private List<Action> actions;

	@ManyToOne
	private Action parent;

	public Action() {
		actions = new ArrayList<Action>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setParent(Action parent) {
		this.parent = parent;
	}

	public Action getParent() {
		return parent;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void add(Action act) {
		if (act != null && !actions.contains(act)) {
			this.actions.add(act);
			act.setParent(this);
		}
	}

	public void remove(Action act) {
		if (act != null && actions.contains(act)) {
			this.actions.remove(act);
			act.setParent(null);
		}
	}
}