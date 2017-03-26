package br.com.eicon.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
@XmlRootElement(name = "pedidos")
public class RequestPedidoXMLBean {

    List<PedidoBean> pedido;

    public List<PedidoBean> getPedido() {
        return pedido;
    }

    public void setPedido(List<PedidoBean> pedido) {
        this.pedido = pedido;
    }
}
