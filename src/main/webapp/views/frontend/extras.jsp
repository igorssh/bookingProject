<%@ page import="lv.javaguru.java2.core.domain.frontend.Extra" %>
<%@ page import="java.util.*" %>
<%@ page import="lv.javaguru.java2.core.domain.frontend.ExtrasObject" %>

<%--
  Created by IntelliJ IDEA.
  User: Aleksej_home
  Date: 2015.07.27.
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  ExtrasObject extrasObject = (ExtrasObject)request.getAttribute("model");
  Extra extra = extrasObject.getExtra();
  List<Extra> extrasList = extrasObject.getExtras();
%>

<html>
<head>
  <!-- Bootstrap -->
  <jsp:include page="../../includes/header.jsp" >
    <jsp:param name="pathx" value="" />
  </jsp:include>

  <link href="http://getbootstrap.com/examples/carousel/carousel.css" rel="stylesheet">
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <title>Booking home</title>
</head>
<body>
<div class="container">

  <!-- The justified navigation menu is meant for single line per list item.
       Multiple lines will require custom code not provided by Bootstrap. -->
  <div class="masthead">
    <jsp:include page="../../includes/menu.jsp" />
  </div>

  <!-- Jumbotron -->

  <!-- Example row of columns -->
  <div class="row">
    <div class="col-lg-9">
     <div class="row">

    <div class="col-lg-offset-1 col-lg-10">
      <p><img class="img-thumbnail" src="<%= extra.getPic() %>" > </p>
    </div>
    <div class="col-lg-1"> </div>

  </div>
  <div class="row">

    <div class="col-lg-offset-1 col-lg-10">
      <h2><%= extra.getLabel() %></h2>
      <p><%= extra.getDesc() %> </p>
      <p> Special offer: <%= extra.getCost() %><span class="glyphicon glyphicon-euro"></span> </p>
    </div>
     </div>
    </div>
     <div class="col-lg-3">
       <div class="panel panel-default">
         <div class="panel-heading">Extras</div>
         <div class="panel-body">
           <ul class="list-unstyled">
             <%
               for (Extra extras : extrasList) {
             %>
             <a  href="extras.jsp?id=<%= extras.getId() %>"><li> <%= extras.getLabel() %> </li></a>
             <%
             } %>
           </ul>
           </div>
       </div>
     </div>

  </div>

  <!-- Site footer -->
  <%-- <footer class="footer">
      <p>© Company 2014</p>
    </footer> --%>
  <jsp:include page="../../includes/footer.jsp" />
</div>



<jsp:include page="../../includes/scripts.jsp" >
  <jsp:param name="pathx" value="" />
</jsp:include>
</body>
</html>
