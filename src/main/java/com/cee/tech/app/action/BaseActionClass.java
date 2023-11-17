package com.cee.tech.app.action;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class BaseActionClass extends HttpServlet {
    public  void serializeForm(Object bean, Map<String, ? extends Object> requestMap){
        try {
            BeanUtils.populate(bean, requestMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
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
