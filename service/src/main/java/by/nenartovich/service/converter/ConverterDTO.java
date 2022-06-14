package by.nenartovich.service.converter;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public interface ConverterDTO<T, O> extends Function<T, O> {
    default T convert(O input) {
        T output = null;
        if (input != null) {
            output = this.apply(input);
        }
        return output;
    }

    default List<T> convert(List<O> input) {
        List<T> output = new ArrayList<T>();
        if (input != null) {
            output = input.stream().map(this::apply).collect(toList());
        }
        return output;
    }

    default O convert(O output, T input) {
        if (input != null) {
            output = this.apply(output, input);
        }
        return output;
    }
}
