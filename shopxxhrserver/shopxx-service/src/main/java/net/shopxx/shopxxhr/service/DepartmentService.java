package net.shopxx.shopxxhr.service;

import net.shopxx.shopxxhr.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartmentsByParentId(Integer pid);

    Department saveOrUpdateDepartment(Department dep);

    Integer deleteDep(Integer did);

    List<Department> getAllDepartmentsWithoutChildren();
}
