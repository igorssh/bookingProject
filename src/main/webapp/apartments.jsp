<%@ page import="java.io.*,java.util.*" %>
<%@ page import="lv.javaguru.java2.core.domain.frontend.Hotel" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Hotel> hotels = (List<Hotel>)request.getAttribute("model");
%>
<html>
<head>
  <!-- Bootstrap -->
  <jsp:include page="includes/header.jsp" />

  <link href="fonts/americantext.css" rel="stylesheet">
  <link href="styles/bootstrap-slider.min.css" rel="stylesheet">

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
<jsp:include page="includes/scripts.jsp" />
<script src="js/bootstrap-slider.min.js"></script>

<div class="container">

  <!-- The justified navigation menu is meant for single line per list item.
       Multiple lines will require custom  id="apartment-list"  code not provided by Bootstrap. -->
  <div class="masthead">
    <jsp:include page="includes/menu.jsp" />
  </div>
<div class="row">
  <div class="col-lg-9">
    <table id="apartment-list" class="table table-hover">
      <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
      </thead>
      <tbody>
      <%
        for (Hotel hotel : hotels) {
      %>
       <input id="hld" type="hidden" value="<%= hotel.getLabel() %>">
      <tr>
        <td><a data-toggle="modal" data-target="#myModal" href="#">
          <img class="img-thumbnail" src="<%= hotel.getLabel() %>"> </a></td>
        <td><ul class="list-unstyled">
          <li><p>Adress: <%= hotel.getAddress() %></p> </li>
          <li><p>Rooms count: 50</p></li>
          <ul>
            <li><p>In use: 31</p></li>
            <li><p>Free: 19</p></li>
          </ul>
          <li><p>Average room price: ~500 eu</p></li>
        </ul></td>
        <td><table id="apartment-rooms-list">
              <tr>
                  <td><%= hotel.getDescription() %></td>
              </tr>
            <tr>
                <td><a  href="rooms.jsp?id=<%= hotel.getId()%>" >
                    <button class="btn btn-success" type="button" data-toggle="modal" data-target="#modalRooms" >View rooms</button>
                    </a>
                </td>
            </tr>
            </table>
        </td>
      </tr>
      <% } %>
      </tbody>
    </table>
  </div>
  <div class="col-lg-3">
    <div class="panel panel-default">
      <div class="panel-heading">Optimizer</div>
      <div class="panel-body">
        <form id="optimizer" role="form">
          <fieldset>
            <legend>Range</legend>
            <div class="input-group">
              <p>Price interval: <b>€ 10</b> to <b>€ 1000</b></p>
              <p><input id="ex2" type="text" class="span2" value="" data-slider-min="10" data-slider-max="1000"
                        data-slider-step="5" data-slider-value="[10,1000]"/>
              </p>
            </div>
            <p> <div class="input-group">
               <span id="sel_obj" class="input-group-addon">
                         <span class="glyphicon glyphicon-sort"></span>
                   </span>
                 <select class="form-control" id="pdisc" name="hotel">
                   <option selected value="1">default </option>
                   <option value="2">Minimum price </option>
                   <option value="3">Maximum price </option>
                 </select>
             </div></p>

            <div class="input-group">
              <span class="input-group-addon">
                         <span class="glyphicon glyphicon-user"></span>
                   </span>
              <p><input type="text" class="form-control" placeholder="Person count"></p>
            </div>
          </fieldset>
          <fieldset>
             <legend>Includes</legend>
            <div class="input-group">
              <div class="checkbox">
                <label><input type="checkbox"> Restroom</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Bathroom</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Kitchen</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Living Room</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Swimming pool</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Bar</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Balcony</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Build-in safe</label>
              </div>
              <div class="checkbox">
                <label><input type="checkbox"> Secret room</label>
              </div>
              </div>
          </fieldset>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>

      </div>
    </div>
  </div>
</div>


  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Orig image</h4>
        </div>
        <div class="modal-body">
          <script>
            $(function() {
              $("#myModal img").attr("src", $( "#hld").val());
             // $("#myModal img").attr("src", "bas");
            });
          </script>
          <img src="#">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>

    </div>
  </div>

    <div class="modal fade" id="modalRooms" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Rooms</h4>
                </div>
                <div class="modal-body">
                       <ul>
                           <li></li>
                       </ul>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
  <!-- Site footer -->
  <%-- <footer class="footer">
      <p>© Company 2014</p>
    </footer> --%>
  <jsp:include page="includes/footer.jsp" />
</div>




</body>
</html>
