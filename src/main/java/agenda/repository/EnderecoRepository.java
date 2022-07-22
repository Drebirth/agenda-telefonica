package agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agenda.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
    
}
