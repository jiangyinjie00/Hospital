package com.yzu.hospital.dataaccess.model;

import com.yzu.hospital.dataaccess.model.gen.PatientProject;

public class PatientProjectExt extends PatientProject {

    private ProjectExt projectExt;

    public ProjectExt getProjectExt() {
        return projectExt;
    }

    public void setProjectExt(ProjectExt projectExt) {
        this.projectExt = projectExt;
    }
}