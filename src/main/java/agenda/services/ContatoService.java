package agenda.services;

import java.util.List;

import agenda.model.Contato;

public interface ContatoService {
   
   List<Contato> buscarTodos();

   void adicionar(Contato c);

   Contato atualizar(Long id, Contato c);

   void deletar(Long id);




}
