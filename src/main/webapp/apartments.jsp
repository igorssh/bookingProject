<%@ page import="java.io.*,java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksej_home
  Date: 2015.07.27.
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <!-- Bootstrap -->
  <jsp:include page="includes/header.jsp" />

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
    <jsp:include page="includes/menu.jsp" />
  </div>

  <!-- Jumbotron -->
  <p id="pete"></p>

  <!-- Site footer -->
  <%-- <footer class="footer">
      <p>© Company 2014</p>
    </footer> --%>
  <jsp:include page="includes/footer.jsp" />
</div>



<jsp:include page="includes/scripts.jsp" />
</body>
</html>
