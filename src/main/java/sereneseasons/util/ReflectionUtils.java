package sereneseasons.util;

import java.lang.reflect.Method;

public class ReflectionUtils {
    private ReflectionUtils() {
    }
    public static Method getMethod(String className, String methodName, Class<?>... params) {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, params);
            method.setAccessible(true);
            return method;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
