package com.u2.web.SpringDojo.Controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.u2.web.SpringDojo.model.LivroModel;
import com.u2.web.SpringDojo.service.LivroService;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/homeLivro")
    public String abreCadastro() {
        return "Cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarLivro(HttpServletRequest request,
                                 @RequestParam(value = "titulo") String titulo,
                                 @RequestParam(value = "editora") String editora) {

        LivroModel modelLivro = new LivroModel(titulo, editora);
        String mensagem = "";
        boolean cadastrouLivro = livroService.cadastrarLivro(modelLivro);

        if (!cadastrouLivro) {
            mensagem = "Livro já existente na base.";
        }

        request.getSession().setAttribute("mensagem", mensagem);
        return "Cadastro";
    }

    @GetMapping("/buscar")
    public ModelAndView buscarLivro(@RequestParam(value = "titulo") String titulo) {
        LivroModel livro = livroService.buscarLivro(titulo);
        ModelAndView modelAndView = new ModelAndView("Cadastro");
        modelAndView.addObject("livro", livro);
        return modelAndView;
    }

    @PostMapping("/atualizar")
    public String atualizarLivro(HttpServletRequest request,
                                 @RequestParam(value = "titulo") String titulo,
                                 @RequestParam(value = "novoTitulo") String novoTitulo,
                                 @RequestParam(value = "novaEditora") String novaEditora) {

        LivroModel livroAtualizado = new LivroModel(novoTitulo, novaEditora);
        boolean atualizou = livroService.atualizarLivro(titulo, livroAtualizado);
        String mensagem = atualizou ? "Livro atualizado com sucesso." : "Livro não encontrado.";
        request.getSession().setAttribute("mensagem", mensagem);
        return "Cadastro";
    }

    @PostMapping("/remover")
    public String removerLivro(HttpServletRequest request,
                               @RequestParam(value = "titulo") String titulo) {

        boolean removeu = livroService.removerLivro(titulo);
        String mensagem = removeu ? "Livro removido com sucesso." : "Livro não encontrado.";
        request.getSession().setAttribute("mensagem", mensagem);
        return "Cadastro";
    }

    @GetMapping("/listar")
    public ModelAndView listarLivros() {
        ModelAndView modelAndView = new ModelAndView("ListarLivros");
        modelAndView.addObject("livros", livroService.listarLivros());
        return modelAndView;
    }
}
