<%--
  Created by IntelliJ IDEA.
  User: nina
  Date: 23.07.15
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!-- Bootstrap -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="../../favicon.ico">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="justified-nav.css" rel="stylesheet">

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
    <h3 class="text-muted">Project name</h3>
    <nav>
      <ul class="nav nav-justified">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">Downloads</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
    </nav>
  </div>

  <!-- Jumbotron -->
  <div class="jumbotron">
    <h1>Marketing stuff!</h1>
    <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
    <p><a class="btn btn-lg btn-success" href="#" role="button">Get started today</a></p>
  </div>

  <!-- Example row of columns -->
  <div class="row">
    <div class="col-lg-4">
      <h2>Safari bug warning!</h2>
      <p class="text-danger">As of v8.0, Safari exhibits a bug in which resizing your browser horizontally causes rendering errors in the justified nav that are cleared upon refreshing.</p>
      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
      <p><a class="btn btn-primary" href="#" role="button">View details »</a></p>
    </div>
    <div class="col-lg-4">
      <h2>Heading</h2>
      <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
      <p><a class="btn btn-primary" href="#" role="button">View details »</a></p>
    </div>
    <div class="col-lg-4">
      <h2>Heading</h2>
      <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa.</p>
      <p><a class="btn btn-primary" href="#" role="button">View details »</a></p>
    </div>
  </div>

  <!-- Site footer -->
  <footer class="footer">
    <p>© Company 2014</p>
  </footer>

</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
