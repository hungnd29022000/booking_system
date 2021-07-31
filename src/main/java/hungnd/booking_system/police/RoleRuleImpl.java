package hungnd.booking_system.police;

import hungnd.booking_system.model.request.RoleRequest;
import hungnd.booking_system.utils.DateTimeUtils;

public class RoleRuleImpl extends AbstractRule implements RoleRule{


    @Override
    public void verify(RoleRequest roleRequest) throws Exception {

        if(roleRequest.getRoleName().equalsIgnoreCase("basic")){
            roleRequest.setExp(null);
        }else{
            roleRequest.setExp(DateTimeUtils.generateTime(System.currentTimeMillis() + THREE_MONTH_MILLISECOND, pattern));
        }
    }
}
