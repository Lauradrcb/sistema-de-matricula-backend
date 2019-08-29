package br.com.tcclaura.appsistemamatricula.repository;

import br.com.tcclaura.appsistemamatricula.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunosRepository extends JpaRepository<Alunos, Integer> {
        @Query(value = "SELECT * FROM alunos t WHERE t.cpf = ?1", nativeQuery = true)
        Alunos findByName(String Name);
}
