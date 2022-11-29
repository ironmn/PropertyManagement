package customer;

import incident.Incident;
import incident.IncidentMessage;
import system.Person;
import system.PropertyRepairSystem;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Customer extends Person {
    private static long CUSTOMER_NUM = 0;
    public Customer(String name){
        super(CUSTOMER_NUM++,name);
    }

    /**
     * @description 用户上报信息，
     */
    public void reportIncident(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入故障的类型。1-断电  2-下水道阻塞  3-电梯故障");
        int typeNum = scanner.nextInt();
        while (typeNum > 3 || typeNum < 1){
            System.out.println("类型有误，请重新输入");
            typeNum = scanner.nextInt();
        }
        String description;
        System.out.println("请简要输入故障的描述（200字以内，输入换行符表示结束）");
        description = scanner.nextLine();
        System.out.println("请输入上报的方式：1-电话  2-微信");
        int notifyMethodNum = scanner.nextInt();
        while(notifyMethodNum < 1 || notifyMethodNum > 2){
            System.out.println("类型有误，请重新输入");
            notifyMethodNum = scanner.nextInt();
        }
        IncidentMessage message = new IncidentMessage(Incident.values()[typeNum - 1],this,
                LocalDateTime.now(),description,NotifyMethod.values()[notifyMethodNum - 1]);
        PropertyRepairSystem.handleCustomerReport(message);
    }

}
