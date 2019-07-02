package org.darker.mapoperations;

import java.util.Map;
import java.util.function.Function;

public class MapOperations {

    public static <T> T get(Map<String, Object> map, String key)
    {
        return (T) map.get(key);
    }

    public static <T> T getIn(Map<String, Object> map, String... keys)
    {
        Object ref = map;
        for(String key : keys)
        {
            ref = ((Map) ref).get(key);
        }

        return (T) ref;
    }

	public static Map<String, Object> mapKeys(Map<String, Object> map, Function<String, String> keyMapper)
    {
        return map.entrySet().stream().collect(toMap(entry -> keyMapper.apply(entry.getKey()), Map.Entry::getValue));
    }

    public static <T> void update(Map<String, T> map, String key, Function<T, T> fn)
    {
        map.put(key, fn.apply(map.get(key)));
    }
}
