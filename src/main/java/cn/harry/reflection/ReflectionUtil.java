package cn.harry.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * this Util is used to wrapper reflection.
 */
public class ReflectionUtil {


    /**
     *
     * @param clazz
     * @param methodName
     * @param args
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static <T> T callPrivateMethod(Class clazz, String methodName, Object... args)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        Method[] methods = clazz.getDeclaredMethods();
        Method invokeMethod = null;
        for(Method method : methods){
            if(method.getName().contains(methodName)){
                invokeMethod = method;
            }
        }

        if(invokeMethod == null){
            System.out.println("调用的方法不存在");
            return null;
        }
        Type T = invokeMethod.getGenericReturnType();
        invokeMethod.setAccessible(true);
        T result = (T)invokeMethod.invoke(clazz.newInstance(),args);
        return result;
    }


}
