package jemacarse.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jemacarse.entity.Personne;
import jemacarse.service.PersonneService;

@WebServlet(name = "ConnexionServlet",  urlPatterns = {"/connexion"})
public class ConnexionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pseudo = req.getParameter("login");
        String motDePasse = req.getParameter("motDePasse");
        Personne p = new PersonneService().rechercheParLoginEtMdp(pseudo, motDePasse);

        req.getSession().setAttribute("persoConnecte", p);
        resp.sendRedirect("index");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("connexion.jsp").forward(req, resp);
    }

}
