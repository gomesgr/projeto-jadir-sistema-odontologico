package br.edu.unicid.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unicid.bean.Paciente;
import br.edu.unicid.dao.PacienteDAO;

// TODO implementacao do metodo processRequest 

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	// TODO salvar cliente
	protected void processRequest(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String pageId = request.getParameter("pageId");
		switch (pageId) {
		case "cadastroCliente":
			PacienteDAO pdao = new PacienteDAO();
			pdao.salvar(new Paciente(request.getParameter("nomeCli"),
					request.getParameter("cpfCli"),
					request.getParameter("sexo"),
					request.getParameter("")
				
			));
		}
	}

}
