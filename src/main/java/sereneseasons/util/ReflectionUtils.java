package sereneseasons.util;

import java.lang.reflect.Method;

public class ReflectionUtils {
    private ReflectionUtils() {
    }
    public static Method getMethod(String className, String methodName, Class<?>... params) {
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.getMethod(methodName, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
