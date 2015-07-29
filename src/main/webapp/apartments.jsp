<%@ page import="java.io.*,java.util.*" %>
<%@ page import="lv.javaguru.java2.domain.frontend.Apartment" %>


<%--
  Created by IntelliJ IDEA.
  User: Aleksej_home
  Date: 2015.07.27.
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%


  HashSet<Apartment> apList = new HashSet<Apartment>();
  Apartment ap = new Apartment();
  ap.setId(1l);
  ap.setLabel("images/apartments/thumbs/drak150x100.png");
  ap.setAddress("Bullu street 45");
  ap.setDesc("Good pay good day");
  apList.add(ap);
  Apartment ap2 = new Apartment();
  ap2.setId(2l);
  ap2.setLabel("images/apartments/thumbs/vanap150x100.png");
  ap2.setAddress("Stabu street 6");
  ap2.setDesc("For average person");
  apList.add(ap2);
  Apartment ap3 = new Apartment();
  ap3.setId(3l);
  ap3.setLabel("images/apartments/thumbs/stud150x100.png");
  ap3.setAddress("Putina street 10");
  ap3.setDesc("For poor person, .. students ant other");
  apList.add(ap3);


%>
<html>
<head>
  <!-- Bootstrap -->
  <jsp:include page="includes/header.jsp" />

  <link href="fonts/americantext.css" rel="stylesheet">

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
        Iterator<Apartment> itr = apList.iterator();
        while (itr.hasNext()) {
          ap =  itr.next();
      %>
       <input id="hld" type="hidden" value="<%= ap.getLabel() %>">
      <tr>
        <td><a data-toggle="modal" data-target="#myModal" href="#">
          <img class="img-thumbnail" src="<%= ap.getLabel() %>"> </a></td>
        <td><ul class="list-unstyled">
          <li><p>Adress: <%= ap.getAddress() %></p> </li>
          <li><p>Rooms count: 50</p></li>
          <ul>
            <li><p>In use: 31</p></li>
            <li><p>Free: 19</p></li>
          </ul>
          <li><p>Average room price: ~500 eu</p></li>
        </ul></td>
        <td><%= ap.getDesc() %></td>
      </tr>

      <% } %>
      </tbody>
    </table>
  </div>
  <div class="col-lg-3">
    <div class="panel panel-default">
      <div class="panel-heading">Optimizer</div>
      <div class="panel-body">
        <form role="form">
          <fieldset>
            <legend>Range</legend>
            <div class="input-group">
              <p><div id="slider"></div></p>
            </div>
             <div class="input-group">
               <p><div class="dropdown">
                 <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Price
                   <span class="caret"></span></button>
                 <ul class="dropdown-menu">
                   <li><a href="#">default <span class="glyphicon glyphicon-sort"></span></a></li>
                   <li><a href="#">Minimum price<span class="glyphicon glyphicon-sort-by-order"></span> </a></li>
                   <li><a href="#">Maximum price<span class="glyphicon glyphicon-sort-by-order-alt"></span></a></li>
                 </ul>
               </div></p>
             </div>
            <div class="input-group">
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
  <!-- Site footer -->
  <%-- <footer class="footer">
      <p>© Company 2014</p>
    </footer> --%>
  <jsp:include page="includes/footer.jsp" />
</div>




</body>
</html>
