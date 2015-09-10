<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <!-- Bootstrap -->
  <jsp:include page="../../includes/header.jsp" >
    <jsp:param name="pathx" value="" />
  </jsp:include>
  
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <title>Booking contacts</title>
</head>
<body>
<div class="container">

  <!-- The justified navigation menu is meant for single line per list item.
       Multiple lines will require custom code not provided by Bootstrap. -->
  <div class="masthead">
    <jsp:include page="../../includes/menu.jsp" />
  </div>

  <div class="row">
    <div id="map-outer" class="col-md-12">
      <div id="address" class="col-md-4">
        <h2>Our Location</h2>
        <address>
          <strong>Mordor Apartments</strong><br>
          Lomonosova 1<br>
          Riga<br>
          Latvia<br>
          <abbr>Phone:</abbr> +371 222222222
        </address>
      </div>
      <div id="map-container" class="col-md-6"></div>

      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
      <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
      <script>

        function init_map() {
          var var_location = new google.maps.LatLng(56.9394866,24.1559832);

          var var_mapoptions = {
            center: var_location,
            zoom: 14
          };

          var var_marker = new google.maps.Marker({
            position: var_location,
            map: var_map,
            title:"Mordor Apartments"});

          var var_map = new google.maps.Map(document.getElementById("map-container"),
                  var_mapoptions);

          var_marker.setMap(var_map);

        }

        google.maps.event.addDomListener(window, 'load', init_map);

      </script>
    </div><!-- /map-outer -->
  </div> <!-- /row -->

  <div class="row">
    <form class="form-horizontal" name="commentform">
      <div class="form-group">
        <div class="col-md-4">
          <input type="text" class="form-control" id="first_name" name="first_name" placeholder="First Name"/>
        </div>
        <div class="col-md-4">
          <input type="text" class="form-control" id="last_name" name="last_name" placeholder="Last Name"/>
        </div>
        <div class="col-md-4 input-group">
          <span class="input-group-addon">@</span>
          <input type="email" class="form-control" id="email" name="email" placeholder="Email Address"/>
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-12">
          <textarea rows="6" class="form-control" id="comments" name="comments" placeholder="Your question or comment here"></textarea>
        </div>
      </div>
      <div class="form-group">
        <div class="col-md-6">
          <button type="submit" value="Submit" class="btn btn-warning pull-right">Send</button>
        </div>
      </div>
    </form>
  </div><!-- /row -->
  
  <jsp:include page="../../includes/footer.jsp" />
</div>

  <jsp:include page="../../includes/scripts.jsp" >
    <jsp:param name="pathx" value="" />
  </jsp:include>
</body>
</html>
<style>
  #map-outer {  height: 440px;
    padding: 20px;
    border: 2px solid #CCC;
    margin-bottom: 20px  }
  #map-container { height: 400px }
  @media all and (max-width: 991px) {
    #map-outer  { height: 650px }
  }
  .input-group[class*="col-"] {
    padding-right: 15px;
    padding-left: 15px;
  }
</style>