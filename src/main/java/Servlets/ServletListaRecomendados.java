package Servlets;

import Beans.Reproduccion;
import Daos.CancionesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletListaRecomendados", value = "/listaRecomendados")
public class ServletListaRecomendados extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        CancionesDao cancionesDao = new CancionesDao();
        request.setAttribute("listaRecomendados",cancionesDao.listarecomendados());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarecomendaciones.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
