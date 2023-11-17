<%-- This is a JSP comment
<%@ page import="com.cee.tech.utils.Calculator" %>

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

<h2> <%= application.getInitParameter("AppName") %></h2>

<%--
<%!
  int hundred = 100;
  int thousand = 1000;

  int sum = hundred + thousand;

  int addSum(int v1, int v2){
    return v1 +v2;

  }


   int justAnotherNumber = new Calculator().doSum(1,1);
  %>


--%>
<%=
  application.getAttribute("JSP")
%>

  <br/>

    <h2>Testing jsp</h2>

 
</div>
</body>
</html>

--%>