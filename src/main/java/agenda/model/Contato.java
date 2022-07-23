package agenda.model;

import org.hibernate.engine.jdbc.Size;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import static org.hibernate.query.criteria.internal.expression.function.AggregationFunction.*;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato")
    private Long id;

    private String nome;

    private String sobreNome;

    private Long telefone;

    @ManyToOne
    private Endereco endereco;

    public Contato(){}

    public Contato(Long id, String nome, String sobreNome, Long telefone, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}
