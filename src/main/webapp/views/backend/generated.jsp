<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksej_home
  Date: 2015.09.17.
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Map<String, Object> mp = (Map)request.getAttribute("model");

  String cls = "";
  String path = "";
  if ( mp  != null) {

    cls = (String) mp.get("clazz");
    path = (String) mp.get("pathc");
    //Map<String, String >  mps = (Map)mp.get("generationList");
    // Map<String, Class >  ars = (Map)mp.get("domainList");
  }
%>
<html>
<head>
    <title>Result</title>
</head>
<body>
<div class="row">

      <ul>
        <li>Class:
          <%
            if ( cls != null ){  %>
          <%=cls %>
          <%     } %>


        </li>
        <li>Path:
          <%
            if (path != null ){  %>
          <%=path %>
          <%     } %></li>
      </ul>
</div>
   <p><a href="../java2/generator" >>>Back</a></p>
</body>
</html>
