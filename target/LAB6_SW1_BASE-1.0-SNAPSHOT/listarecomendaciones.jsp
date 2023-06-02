<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 1/06/2023
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaRecomendados"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de recomendaciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="recomendaciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Canciones Recomendadas</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCION</th>
                        <th>BANDA</th>
                        <th>VER</th>
                    </thead>
                    <%
                        for (Cancion cancion : listaRecomendados) {
                    %>
                    <tr>
                        <td><%=cancion.getIdcancion()%>
                        </td>
                        <td><%=cancion.getNombre_cancion()%>
                        </td>
                        <td><%=cancion.getBanda()%>
                        </td>
                        <td><button style="background-color:green; border-color:green; color:white">Más de la banda</button>
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