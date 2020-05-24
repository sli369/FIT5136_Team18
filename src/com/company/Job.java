package com.company;

public class Job {
    private String jobName;
    private String jobDes;

    public Job(String jobName, String jobDes) {
        this.jobName = jobName;
        this.jobDes = jobDes;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDes() {
        return jobDes;
    }

    public void setJobDes(String jobDes) {
        this.jobDes = jobDes;
    }
}
