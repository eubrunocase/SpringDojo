package com.u2.web.SpringDojo.model;

import java.beans.JavaBean;
import java.util.ArrayList;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NonNull;


@JavaBean
@Data
@AllArgsConstructor
@NonNull
public class LivroModel {

	private String titulo;
	private String editora;

    private ArrayList<LivroModel> crud = new ArrayList();


	public LivroModel(String titulo, String editora) {
		super();
		this.titulo = titulo;
		this.editora = editora;
	}

	public LivroModel() {
	}




}
