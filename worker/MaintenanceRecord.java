package worker;



import incident.IncidentJob;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @description 维修记录的类型
 */

public class MaintenanceRecord {
    private static long RECORD_NUM = 0;
    public long id;//维修记录的ID
    public RepairWorker worker;//负责这项维修记录的工人
    public IncidentJob job;//本次维修记录对应的任务
    public LocalDateTime startTime;//维修记录的开始时间
    public LocalDateTime endTime;//维修记录的结束时间
    public LocalTime cost;//本次维修花费的时间
    public boolean finished;//本次维修是否已经完成
}
