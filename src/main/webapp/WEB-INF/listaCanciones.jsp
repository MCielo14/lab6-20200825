<%--
  Created by IntelliJ IDEA.
  User: maric
  Date: 3/06/2023
  Time: 00:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Beans.Tour" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Tour>" scope="request" id="listaTours"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="canciones"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de canciones por baanda</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>ID</th>
                        <th>CANCI0N</th>
                        <th>BANDA</th>
                    </thead>
                    <%
                        for (Tour tour : listaTours) {
                    %>
                    <tr>
                        <td><%=tour.getIdTour()%>
                        </td>
                        <td><%=tour.getNombre_Tour()%>
                        </td>
                        <td><%=tour.getIdbanda()%>
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