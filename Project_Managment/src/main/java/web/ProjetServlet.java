package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Projet;

import java.io.IOException;
import java.util.List;

@WebServlet("/projets")
public class ProjetServlet extends HttpServlet {
    private dao.ProjetDaoIMp projetDao;

    @Override
    public void init() throws ServletException {
        projetDao = new dao.ProjetDaoIMp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Projet> projets = projetDao.findAll();
        req.setAttribute("projets", projets);
        req.getRequestDispatcher("/WEB-INF/views/projets.jsp").forward(req, resp);
    }
}
