package hungnd.booking_system.police;

import hungnd.booking_system.model.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRuleImpl extends AbstractRule implements UserRule {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void verify(UserRequest userRequest) throws Exception {
        userRequest.setUserPassword(
                passwordEncoder.encode(userRequest.getUserPassword()));
    }
}
