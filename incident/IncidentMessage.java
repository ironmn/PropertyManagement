package incident;

import customer.Customer;
import customer.NotifyMethod;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * @describe 由用户上报产生的故障信息，对任务完成情况进行实时监听
 * @// TODO: 2022/11/27  这个类可以直接抽象出去，作为用户提交的请求参数 
 */
@Data
public class IncidentMessage {
    private static long MESSAGE_NUM = 0;
    public long msgId;  //故障信息的ID
    public Incident incidentType;//故障类型
    public Customer customer;//上报这个故障类型的用户
    public LocalDateTime date;//故障产生的日期
    public String description;//故障描述信息
    public NotifyMethod method;
    public boolean deal;//是否正在处理

    public IncidentMessage(Incident type,Customer customer,LocalDateTime date,String description,NotifyMethod method){
        msgId = MESSAGE_NUM++;
        this.incidentType = type;
        this.customer = customer;
        this.description = description;
        this.deal = false;
        this.date = date;
        this.method = method;
    }
}
