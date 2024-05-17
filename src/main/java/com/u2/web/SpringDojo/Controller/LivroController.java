package com.u2.web.SpringDojo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.u2.web.SpringDojo.model.LivroModel;
import com.u2.web.SpringDojo.negocio.LivroRN;

@Controller
public class LivroController {
	
	LivroRN livroRN = new LivroRN();
	
	
	@GetMapping({"/homeLivro"})
	public String abreCadastro() {
		return "Cadastro";
	}
	
	
	@RequestMapping({"/cadastrar"})
	public String cadastrarLivro(HttpServletRequest request,
			@RequestParam(value="titulo") String titulo,
			@RequestParam(value="editora") String editora) {
		
		/* Recuperar os valores dos campos do formulário
		 * e preencher os atributos do model da entidade selecionada
		 */
		LivroModel modelLivro = new LivroModel();
		String mensagem = "";
		boolean cadastrouLivro = false;
		
		if(!titulo.equals("")) {
			modelLivro.setTitulo(titulo);
		} else {
			mensagem = "Título não pode ficar em branco.\n";
		}
		
		if(!editora.equals("")) {
			modelLivro.setEditora(editora);
		} else {
			mensagem += "Editora não pode ficar em branco.";
		}
		
		if(mensagem.equals("")) {
			//Tudo ok, então realizar o cadastro da entidade
			
			cadastrouLivro = livroRN.cadastrarLivro(modelLivro);
			
			if(!cadastrouLivro) {
				mensagem = "Livro já existente na base.";
			}
		} 		
			
		if(!mensagem.equals("")) {
			request.getSession().setAttribute("mensagem", mensagem);
		}
		
		return "Cadastro";
	}
	

}
