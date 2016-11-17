package club.itbus.fsm;

import com.google.common.base.Objects;

/**
 * Desc: 订单状态
 * Mail: hehaiyangwork@qq.com
 * Date: 2016/10/28
 */
public enum DefaultStatus {

    NOT_PAID(0),

    PAID(1),

    CONFIRMED(2),

    SETTLED(3);

    private final Integer value;

    DefaultStatus(Integer value) {
        this.value = value;
    }

    /**
     * 根据数值返回枚举状态
     * @param value
     * @return
     */
    public static DefaultStatus from(Integer value) {
        for (DefaultStatus status : DefaultStatus.values()) {
            if (Objects.equal(status.value, value)) {
                return status;
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

}
