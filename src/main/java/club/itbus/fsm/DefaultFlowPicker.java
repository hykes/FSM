package club.itbus.fsm;

import club.itbus.fsm.component.Flow;
import club.itbus.fsm.component.FlowPicker;
import com.google.common.base.Optional;

import java.util.Map;

/**
 * Desc:
 * Mail: hehaiyangwork@qq.com
 * Date: 2016/11/17
 */
public class DefaultFlowPicker implements FlowPicker {

    public Flow pick(Map<String, Object> ceritia) {

        Integer orderType = 0;
        if(Optional.fromNullable(ceritia).isPresent()){
            if(Optional.fromNullable(ceritia.get("type")).isPresent()){
                orderType = (Integer) ceritia.get("type");
            }
        }

        switch(orderType) {
            case 1: return DefaultFlowBook.defaultFlow;
            case 2: return DefaultFlowBook.defaultFlow2;
            default: throw new IllegalArgumentException("unknown order type: " + orderType);
        }

    }
}

