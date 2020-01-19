package net.shopxx.shopxxhr.service;

import net.shopxx.shopxxhr.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role saveOrUpdateRole(Role role);

    void deleteRoleById(Integer id);
}
