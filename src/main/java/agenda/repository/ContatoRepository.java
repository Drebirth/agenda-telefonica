package agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agenda.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
   }
