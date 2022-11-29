package worker;

import incident.Incident;
import incident.IncidentJob;
import lombok.extern.java.Log;
import system.Person;
import util.Logger;

import java.util.List;
import java.util.Set;


public class RepairWorker extends Person {
    private static long WORKER_NUM = 0;
    public RepairWorker(String name){
        super(WORKER_NUM++,name);
    }

    public Set<Incident> expertJobType;//擅长的维修类型
    public boolean busy;//是否处于忙碌状态
    public RepairWorker(String name,Set<Incident> incidentList){
        super(WORKER_NUM++,name);
        this.expertJobType = incidentList;
    }
    public void work(IncidentJob incidentJob) {
        Logger.INFO("工人"+super.id+"正在进行"+incidentJob.jobId+"任务");
        this.busy = true;//首先将是否处于忙碌状态的变量置为true
        if(!expertJobType.contains(incidentJob.incidentMessage.incidentType)){//如果没有自己擅长的工种，就直接报错
            incidentJob.status = MaintenanceState.NOT_DO;//没有自己擅长的工作，返回错误信息
            Logger.ERROR("没有自己擅长的工种，请后续重新安排调度");
            return;
        }
        if(incidentJob.status == MaintenanceState.FINISHED){
            Logger.INFO("任务已经完成，无需作业，返回信息");
        }
    }
}
