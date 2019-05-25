package br.edu.unicid.web;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unicid.bean.Dentista;
import br.edu.unicid.bean.Endereco;
import br.edu.unicid.bean.Paciente;
import br.edu.unicid.dao.DentistaDAO;
import br.edu.unicid.dao.PacienteDAO;
import br.edu.unicid.util.ManipuladorDeString;

// TODO implementacao do metodo processRequest 

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	// TODO salvar cliente
	protected void processRequest(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String pageId = request.getParameter("pageId");
		switch (pageId) {
			case "cadastroUsuario":
				try {
					Endereco end = new Endereco(request.getParameter("endCli"),
							request.getParameter("endNumCli"),
							request.getParameter("cepCli")
							);
					System.out.println(request.getParameter("smsConsulta"));
					boolean b;
					if (request.getParameter("smsConsulta") != null)
						b = true;
					else
						b = false;
					PacienteDAO pdao = new PacienteDAO();
					System.out.println(pdao.salvar(new Paciente(
							request.getParameter("nomeCli"),
							request.getParameter("cpfCli"),
							request.getParameter("sexo"),
							request.getParameter("rgCli"),
							request.getParameter("estado"),	
							ManipuladorDeString.returnDateFromString(request
								.getParameter("dtaNasc")),
							request.getParameter("telefoneCli"),
							end,
							request.getParameter("cidade"),
							request.getParameter("bairroCli"),
							request.getParameter("emailCli"),
							request.getParameter("login"),
							request.getParameter("senha"),
							b
					)) + " linha(s) alterada(s)");
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case "cadastroDentista":
				DentistaDAO ddao = new DentistaDAO();
				System.out.println(ddao.salvar(new Dentista(
							request.getParameter("nomeCli"),
							Integer.parseInt(request.getParameter("croDentista")),
							request.getParameter("telefoneCli"),
							request.getParameter("login"),
							request.getParameter("senha")
						)
					)
				+ " linha(s) alterada(s)");	
		}
	}

}
