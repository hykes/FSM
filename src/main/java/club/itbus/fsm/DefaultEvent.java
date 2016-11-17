package club.itbus.fsm;

import club.itbus.fsm.component.Operation;

/**
 * Desc: 订单事件
 * Mail: hehaiyangwork@qq.com
 * Date: 2016/11/17
 */
public enum DefaultEvent {

    PAY(1, "buyer", "pay"),

    CONFIRM(2, "buyer", "confirm"),

    COMMENT(3, "buyer", "comment");

    private final Integer value;

    private final String action;

    private final String operator;

    DefaultEvent(Integer value, String operator,  String action) {
        this.value = value;
        this.operator = operator;
        this.action = action;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getOperator(){
        return this.operator;
    }

    public Operation toOrderOperation() {
        return new Operation(this.value, this.operator, this.action);
    }

}
