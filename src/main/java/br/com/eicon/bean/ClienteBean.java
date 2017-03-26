package br.com.eicon.bean;

import br.com.eicon.model.Cliente;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
@XmlRootElement
public class ClienteBean {

    private Long id;
    private String nome;

    public ClienteBean() {

    }

    public ClienteBean(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
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

}
