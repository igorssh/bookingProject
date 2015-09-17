<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <jsp:param name="pathx" value="" />
    </jsp:include>
    <title>Generators</title>
</head>
<body>
<%
    Map<String, Object> mp = (Map)request.getAttribute("model");

    String cls = "";
    String path = "";
    String gh = "";
    int iter = 0;

    Map<String, String >  mps = (Map)mp.get("generationList");
    Map<String, Class >  ars = (Map)mp.get("domainList");
    Map<String, Class >  rezl = (Map)mp.get("domainList");
   if ( mp  != null) {

        cls = (String) mp.get("clazz");
        path = (String) mp.get("pathc");
      //Map<String, String >  mps = (Map)mp.get("generationList");
      // Map<String, Class >  ars = (Map)mp.get("domainList");
   }
%>
   <h1>Generator</h1>
   <hr>
   <div class="row">
       <div class="col-md-offset-1 col-md-4">

       <div class="col-md-5">
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
       <div class="col-md-5">
           <form   action="../java2/generator"   method="post" >
               <div class="form-group">
                   <label class="control-label col-sm-2" for="generics">Class:</label>
                   <div class="col-sm-10">
                       <P><select id="generics" name="generationList">
                           <option value="none">--Select--</option>
                           <% for (iter = 0; iter< mps.size(); iter++){ %>
                               <option value="<%= iter%>"><%= mps.get(iter) %></option>
                           <% } %>

                       </select></P>
                   </div>
               </div>
               <div class="form-group">
                   <label class="control-label col-sm-2" for="domains">Class:</label>
                   <div class="col-sm-10">
                       <P><select id="domains" name="domainList">
                           <option value="none">--Select--</option>
                           <% for (iter = 0; iter< ars.size(); iter++){ %>
                           <option value="<%= iter%>"><%= ars.get(iter).getSimpleName() %></option>
                           <% } %>
                       </select></P>
                   </div>
                   <input id="hparam" type="hidden" name="val" value="">
               <button type="submit" class="btn btn-primary">Generate</button>
                   </div>
               <div class="form-group">
                   <label class="control-label col-sm-2" for="aps">Class:</label>
                   <div class="col-sm-10">
                       <p><input name="clazz" type="text" class="form-control" id="aps" placeholder="Class name to generate"/></p>
                   </div>
               </div>
           </form>
       </div>


   </div>

<jsp:include page="../../../includes/scripts.jsp" >
  <jsp:param name="pathx" value="" />
</jsp:include>

</body>
</html>
