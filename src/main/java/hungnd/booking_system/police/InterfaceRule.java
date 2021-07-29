package hungnd.booking_system.police;

import hungnd.booking_system.exception.CommonException;

public interface InterfaceRule<T>{
    void verify(T t) throws Exception;
}
