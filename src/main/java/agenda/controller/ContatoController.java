package agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agenda.model.Contato;
import agenda.services.implementacao.ContatoIMP;

@RestController
@RequestMapping("/agenda")
public class ContatoController {
    
    @Autowired
    private ContatoIMP contato;

    public ContatoController(ContatoIMP contato){
        this.contato = contato;
    }

    @GetMapping("/")
    public List<Contato> listarTodos(){
        return contato.buscarTodos();
    }

    @GetMapping("/{id}")
    public Contato buscarPorId(@PathVariable Long id){
        return contato.buscarPorId(id);
    }


    @PostMapping("/")
    public void adicionar(@RequestBody Contato c){
        contato.adicionar(c);
    }

    @PutMapping("/{id}")
    public void alterar(@PathVariable Long id, @RequestBody Contato c){
         contato.atualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        contato.deletar(id);
    }

}
