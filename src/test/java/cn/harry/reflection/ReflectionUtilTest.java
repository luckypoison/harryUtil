package cn.harry.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtilTest {

    private String privateMethod(Integer arg1, List<String> arg2){
        String str = "私有方法被成功调用";
        return str;
    }

    public static void main(String[] args){
        try {
            String result = ReflectionUtil.callPrivateMethod(ReflectionUtilTest.class, "privateMethod", 2, new ArrayList<String>());
            System.out.println(result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
