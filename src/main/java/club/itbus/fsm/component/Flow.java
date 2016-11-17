package club.itbus.fsm.component;

import com.google.common.base.Objects;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * Desc:
 * Mail: hehaiyangwork@qq.com
 * Date: 2016/11/17
 */
@Slf4j
public abstract class Flow {

    private final String name;
    private final Table<Integer, Operation, Integer> FSM;

    public Flow(String name) {
        this.name = name;
        this.FSM = HashBasedTable.create();
        this.configure();
    }

    protected void addTransition(Integer source, Operation orderOperation, Integer target) {
        if(this.FSM.contains(source, orderOperation)) {
            Integer exist = (Integer)this.FSM.get(source, orderOperation);
            if(Objects.equal(exist, target)) {
                log.info("state transition(source={}, operation={}, target={}) has been registered, skip", new Object[]{source, orderOperation, target});
                return;
            }

            log.warn("state transition(source={}, operation={}, target={}) is OVERRIDING old transition(source={}, operation={}, target={})", new Object[]{source, orderOperation, target, source, orderOperation, exist});
        }

        this.FSM.put(source, orderOperation, target);
    }

    public Integer target(Integer source, Operation orderOperation) {
        if(!this.FSM.contains(source, orderOperation)) {
            log.error("{} is not available on status({})", orderOperation, source);
            throw new UnsupportedOperationException("operation not allowed on this order status");
        } else {
            return (Integer)this.FSM.get(source, orderOperation);
        }
    }

    public boolean operationAllowed(Integer source, Operation orderOperation) {
        return this.FSM.contains(source, orderOperation);
    }

    public Set<Operation> availableOperations(Integer source) {
        return this.FSM.row(source).keySet();
    }

    protected abstract void configure();

    public String getName() {
        return this.name;
    }
}
