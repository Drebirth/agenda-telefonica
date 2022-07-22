package agenda.services.implementacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agenda.model.Contato;
import agenda.repository.ContatoRepository;
import agenda.services.ContatoService;

@Service
public class ContatoIMP implements ContatoService {

    @Autowired
    private ContatoRepository contato;

    @Override
    public List<Contato> buscarTodos() {
        return contato.findAll();
    }

    @Override
    public void adicionar(Contato c) {
        contato.save(c);
        
    }

    @Override
    public Contato atualizar(Long id, Contato c) {
        contato.findById(id);
        c.setId(id);
        return c;
    }

    @Override
    public void deletar(Long id) {
        contato.deleteById(id);
        
    }
    
}
