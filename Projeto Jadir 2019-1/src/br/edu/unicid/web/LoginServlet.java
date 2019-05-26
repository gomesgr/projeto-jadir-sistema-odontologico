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

import br.edu.unicid.bean.Dentista;
import br.edu.unicid.bean.Paciente;
import br.edu.unicid.dao.DentistaDAO;
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
		Integer tipo = Integer.parseInt(request.getParameter("tipoLogin"));
		Paciente paciente;
		Dentista dentista;
		PacienteDAO pdao;
		DentistaDAO ddao;
		
		switch(tipo)
		{
			case 1:		
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
				
				break;
			
			case 2:
				try
				{
					dentista = new Dentista();
					dentista.setLogin(request.getParameter("login"));
					dentista.setSenha(request.getParameter("senha"));
					ddao = new DentistaDAO();
					
					if(ddao.consultarLogin(dentista.getLogin(), dentista.getSenha()))
					{
						HttpSession session = request.getSession(true);
						session.setAttribute("dentista", dentista);
						response.sendRedirect("paineldeAcesso.htm");
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

}
