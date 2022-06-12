package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.datedesc;
import repository.Repository;
import xmlworker.XMLWorker;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns={"/register","/index.jsp","/index.html"})
public class RegistrationServlet extends HttpServlet {
    Repository repo;
    XMLWorker xmlworker;
    public void init(ServletConfig config) throws ServletException {
        repo = Repository.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("repo",repo.getOptions());
        RequestDispatcher req=request.getRequestDispatcher("/public/register.jsp");
        req.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data=request.getParameter("mydate");
        String description=request.getParameter("mydescription");
        java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
        logger.warning("We are in the servlet.Let's just check smth.");
        datedesc a=new datedesc(data,description);
        if(repo.contains(a)) repo.addVote(a);
        else repo.add(a);
        response.sendRedirect(request.getContextPath());
    }
}
