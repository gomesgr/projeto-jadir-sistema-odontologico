package br.edu.unicid.web;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unicid.bean.Paciente;
import br.edu.unicid.dao.PacienteDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Paciente paciente;
		PacienteDAO pdao;
		
		try
		{
			paciente = new Paciente();
			paciente.setLogin(request.getParameter("login"));
			paciente.setSenha(request.getParameter("senha"));
			pdao = new PacienteDAO();
			
			if(pdao.consultarLogin(paciente.getLogin(), paciente.getSenha()))
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("paciente", paciente);
				response.sendRedirect("areaCli.jsp");
			}
			
			else
			{
				// No page for this yet...
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
