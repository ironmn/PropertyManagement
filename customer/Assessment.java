package customer;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @description 用户对本次维修的评价
 */
@Data
public class Assessment implements Observer {
    public String id;//评价的ID
    public double satisfiedDegree;//满意度(0-5分)
    public double responseTimeliness;//响应及时度(0-5分)
    public String suggestion;//建议


    @Override
    public void update(Observable o, Object arg) {

    }
}
