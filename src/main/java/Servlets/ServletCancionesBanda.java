package Servlets;

import Daos.CancionesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCancionesBanda", value = "/ServletCancionesBandaFOB")
public class ServletCancionesBanda extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionesDao cancionesDao = new CancionesDao();
        request.setAttribute("listaidBanda", cancionesDao.listaidBanda());
        request.getRequestDispatcher("listaCanciones.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
