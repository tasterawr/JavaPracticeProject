package org.inversion_of_control;

import java.lang.reflect.*;
import java.util.*;

public class Container {
    Map<String, Object> objects = new HashMap<>();
    Map<String, Method> methods = new HashMap<>();
    List<Class> configs;

    public Container(Class... classes) {
        configs = Arrays.asList(classes);
        refresh();
    }

    public void refresh() {
        objects.clear();
        methods.clear();
        try {
            for (Class cl : configs) {
                Method[] meths = cl.getDeclaredMethods();

                for (Method method : meths) {
                    if (method.isAnnotationPresent(Bean.class)) {
                        String name = method.getAnnotation(Bean.class).name();
                        if (name.equals(""))
                            name = method.getName();

                        if (method.isAnnotationPresent(Prototype.class)) {
                            objects.put(name, null);
                            methods.put(name, method);
                        } else {
                            objects.put(name, method.invoke(null));
                        }
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {

        }
    }

    public Object[] getMethodParameters(Method method){
        try {
            Type [] parameters = method.getGenericParameterTypes();
            Class[] paramClasses = method.getParameterTypes();

            if (parameters.length != 0) {
                Object[] actualParameters = new Object[parameters.length];
                for (int i = 0; i < parameters.length; i++) {
                    Type p = parameters[i];

                    if (Collection.class.isAssignableFrom(paramClasses[i])) {
                        Object list = new ArrayList<Object>();
                        Method add = Collection.class.getDeclaredMethod("add", Object.class);
                        Class<?> valueClass = (Class<?>) ((ParameterizedType) p).getActualTypeArguments()[0];

                        for (Object obj : objects.values()) {
                            if (obj != null && obj.getClass() == valueClass) {
                                add.invoke(list, obj);
                            }
                        }
                        for (Method meth : methods.values()) {
                            if (valueClass == meth.getReturnType()) {
                                add.invoke(list, meth.invoke(null));
                            }
                        }

                        actualParameters[i] = list;
                    } else if (Map.class.isAssignableFrom(p.getClass())) {
//                        Object map = new HashMap<>();
//                        Method put = Map.class.getDeclaredMethod("put", Object.class);
//                        ParameterizedType types = (ParameterizedType) map.getClass().getGenericSuperclass();
//                        Class<?> keyClass = (Class<?>) types.getActualTypeArguments()[0];
//                        Class<?> valueClass = (Class<?>) types.getActualTypeArguments()[1];

                        return new Object[0];
                    } else {
                        for (Object obj : objects.values()) {
                            if (obj != null && obj.getClass() == p){
                                actualParameters[i] = obj;
                                break;
                            }
                        }
                        for (Method meth : methods.values()) {
                            if (p == meth.getReturnType()) {
                                actualParameters[i] = meth.invoke(null);
                                break;
                            }
                        }
                    }
                }
                return actualParameters;
            }
        }catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println("aboba");
        }

        return new Object[0];
    }

    public <T> T getBean(String name, Class<T> cl) {
        T object = (T) objects.get(name);
        try {
            if (objects.get(name) == null) {
                Method method = methods.get(name);
                Object[] params = getMethodParameters(method);
                if (params.length == 0)
                    object = (T)method.invoke(null);
                else
                    object = (T)method.invoke(null, params);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {

        }
        return object;
    }
}
