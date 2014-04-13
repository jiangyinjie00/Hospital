package com.yzu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzu.hospital.dataaccess.mapper.ProjectMapperExt;
import com.yzu.hospital.dataaccess.model.ProjectExt;
import com.yzu.hospital.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapperExt projectMapperExt;

    @Override
    public ProjectExt getProjectByID(int projectExtID) {
        return projectMapperExt.getProjectByID(projectExtID);
    }

    @Override
    public int insertProject(ProjectExt projectExt) {
        return projectMapperExt.insertProject(projectExt);
    }
}