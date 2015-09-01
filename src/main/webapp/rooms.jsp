<%--
  Created by IntelliJ IDEA.
  User: Aleksej_home
  Date: 2015.09.01.
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="lv.javaguru.java2.core.domain.frontend.Extra" %>
<%@ page import="java.util.*" %>
<%@ page import="lv.javaguru.java2.core.domain.frontend.Room" %>
<%@ page import="lv.javaguru.java2.core.domain.frontend.Hotel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<String, Object> params = (Map) request.getAttribute("model");
    Hotel currentHotel = (Hotel)params.get("currentHotel");
    List<Room> roomsList = (List)params.get("allRooms");
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
      <li><p><%= room.getRoomNumber()%></p>
          <p><%= room.getDescription()%></p>
          <p><%= room.getPersonCount()%></p>
          <p><%= room.getPricePerDay()%></p>
      </li>
        <%
            }
        %>
    </ul>
</body>
</html>
