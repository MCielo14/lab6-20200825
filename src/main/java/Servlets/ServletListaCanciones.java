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


        String action = request.getParameter("p") == null ? "lista1" : request.getParameter("p") ;


        switch (action) {
            case "lista1":
                request.setAttribute("lista1", cancionesDao.listatotalCanciones());
                request.getRequestDispatcher("listaCanciones.jsp").forward(request, response);
                break;
            case "FOB":
                request.setAttribute("listaidBanda", cancionesDao.listaidBanda());
                request.getRequestDispatcher("listaCancionesTotales.jsp").forward(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
