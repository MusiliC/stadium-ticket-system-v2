<%@ page import = "com.cee.tech.view.toolbar.Navbar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "com.cee.tech.view.toolbar.Footer" %>
<%@ page import = "com.cee.tech.utils.CookieUtils" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
                <html>

                <head>
                <jsp:include page="./app/css/AppCss.jsp">
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
             
               <div class="mainContainer">
                                   <div class="heroSection">
                                     <div class="sectionTitle">
                                       <p>
                                         Experience The <br />
                                         <span class="blueText">Thrill of Live Sports </span> <br />
                                         Like Never Before
                                       </p>
                                     </div>
                                     <div>
                                       <p class="summary">
                                         Experience the ultimate in live entertainment with our seamless
                                         ticketing system. Get ready to secure your spot at the heart of the
                                         action
                                       </p>
                                     </div>
                                     <div class="homeButtons">
                                         <a href="./tickets" class="homeOutlineButton" >  My Tickets</a>
                                         <a href="./fixtures" class="homeNormalButton">Upcoming Fixtures</a>
                                     </div>
                                   </div>
                                   <div class="heroImage">
                                     <div class="imageContainer">
                                       <img class="bgImage" src="https://images.unsplash.com/photo-1522778526097-ce0a22ceb253?auto=format&fit=crop&q=80&w=1470&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="stadium">
                                     </div>
                                   </div>
                                 </div>
             
           <%--    ${footerMenuContent.footerMenu} --%>
            <%--   <%= new Footer().footerMenu() %> --%>


    </body>
                </html>