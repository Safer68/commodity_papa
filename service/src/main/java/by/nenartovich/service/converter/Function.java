package by.nenartovich.service.converter;

public interface Function<T, O> {
    T apply(O o);

    O apply(O o, T t);
}
