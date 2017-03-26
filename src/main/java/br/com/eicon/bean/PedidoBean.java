package br.com.eicon.bean;



import br.com.eicon.model.Pedido;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
@XmlRootElement(name="pedido")
public class PedidoBean{

    private Long numeroControle;
    private String dataCadastro;
    private String produto;
    private Double valor;
    private Integer quantidade;
    private Long cliente;

    public PedidoBean() {

    }

    public PedidoBean(Pedido pedido) {
        this.numeroControle = pedido.getNumeroControle();
        this.dataCadastro = pedido.getDataCadastro().toString();
        this.produto = pedido.getProduto();
        this.valor = pedido.getValor();
        this.quantidade = pedido.getQuantidade();
        this.cliente = pedido.getCliente().getId();
    }

    public Long getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(Long numeroControle) {
        this.numeroControle = numeroControle;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }
    
}
