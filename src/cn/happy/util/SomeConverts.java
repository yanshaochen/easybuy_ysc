package cn.happy.util;

import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;
import java.util.stream.Collectors;

/**
 * resultSet to generics
 * Created by master on 17-8-4.
 */
public class SomeConverts {

    public <T> List<T> ResultSetToGenerics(ResultSet rs, Class<T> clazz) throws Exception {
        //create list to return
        List<T> list = new ArrayList<>();
        //add RS column to resultColumns
        ResultSetMetaData rsmd = rs.getMetaData();
        List<String> resultColumns = new ArrayList<>();
        for (int i = 0; i < rsmd.getColumnCount(); i++) {
            resultColumns.add(rsmd.getColumnName(i + 1));
        }
        //get allMethods then add them to methodsList
        List<Method> methodsList = Arrays.asList(clazz.getDeclaredMethods());
        //get setMethodList from methodsList
        List<Method> setMethodList = methodsList
                .stream()
                .filter(method -> method.getName().substring(0, 1).equals("s"))
                .collect(Collectors.toList());
        //generate list
        while (rs.next()) {
            T o = clazz.newInstance();
            for (Method method : setMethodList) {
                for (String resultColumn : resultColumns) {
                    //the column has result,execute method
                    if (method.getName().toLowerCase().substring(3).equals(resultColumn)) {
                        switch (method.getParameterTypes()[0].getName()) {
                            case "java.lang.Long":
                                method.invoke(o, rs.getLong(resultColumn));
                                break;
                            case "java.lang.String":
                                method.invoke(o, rs.getString(resultColumn));
                                break;
                            case "java.lang.Double":
                                method.invoke(o, rs.getDouble(resultColumn));
                                break;
                            case "java.sql.Timestamp":
                                method.invoke(o, rs.getTimestamp(resultColumn));
                                break;
                        }
                        break;
                    }
                }
            }
            list.add(o);
        }
        return list;
    }

    public Map<String, String> FileItemToGenerics(List<FileItem> items, ServletContext servletContext) {
        Map<String, String> param = new HashMap<>();
        String fileName;
        String leftPath;
        for (FileItem item : items
                ) {
            //get form field and file field
            if (item.isFormField()) {
                try {
                    param.put(item.getFieldName(), item.getString("utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                fileName = String.valueOf(System.currentTimeMillis()) + item.getName().substring(item.getName().lastIndexOf("."));
                leftPath = servletContext.getRealPath("/images/");
                //upload empty or not
                if (item.getName() != null && !item.getName().equals("")) {
                    File file = new File(leftPath, fileName);
                    try {
                        item.write(file);
                        param.put(item.getFieldName(), fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else
                    param.put(item.getFieldName(), null);
            }
        }
        return param;
    }
}
