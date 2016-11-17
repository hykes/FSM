package club.itbus.fsm;

import club.itbus.fsm.component.Flow;
import club.itbus.fsm.component.FlowPicker;
import club.itbus.fsm.component.Operation;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Desc:
 * Mail: hehaiyangwork@qq.com
 * Date: 2016/11/17
 */
public class FlowTest {


    public static void main(String[] args){
        FlowPicker flowPicker = new DefaultFlowPicker();

        Map<String, Object> map = Maps.newHashMap();
        map.put("type", 1);
        Flow flow = flowPicker.pick(map);
        Integer status = DefaultStatus.NOT_PAID.getValue();
        Operation operation = DefaultEvent.PAY.toOrderOperation();
        Integer targetStatus = flow.target(status, operation);
        System.out.println(targetStatus);
    }

}
