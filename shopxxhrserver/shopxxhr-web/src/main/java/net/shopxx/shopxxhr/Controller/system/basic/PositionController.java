package net.shopxx.shopxxhr.Controller.system.basic;

import net.shopxx.shopxxhr.bean.RespBean;
import net.shopxx.shopxxhr.model.Position;
import net.shopxx.shopxxhr.exception.ExceptionEnum;
import net.shopxx.shopxxhr.exception.HrException;
import net.shopxx.shopxxhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean saveOrUpdatePosition(@RequestBody Position position) {
        Position result = positionService.saveOrUpdatePosition(position);
        if (result != null) {
            return RespBean.ok("添加(更新)职位成功！");
        }
        return RespBean.ofError("添加(更新)职位失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable Integer id) {
        try {
            positionService.deletePositionById(id);
        } catch (Exception e) {
            throw new HrException(ExceptionEnum.POSITION_DELETE_FAILED);
        }
        return RespBean.ok("删除职位成功！");
    }

    @DeleteMapping("/")
    public RespBean deletePositions(Integer[] ids) {
        try {
            positionService.deletePositionsByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HrException(ExceptionEnum.POSITION_DELETE_FAILED);
        }
        return RespBean.ok("删除职位成功！");
    }

}