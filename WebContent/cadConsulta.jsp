<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Agendar Consulta</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/one-page-wonder.min.css" rel="stylesheet">
	
	<!-- CSS que pode mexer-->
  <link rel="stylesheet" type="text/css" href="css/estilo.css"/>
	
	<!--Icones de Redes Sociais-->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <script>
       $(document).ready(function() {	
           	
            //CADASTRA NOVO EVENTO
            $('#novo_evento').submit(function(){
                //serialize() junta todos os dados do form e deixa pronto pra ser enviado pelo ajax
                var dados = jQuery(this).serialize();
                $.ajax({
                    type: "POST",
                    url: "cadastrar_evento.php",
                    data: dados,
                    success: function(data)
                    {   
                        if(data == "1"){
                            alert("Cadastrado com sucesso! ");
                            //atualiza a p�gina!
                            location.reload();
                        }else{
                            alert("Houve algum problema.. ");
                        }
                    }
                });                
                return false;
            });	
	   }); 
                
    </script>

	<style type="text/css">
		form {
    		border: 3px solid #ccc;
    		border-color: black;
    		width: 650;
    		margin: auto;
    		padding: 1em;
    		border-radius: 10px;
		}
		div{
			text-align: left;
		}
		 #calendario{
            position: relative;
            width: 70%;
            margin: 0px auto;
        }
        .dropbtn {
		background-color:#4C4C4C;
  		 color: #A6A6A6;
  		 padding: 15px;
	     padding-top: 0px;
		 padding-left:5px; 
	 	 font-size: 16px;
  		 border: none;
		 width: 90%;
    	 height: 36px !important;
		}
		
		.dropdown {
 		 position: relative;
 		 display: inline-block;
		}
		
		.dropdown-content {
 		 display: none;
  		position: absolute;
 		 background-color: #f1f1f1;
 		 min-width: 160px;
 		 box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
 		 z-index: 1;
		}	
		.dropdown-content a {
 		 color: black;
  		padding: 12px 16px;
  		text-decoration: none;
  		display: block;
		}
		.dropdown-content a:hover {background-color: #ddd;}
		.dropdown:hover .dropdown-content {display: block;}
		.dropdown:hover .dropbtn {background-color: #4C4C4C;}
	</style>
</head>

<body>

	
	<div class="container fluid">
		<div id="vermelho" class="col-sm-12">
		<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
    <div class="container">
      <img src="img/newlogo3.png"><a class="navbar-brand" href="#">&nbsp CORA��ES</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
		<li class="nav-item">
            <a class="nav-link" href="index.jsp">In�cio</a>
         </li>
		<li class="nav-item">
            <a class="nav-link" href="sobre.jsp">Sobre n�s</a>
         </li>
		<li class="nav-item">
            <a class="nav-link" href="contato.jsp">Contato</a>
          </li>
		  <li class="nav-item">
            <a class="nav-link" href="agenda.jsp">Agenda</a>
          </li>
          <div class="dropdown">
  					<button class="dropbtn nav-link"><% if (session.getAttribute("usuario") != null) 
  												out.write(" Bem vindo " + session.getAttribute("usuario")); 
  												
  												else {
  													out.write("ENTRAR");
  													RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
  													session.setAttribute("confirme", "logue-se");
  													rd.forward(request, response);
  												}
  													
  									%></button>
					
  					<div class="dropdown-content">
    					<a href="cadConsulta.jsp">Agendar Consulta</a>
    					<style>
    						.button {
    							 background-color:#f1f1f1;
						         border: none;
						         color: black;
						         padding: 10px 120px 10px 10px;
						         text-align: left;
						         text-decoration: none;
						         display: inline-block;
						         font-size: 16x;
						         margin:0px 0px 0px 0px;
						         cursor: pointer;
    						}
    						.button:hover {
    							background-color:#ddd;
    						}
    					</style>
    					<form action="LoginServlet" method="get" style="border:none;background:none;padding:0px;margin:auto;">
    						<button class="button" type="submit">Sair</button>
    					</form>
					</div>
					
      </div>
		 <!-- <li class="nav-item"><a class="nav-link">Nome do cliente-->
			  	
		  </ul>
    </div>
		</div>
  </nav>
		</div>
	</div>
	
	 <div class="container fluid">
		 <div class="row">
	 	  	<div id="preto" class="col-sm-12">
			 	
				<!-- In�cio da �rea edit�vel-->
				<br><br>
				 <div id='calendario'>
				<form method="get" action=""><!-- colocar aqui o nome da pagina -->
					<center><h1>Agende sua Consulta</h1></center><br>

					Tipo de consulta: <input type="text" name="nome" required/>	&nbsp;	&nbsp;     
            	
            		Data da Consulta: <input type="date" name="data" required/><br/><br/>            
			
			Horarios disponiveis:
			<select>
				<option value="h1">horario 1</option>
				<option value="h2">horario 2</option>
				<option value="h3">horario 3</option>
			</select>
			<hr/>	
			Hist�rico e Observa��es:<br/>
				<textarea id="Hist�rico" name="historicoDoen�a" rows="10" cols="90">
				</textarea>

			<center>
				<input type="submit" value="Agendar"/>
				<input type="reset" value="Limpar"/>
				<a href="index.html"><button>Pagina inicial</button></a>
			</center>
		</form>
				</div>
				<!-- Fim da �rea edit�vel-->				
				
			 </div>
		 </div>
				 </div>
		 	
		 <div class="row">
			 <div id="verde" class="col-sm-12"></div>
		 </div>
	  
	 <footer class="py-5 bg-black">
    
    	<div class="container">
	
      	<h2>Redes Sociais</h2>

	<!-- Icones das Redes Sociais -->
		<a href="https://facebook.com" target="_blank" class="fa fa-facebook"></a>|
		<a href="https://twitter.com/?lang=pt" target="_blank"  class="fa fa-twitter"></a>|
		<a href="https://gmail.com/mail/help/intl/pt_pt/about.html" target="_blank"  class="fa fa-google"></a>|
		<a href="https://br.linkedin.com/" target="_blank"  class="fa fa-linkedin"></a>|
		<a href="https://youtube.com" target="_blank"  class="fa fa-youtube"></a>|
		<a href="https://instagram.com"  target="_blank"  class="fa fa-instagram"></a>
    
	  </div>
	  
  </footer>
	  		
	  
	  


    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  </body>
</html>
	
	

  <!-- Bootstrap core JavaScript -->
				
				
				
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>

