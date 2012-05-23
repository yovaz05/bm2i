package com.bm2i.security.action;

import java.util.LinkedList;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityController;

import com.bm2i.security.Permission;
import com.bm2i.security.Role;

@Name("menuGeneratorAction")
@Scope(ScopeType.SESSION)
public class MenuGeneratorAction extends EntityController {

	private static final long serialVersionUID = 1L;

	private List<Permission> rootPermissions;

	public List<Permission> getRootPermissions() {
		return rootPermissions;
	}

	public void setRootPermissions(List<Permission> rootPermissions) {
		this.rootPermissions = rootPermissions;
	}

	@SuppressWarnings("unchecked")
	@Observer(value = "org.jboss.seam.security.loginSuccessful")
	public List<Permission> findPermissions() {
		UserSession userSession = (UserSession) getSessionContext().get(
				UserSession.class);
		Long userId = userSession.getUsuario().getId();
		// System.out.println("MENU GENERATOR FOR USER ID----> " + userId);

		/*
		 * Query query =
		 * getEntityManager().createNamedQuery("Role.findIdByUserId");
		 * query.setParameter("userId", userId); List<Role> roles =
		 * query.getResultList();
		 */
		List<Role> roles = userSession.getUsuario().getRoles();
		System.out.println("Los roles  ----> " + roles.size());
		rootPermissions = new LinkedList<Permission>();
		if (roles.size() > 0) {
			/*
			 * List<Long> roleIds = new ArrayList<Long>(); for (Role r : roles)
			 * { roleIds.add(r.getId()); } /*Query query =
			 * getEntityManager().createNamedQuery(
			 * "Permission.findRootActionsByRoleIds");
			 * query.setParameter("roleIds", roleIds); //List<Permission>
			 * permissions = query.getResultList();
			 * 
			 * LinkedHashMap<Long, Permission> actionMap = new
			 * LinkedHashMap<Long, Permission>();
			 * 
			 * /*for (Permission permission : permissions) { if
			 * (!actionMap.containsKey(permission.getAction().getId())) {
			 * actionMap.put(permission.getAction().getId(), permission); } }
			 */

			// rootPermissions.addAll(actionMap.values());

			List<Permission> localPermission;
			// Query
			// q=this.getEntityManager().createNamedQuery("Action.buscarById");
			for (Role lor : roles) {

				rootPermissions = lor.getPermissions();
				System.out.println("(" + rootPermissions.size() + ")");
			}

		}

		return rootPermissions;
	}

	@Observer("org.jboss.seam.security.loggedOut")
	public void resetMenu() {
		rootPermissions = new LinkedList<Permission>();
		UserSession userSession = (UserSession) getSessionContext().get(
				UserSession.class);
		userSession.setUsuario(null);
	}
}
