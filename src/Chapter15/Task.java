package Chapter15;
@FunctionalInterface
public interface Task<T>{
    T call();
}
