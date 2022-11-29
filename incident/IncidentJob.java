package incident;

import customer.NotifyMethod;
import util.Generator;
import worker.MaintenanceState;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Observable;

/**
 * @describe 作为调度任务的生成类。这里使用监听模式，让IncidentJob实现Java自带的Observable抽象类
 */
public class IncidentJob extends Observable {
    public static long JOB_ID = 0;
    public long jobId;
    public IncidentMessage incidentMessage;
    public LocalTime expectedCost;//预计完成时间
    public LocalTime actualCost;//实际完成时间
    public MaintenanceState status;//报修任务完成状态

    public IncidentJob(IncidentMessage message){
        this.jobId = JOB_ID++;
        this.incidentMessage = message;
        this.expectedCost = Generator.genRandomTimeCost();//生成随机的任务预计时间
        this.actualCost = LocalTime.of(0,0,0);
        status = MaintenanceState.NOT_DO;
    }

    public IncidentJob(IncidentMessage message,LocalTime expectedCost){
        this.jobId = JOB_ID++;
        this.incidentMessage = message;
        this.expectedCost = expectedCost;
        this.actualCost = LocalTime.of(0,0,0);
        status = MaintenanceState.NOT_DO;
    }
}
