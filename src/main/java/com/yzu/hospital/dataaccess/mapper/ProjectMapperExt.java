package com.yzu.hospital.dataaccess.mapper;

import com.yzu.hospital.dataaccess.mapper.gen.ProjectMapper;
import com.yzu.hospital.dataaccess.model.ProjectExt;

public interface ProjectMapperExt extends ProjectMapper {
    ProjectExt getProjectByID(int projectExtID);

    int insertProject(ProjectExt projectExt);
}