package hungnd.booking_system.adapter;

public interface EntityAdapter<T, R> {
    public abstract R transform(T entity);
}

