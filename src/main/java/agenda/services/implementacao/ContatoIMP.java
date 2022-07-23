package agenda.services.implementacao;

import java.util.List;
import java.util.Optional;

import agenda.model.Endereco;
import agenda.repository.EnderecoRepository;
import agenda.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agenda.model.Contato;
import agenda.repository.ContatoRepository;
import agenda.services.ContatoService;

@Service
public class ContatoIMP implements ContatoService {

    @Autowired
    private ContatoRepository contato;
    @Autowired
    private EnderecoRepository endereco;
    @Autowired
    private ViaCepService viaCepService;

    public ContatoIMP(ContatoRepository contato, EnderecoRepository endereco, ViaCepService viaCepService){
        this.contato = contato;
        this.endereco = endereco;
        this.viaCepService = viaCepService;
    }


    @Override
    public List<Contato> buscarTodos() {
        return contato.findAll();
    }

    public Contato buscarPorId(Long id){
        Optional<Contato> contato1 = contato.findById(id);
        return contato1.orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    @Override
    public void adicionar(Contato c) {
        salvarContato(c);
        
    }

    @Override
    public void atualizar(Long id, Contato c) {
       Optional<Contato> contato1 = contato.findById(id);
       if (contato1.isPresent()){
           c.setId(id);
           salvarContato(c);
       }
    }

    @Override
    public void deletar(Long id) {
        contato.deleteById(id);
        
    }

    private void salvarContato(Contato c){
        String cep = c.getEndereco().getCep();
        Endereco endereco1 = endereco.findById(cep).orElseGet(() -> {
            Endereco enderecoNovo = viaCepService.consultarCep(cep);
            endereco.save(enderecoNovo);
            return enderecoNovo;
        });
        c.setEndereco(endereco1);
        contato.save(c);
    }
    
}
