package club.itbus.fsm.component;

import com.google.common.base.Objects;
import lombok.Data;

import java.io.Serializable;

/**
 * Desc:
 * Mail: hehaiyangwork@qq.com
 * Date: 2016/11/17
 */
@Data
public class Operation implements Serializable {
    private static final long serialVersionUID = 8295625045069834204L;
    private final Integer value;
    private final String operator;
    private final String action;

    public Operation(Integer value, String operator, String action) {
        this.value = value;
        this.operator = operator;
        this.action = action;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(!(o instanceof Operation)) {
            return false;
        } else {
            Operation that = (Operation)o;
            return Objects.equal(value, Integer.valueOf(that.value));
        }
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.value});
    }

}

