<%--
  Created by IntelliJ IDEA.
  User: Aleksej_home
  Date: 2015.09.01.
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="lv.javaguru.java2.core.domain.frontend.Room" %>
<%@ page import="lv.javaguru.java2.core.domain.frontend.Hotel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Hotel currentHotel = (Hotel)request.getAttribute("model");
    List<Room> roomsList =  currentHotel.getHotelRooms();
    //List<Room> roomsList = null;
%>

<html>
<head>
    <title>Rooms</title>
</head>
<body>
<p><h2><img class="img-thumbnail" src="<%=currentHotel.getLabel() %>"/> </h2> </p>
    <ul>
        <% if (roomsList != null)
            for (Room room : roomsList){
        %>
      <li><p>Room number: <%= room.getRoomNumber()%></p>
          <p>Description: <%= room.getDescription()%></p>
          <p>Persons maximum number: <%= room.getPersonCount()%></p>
          <p>Price per day: <%=room.getPricePerDay()%></p>
          <p>Room class: <%= room.getRoomClass().getClassName()%></p>
      </li>
        <%
            }
        %>
    </ul>
</body>
</html>
