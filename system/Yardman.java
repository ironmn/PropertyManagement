package system;

/**
 * @Description 调度员的类，用于调度客户提交的维修请求
 */
public class Yardman extends Person {
    private static long YARDMAN_NUM = 0;
    //构造函数
    public Yardman(String name){
        super(YARDMAN_NUM++,name);
    }
    //调度员对任务进行调度
    public void dispatch(){
        PropertyRepairSystem.dealCustomerReport();
    }
}
