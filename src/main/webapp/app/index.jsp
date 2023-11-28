<%@ page import = "com.cee.tech.view.toolbar.Navbar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "com.cee.tech.view.toolbar.Footer" %>
<%@ page import = "com.cee.tech.utils.CookieUtils" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
                <html>

                <head>
                <jsp:include page="./css/AppCss.jsp">
                <jsp:param name="buttonColor" value="rgb(0, 53, 133)"/>
                </jsp:include>
                </head>
                <body>

 <%-- Accessing cookie set during user login --%>

<%
    Cookie userCookie = CookieUtils.getCookieByName(request, "username");
    String accessCookie = null;
    String firstLetter = null;

    if (userCookie != null) {
        accessCookie = userCookie.getValue();
        firstLetter = accessCookie.substring(0, 1).toUpperCase();
    } else {
        System.out.println("Cookie not found");
    }
%>

 <jsp:useBean id="navbarBean" class="com.cee.tech.usebean.NavbarBean"/>
 <jsp:useBean id="contentHtmlRender" class="com.cee.tech.usebean.ContentBean" scope="request"/>
 <jsp:useBean id="footerMenuContent" class="com.cee.tech.usebean.FooterBean" />
 <jsp:setProperty name="contentHtmlRender" property="content" value='${requestScope.content}' />


 <%  navbarBean.generateMenu(firstLetter); %>
 <% footerMenuContent.generateFooterMenu(); %>

              <%-- <jsp:getProperty name="navbarBean" property="menu" /> --%>
               ${navbarBean.menu}
              <%--  <jsp:getProperty name="contentHtmlRender" property="content" /> --%>
              ${contentHtmlRender.content}
             <%--  <jsp:getProperty name="footerMenuContent" property="footerMenu" /> --%>
           <%--    ${footerMenuContent.footerMenu} --%>
            <%--   <%= new Footer().footerMenu() %> --%>


    </body>
                </html>