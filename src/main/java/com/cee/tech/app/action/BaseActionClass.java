package com.cee.tech.app.action;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class BaseActionClass extends HttpServlet {
    public  void serializeForm(Object bean, Map<String, ?> requestMap){

        try {
            BeanUtilsBean beanUtilsBean = new BeanUtilsBean(new ConvertUtilsBean() {
                @Override
                public Object convert(String value, Class clazz) {
                    if (clazz.isEnum()) {
                        return Enum.valueOf(clazz, value);
                    } else if (clazz == LocalDate.class) {
                        // web forms return the date in the form
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        return LocalDate.parse(value, formatter);
                    } else {
                        return super.convert(value, clazz);
                    }
                }
            });
            ConvertUtils.register(new BigDecimalConverter(), BigDecimal.class);
            beanUtilsBean.populate(bean, requestMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("Serialization Error" + e);
        }

    }


    public void renderPage(HttpServletRequest req, HttpServletResponse res, String content) throws ServletException, IOException {
        req.setAttribute("content", content);

        RequestDispatcher dispatcher = req.getRequestDispatcher("./app/index.jsp");
        dispatcher.forward(req, res);
    }

    public  void renderAdminPage(HttpServletRequest req, HttpServletResponse res, String content) throws ServletException, IOException {
        req.setAttribute("adminContent", content);

        RequestDispatcher dispatcher = req.getRequestDispatcher("./app/adminIndex.jsp");
        dispatcher.forward(req, res);
    }
}
