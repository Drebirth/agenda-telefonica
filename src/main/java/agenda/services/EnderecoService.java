package agenda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agenda.model.Endereco;
import agenda.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository endereco;

    public Endereco post(Endereco e){
        return endereco.save(e);
    }
    
}
