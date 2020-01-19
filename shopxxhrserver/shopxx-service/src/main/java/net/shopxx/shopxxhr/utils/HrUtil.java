package net.shopxx.shopxxhr.utils;

import net.shopxx.shopxxhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtil {

    public static Hr getCurrentHr() {
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
