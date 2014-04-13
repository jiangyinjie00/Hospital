package com.yzu.hospital.service;

import com.yzu.hospital.dataaccess.model.ProjectExt;

public interface ProjectService {
    ProjectExt getProjectByID(int projectExtID);

    int insertProject(ProjectExt projectExt);
}