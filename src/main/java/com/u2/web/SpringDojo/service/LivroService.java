package com.u2.web.SpringDojo.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.u2.web.SpringDojo.model.LivroModel;

@Service
public class LivroService {

	private HashMap<String, LivroModel> hashLivro = new HashMap<>();
	
	public boolean cadastrarLivro(LivroModel model) {
		if(!hashLivro.containsKey(model.getTitulo())) {
			hashLivro.put(model.getTitulo(), model);
			return true;
		}
		return false;
	}

	public LivroModel buscarLivro(String titulo) {
		return hashLivro.get(titulo);
	}

	public boolean atualizarLivro(String titulo, LivroModel livroAtualizado) {
		if(hashLivro.containsKey(titulo)) {
			hashLivro.put(titulo, livroAtualizado);
			return true;
		}
		return false;
	}

	public boolean removerLivro(String titulo) {
		if(hashLivro.containsKey(titulo)) {
			hashLivro.remove(titulo);
			return true;
		}
		return false;
	}

	public List<LivroModel> listarLivros() {
		return new ArrayList<>(hashLivro.values());
	}
}