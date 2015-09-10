<%@ page import="java.util.Map" %>


<%--
  Created by IntelliJ IDEA.
  User: Aleksej_home
  Date: 2015.09.08.
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../../../includes/header.jsp" >
    <jsp:param name="pathx" value="../" />
    </jsp:include>
    <title>Generators</title>
</head>
<body>
<%
    Map<String, Object> mp = (Map)request.getAttribute("model");
    String cls = "";
    String path = "";
   if ( mp  != null) {

        cls = (String) mp.get("clazz");
        path = (String) mp.get("pathc");
   }
%>
   <h1>Generator</h1>
   <hr>
   <div class="row">
       <div class="col-md-offset-1 col-md-4">
           <form  action="../java2/generator"  method="post" >
           <div class="form-group">
               <label class="control-label col-sm-2" for="aps">Class:</label>
               <div class="col-sm-10">
                   <p><input name="clazz" type="text" class="form-control" id="aps" placeholder="Class name to generate"/></p>
               </div>
           </div>
               <div class="form-group">
                   <label class="control-label col-sm-2" for="aps2">Dist_path:</label>
                   <div class="col-sm-10">
                       <p><input name="pathc" type="text" class="form-control" id="aps2" placeholder="Class path to generate"/></p>
                   </div>
               </div>
                 <button type="submit" class="btn btn-primary">Generate</button>
           </form>
       </div>
       <div class="col-md-7">
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

   </div>

<jsp:include page="../../../includes/scripts.jsp" >
  <jsp:param name="pathx" value="../" />
</jsp:include>
</body>
</html>
