package net.shopxx.shopxxhr.controller.system.basic;

import net.shopxx.shopxxhr.bean.RespBean;
import net.shopxx.shopxxhr.model.JobLevel;
import net.shopxx.shopxxhr.exception.ExceptionEnum;
import net.shopxx.shopxxhr.exception.HrException;
import net.shopxx.shopxxhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean saveOrUpdateJobLevel(@RequestBody JobLevel jobLevel) {
        JobLevel result = jobLevelService.saveOrUpdateJobLevel(jobLevel);
        if (result != null) {
            return RespBean.ok("添加(更新)职称成功！");
        }
        return RespBean.ofError("添加(更新)职称失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        try {
            jobLevelService.deleteJobLevelById(id);
        } catch (Exception e) {
            throw new HrException(ExceptionEnum.JOBLEVEL_DELETE_FAILED);
        }
        return RespBean.ok("删除职称成功！");
    }

    @DeleteMapping("/")
    public RespBean deletJobLevels(Integer[] ids) {
        try {
            jobLevelService.deleteJobLevelsByIds(ids);
        } catch (Exception e) {
            throw new HrException(ExceptionEnum.JOBLEVEL_DELETE_FAILED);
        }
        return RespBean.ok("删除职称成功！");
    }

}
