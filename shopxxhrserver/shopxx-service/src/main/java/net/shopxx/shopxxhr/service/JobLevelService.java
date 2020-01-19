package net.shopxx.shopxxhr.service;

import net.shopxx.shopxxhr.model.JobLevel;

import java.util.List;

public interface JobLevelService {

    List<JobLevel> getAllJobLevels();

    JobLevel saveOrUpdateJobLevel(JobLevel jobLevel);

    void deleteJobLevelById(Integer id);

    JobLevel findOne(JobLevel jobLevel);

    void deleteJobLevelsByIds(Integer[] ids);

}
