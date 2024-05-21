package com.u2.web.SpringDojo.Repository;


import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository {


    static List<LivroRepository> findAll() {
        return null;
    }

    static Optional<LivroRepository> findById(Long id) {
        return null;
    }

    static LivroRepository save(LivroRepository livroRepository) {
        return null;
    }

    static void deleteById(Object id) {
    }
}
