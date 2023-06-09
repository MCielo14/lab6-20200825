package Servlets;

import Beans.Cancion;
import Daos.CancionesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletListaCanciones", value = "/ServletListaCanciones")
public class ServletListaCanciones extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionesDao cancionesDao = new CancionesDao();
                request.setAttribute("lista1", cancionesDao.listatotalCanciones());
                request.getRequestDispatcher("listaCancionesTotales.jsp").forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
