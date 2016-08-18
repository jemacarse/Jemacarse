package jemacarse.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jemacarse.entity.Personne;
import jemacarse.entity.Personne.RolePersonne;
import jemacarse.service.PersonneService;

@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String motDePasse = req.getParameter("motDePasse");
        String motDePasse2 = req.getParameter("motDePasse2");
        String email = req.getParameter("mail");
        String adresse = req.getParameter("adresse");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String role = req.getParameter("role"); 

        if (!motDePasse.equals(motDePasse2)) {

            resp.sendRedirect("accueil");
            return;
        }
        
        Personne p = new Personne();
        p.setLogin(login);
        p.setMotDePasse(motDePasse);
        p.setMail(email);
        p.setAdresse(adresse);
        p.setPrenom(prenom);
        p.setNom(nom);
        p.setRolePersonne(RolePersonne.valueOf(role));

        new PersonneService().ajouterPersonne(p);
        
        req.getRequestDispatcher("accueil.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("accueil.jsp").forward(req, resp);

    }
}
