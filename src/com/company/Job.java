package com.company;

public class Job {
    private String jobName;
    private int number;

    public Job(String jobName, int number) {
        this.jobName = jobName;
        this.number = number;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void showJob(){
        System.out.println("   " + number + " " + jobName + "s");
    }
}
