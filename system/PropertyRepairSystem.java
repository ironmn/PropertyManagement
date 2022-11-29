package system;

import customer.Customer;
import incident.Incident;
import incident.IncidentJob;
import incident.IncidentMessage;
import lombok.extern.java.Log;
import util.Logger;
import worker.MaintenanceRecord;
import worker.MaintenanceState;
import worker.RepairWorker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @description 系统类，用于负责处理请求，自动调度等
 *              在这个系统类的设计中，需要使用监听模式。对调度作业的finished属性变量进行实时监听，如果发生变化，就给用户发送通知
 */

public class PropertyRepairSystem {
    //待维修作业列表
    private static List<IncidentJob> incidentJobList = new ArrayList<>();
    private static List<RepairWorker> workers = new ArrayList<>();//维修工人列表
    private static List<Yardman> yardmen = new ArrayList<>();//调度员列表
    private static List<MaintenanceRecord> maintenanceRecords = new ArrayList<>();//维修记录列表
    public static void handleCustomerReport(IncidentMessage message){
        incidentJobList.add(new IncidentJob(message));//添加作业

    }

    //由调度员调用这个方法，对客户的故障报告进行处理
    public static void dealCustomerReport() {
        for(IncidentJob incidentJob : incidentJobList){
            boolean arranged = false;
            if(incidentJob.status == MaintenanceState.NOT_DO){//如果当前的这个任务没有做，那么就安排空闲的工人去做这件事
                Logger.INFO("任务"+incidentJob.jobId+"需要处理，正在查找能够完成任务的工人");
                //优先满足专业对口
                for(RepairWorker worker : workers){
                    if(worker.expertJobType.contains(incidentJob.incidentMessage.incidentType) && !worker.busy){
                        arranged = true;
                        Logger.INFO("已找到工人"+worker.id+",正在安排对应的工人前往维修");
                        incidentJob.status = MaintenanceState.DEALING;//设置处理状态
                        worker.work(incidentJob);
                        break;
                    }
                }
                if(arranged) continue;
                //如果没有专业对口的条件，那么优先满足有工人去做。
                for(RepairWorker worker : workers){
                    if(!worker.busy){//如果当前这个工人处于空闲状态，就安排这个工人去处理这项任务
                        arranged = true;
                        Logger.INFO("已找到工人"+worker.id+",正在安排对应的工人前往维修");
                        incidentJob.status = MaintenanceState.DEALING;//设置处理状态
                        worker.work(incidentJob);
                        break;
                    }
                }
                if(!arranged) Logger.INFO("目前没有空闲的工人能够完成该项作业，请过一段时间后再尝试");
            }
            else Logger.INFO("任务"+incidentJob.jobId+"正在处理中，无需安排新的工人进行作业");
        }
        Logger.INFO("暂无需要去调度的任务");
    }
}
