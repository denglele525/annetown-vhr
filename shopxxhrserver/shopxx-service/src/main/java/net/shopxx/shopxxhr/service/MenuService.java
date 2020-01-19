package net.shopxx.shopxxhr.service;

import net.shopxx.shopxxhr.model.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getMenusByHrId(Integer id);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);

    void updateMenuRole(Integer rid, Integer[] mids);

}
