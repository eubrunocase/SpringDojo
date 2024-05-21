package com.u2.web.SpringDojo.model;


import com.u2.web.SpringDojo.Repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository livroRepository;


    public List<LivroRepository> findAll() {
        return LivroRepository.findAll();
    }

    public Optional<LivroRepository> findById(Long id) {
        return LivroRepository.findById(id);
    }

    public LivroRepository save(LivroRepository livroRepository) {
        return LivroRepository.save(livroRepository);
    }

    public void deleteById(Long id) {
        LivroRepository.deleteById(id);
    }












}
