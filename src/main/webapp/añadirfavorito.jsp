<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 3/06/2023
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Beans.Tour" %>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="lista1"/>
<html>
  <jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de Canciones por banda"/>
  </jsp:include>
  <body>
    <div class='container'>
      <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="tours"/>
      </jsp:include>
      <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
          <h1 class='text-light'>Lista canciones totales</h1>
        </div>
      </div>

      <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
          <thead>
            <th>ID</th>
            <th>CANCION</th>
            <th>BANDA</th>
          </thead>
          <%
            for (Cancion cancion : lista1) {
          %>
          <tr>
            <td><%=cancion.getIdcancion()%>
            </td>
            <td><%=cancion.getNombre_cancion()%>
            </td>
            <td><%=cancion.getBanda()%>
            </td>
            <td><button style="background-color:red; border-color:red; color:white">Me encanta</button>
            </td>
            <td><button style="background-color:yellow; border-color:yellow; color:white">Me gusta</button>
            </td>
            <td><button style="background-color:green; border-color:green; color:white">Añadir</button>
            </td>

          </tr>
          <%
            }
          %>

        </table>
      </div>
    </div>
    <jsp:include page="/static/scripts.jsp"/>
  </body>
</html>