<%-- This is a JSP comment --%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <style>
        body {
          font-family: Arial, sans-serif;
          text-align: center;
          height:90vh;
          display: flex;
          align-items: center;
          justify-content: center;
        }

        .login-container {
          background-color: #fff;
          width: 400px;
          margin: 50px auto;
          padding: 20px;
          border-radius: 5px;
          box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }

        h2 {
          color: rgb(1, 69, 171);
        }

        form {
          text-align: left;
        }

        input[type="text"],
        input[type="password"] {
          width: 95%;
          padding: 10px;
          margin: 10px 0;
          border: 1px solid #ccc;
          border-radius: 5px;
          background-color: rgb(232,240,254);
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
          border-color: rgb(238, 238, 238);
          outline: none;
        }

        input[type="submit"] {
          background-color: rgb(0, 53, 133);
          color: #fff;
          padding: 10px 20px;
          border: none;
          border-radius: 10px;
          cursor: pointer;
        }
        .regLink{
         display: flex;
         align-items: center;
          justify-content: space-between;
          padding: 15px 0px;
        }
      .regLink a{
        text-decoration: none;
        color: rgb(10, 79, 182);
        font-weight: 600;
    }
    </style>
</head>
<body>

<div class="login-container">

<h2> ${initParam.AppName}</h2>

<c:choose>
<c:when test='${sessionScope.LoginId ne null}' >
    <c:redirect url="./home"/>
</c:when>
<c:otherwise>

        <h2>Login</h2>

        <form action="./login" method="post">

            <jsp:useBean id="loginFormBean" class="com.cee.tech.usebean.LoginForm"/>
         <%--   Time to login:    <jsp:getProperty name="loginFormBean" property="timeToLogin" /> --%>
            <jsp:setProperty name="loginFormBean" property="usernamePlaceholder" value="Enter your username" />

            <br/>
            <br/>

            <label for="username">Username:</label>
            <input type="text" id="username" placeholder = " ${loginFormBean.usernamePlaceholder}" name="username" required/>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder = " ${loginFormBean.passwordPlaceholder}"  required>

            <div class="regLink">
                <input type="submit"/>
                <div><a href="./register">No account? Create</a></div>
            </div>

        </form>
    </div>
    </body>
    </html>
</c:otherwise>
</c:choose>
