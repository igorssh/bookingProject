<%--
  Created by IntelliJ IDEA.
  User: Aleksej_home
  Date: 2015.07.27.
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <!-- Bootstrap -->
  <jsp:include page="includes/header.jsp" />

  <link href="styles/bootstrap-datepicker3.min.css" rel="stylesheet">

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
 <div class="row">
   <div class="col-xs-9">
     <form class="form-horizontal" name="res" >
       <div class="form-group">
         <label class="control-label col-sm-2" for="aps">Apartment:</label>
         <div class="col-sm-10">
           <select class="form-control" id="aps" name="apartment">
             <option selected value="1">none</option>
             <option value="2">Dracula castle</option>
             <option value="3">Buisness apartment</option>
             <option value="4">Baracs</option>
           </select>
           </div>
       </div>
       <div class="form-group">
         <label class="control-label col-sm-2" for="room">Room:</label>
         <div class="col-sm-10">
           <select class="form-control" id="room" name="rooms">
             <option selected value="1">none</option>
             <option value="2">Room 1</option>
             <option value="3">Room 2</option>
             <option value="4">Room 3</option>
             <option value="5">Room 4</option>
             <option value="6">Room 5</option>
             <option value="7">Room 6</option>
           </select>
         </div>
       </div>
       <div class="form-group">
         <label class="control-label col-sm-2" for="datepicker">From:</label>
         <div class="col-sm-10">
           <div class="input-daterange input-group" id="datepicker">
             <input type="text" class="input-sm form-control" name="start" />
             <span class="input-group-addon">to</span>
             <input type="text" class="input-sm form-control" name="end" />
           </div>
         </div>
       </div>
       <div class="form-group">
         <label class="control-label col-sm-2" for="til">Till:</label>
         <div class="col-sm-10">
           <input class="date-picker date-picker-popup" id="til" data-provide="datepicker" data-date-format="dd/mm/yyyy">
         </div>
       </div>
       <div class="form-group">
         <div class="col-sm-offset-2 col-sm-10">
           <button type="submit" class="btn btn-default">Next</button>
         </div>
       </div>
     </form>
   </div>
   <div class="col-xs-3">
     <p>ddff</p>
   </div>
 </div>
  <!-- Site footer -->
  <%-- <footer class="footer">
      <p>© Company 2014</p>
    </footer> --%>
  <jsp:include page="includes/footer.jsp" />
</div>



<jsp:include page="includes/scripts.jsp" />
<script src="js/bootstrap-datepicker.min.js"></script>
</body>
</html>
