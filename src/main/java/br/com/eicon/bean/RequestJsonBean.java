package br.com.eicon.bean;

import java.util.List;


/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
public class RequestJsonBean<E> {

    private List<E> list;

    public List<E> getList() {
        return list;
    }

    public void setPedido(List<? extends PedidoBean> element) {
        this.list = (List<E>) element;
    }
    
    public void setCliente(List<? extends ClienteBean> element) {
        this.list = (List<E>) element;
    }
}
