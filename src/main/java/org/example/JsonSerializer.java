package org.example;

import org.annotation.Published;
import org.json.JSONObject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class JsonSerializer<T> {
    private final Set<Field> publishedFields = new HashSet<>();

    public JsonSerializer(Class<T> serializedClass) {
        for (Field field : ReflectionUtils.getAllFields(serializedClass)) {
            Published published = field.getAnnotation(Published.class);
            if (published != null) {
                publishedFields.add(field);
            }
        }
    }

    public JSONObject serialize(T o) {
        JSONObject result = new JSONObject();
        for (Field field : publishedFields) {
            Object obj;
            field.setAccessible(true);
            try {
                obj = field.get(o);
                result.put(field.getName(), obj.toString());
            } catch (IllegalAccessException ex) {
                System.out.println("Access error " + ex);
            } catch (IllegalArgumentException ex) {
                System.out.println("Access argument " + ex);
            }
        }
        return result;
    }
}
