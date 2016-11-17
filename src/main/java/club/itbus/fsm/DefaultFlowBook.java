package club.itbus.fsm;

import club.itbus.fsm.component.Flow;

/**
 * Desc: 定制流程
 * Mail: hehaiyangwork@qq.com
 * Date: 2016/11/9
 */
public class DefaultFlowBook {

    public static final Flow defaultFlow = new Flow("defaultFlow") {
        protected void configure() {

            this.addTransition(DefaultStatus.NOT_PAID.getValue(), DefaultEvent.PAY.toOrderOperation(), DefaultStatus.PAID.getValue());
            this.addTransition(DefaultStatus.PAID.getValue(), DefaultEvent.CONFIRM.toOrderOperation(), DefaultStatus.CONFIRMED.getValue());
            this.addTransition(DefaultStatus.CONFIRMED.getValue(), DefaultEvent.COMMENT.toOrderOperation(), DefaultStatus.SETTLED.getValue());

        }
    };

    public static final Flow defaultFlow2 = new Flow("defaultFlow2") {
        protected void configure() {

        }
    };

}
