package hungnd.booking_system.police;

public interface InterfaceRule<T>{
    void verify(T t) throws Exception;
}
