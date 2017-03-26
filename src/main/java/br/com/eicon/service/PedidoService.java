package br.com.eicon.service;

import br.com.eicon.bean.PedidoBean;
import br.com.eicon.bean.ResponseMessageBean;
import br.com.eicon.model.Cliente;
import br.com.eicon.model.Pedido;
import br.com.eicon.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.eicon.repository.PedidoRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    private final SimpleDateFormat simpleDateFormatBanco = new SimpleDateFormat("yyyy-MM-dd");

    private ResponseMessageBean responseMessageBean = new ResponseMessageBean();

    public ResponseMessageBean salvar(List<PedidoBean> pedidos) {
        if (pedidos.size() > 10) {
            this.responseMessageBean.getMessage().add("Lista de Pedido é maior que o permido, Envio Maximo de 10 pedidos.");
            return this.responseMessageBean;
        }

        List<Pedido> listPedidos = new ArrayList<>();

        pedidos.forEach((PedidoBean t) -> {
            Pedido pedidoCadastrado = this.pedidoRepository.findOne(t.getNumeroControle());
            Cliente clientePedido = this.clienteRepository.findOne(t.getCliente());
            if (pedidoCadastrado != null) {
                this.responseMessageBean.getMessage().add("Pedido: " + pedidoCadastrado.getNumeroControle() + " - Já existe em nosso banco de dados");
            } else if (clientePedido == null) {
                this.responseMessageBean.getMessage().add("Pedido: " + t.getNumeroControle() + " - Cliente não encontrado na base de dados");
            } else {
                listPedidos.add(addPedido(t));
            }
        });

        listPedidos.forEach((Pedido p) -> {
            p.calculaTotal();
            p.darDesconto();
        });

        this.pedidoRepository.save(listPedidos);
        this.responseMessageBean.getMessage().add("Pedidos Processados");
        return this.responseMessageBean;
    }

    private Pedido addPedido(PedidoBean pedidoBean) {
        Pedido pedido = new Pedido();

        try {
            pedido.setNumeroControle(pedidoBean.getNumeroControle());
            pedido.setProduto(pedidoBean.getProduto());
            if (pedidoBean.getDataCadastro() != null && !pedidoBean.getDataCadastro().equals("")) {
                pedido.setDataCadastro(simpleDateFormatBanco.parse(pedidoBean.getDataCadastro()));
            } else {
                pedido.setDataCadastro(new Date());
            }
            pedido.setQuantidade(pedidoBean.getQuantidade() != null && pedidoBean.getQuantidade() > 1 ? pedidoBean.getQuantidade() : 1);
            pedido.setValor(pedidoBean.getValor());
            Cliente cliente = clienteRepository.findOne(pedidoBean.getCliente());
            if (cliente != null) {
                pedido.setCliente(cliente);
            }
        } catch (ParseException ex) {
            Logger.getLogger(PedidoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido;
    }
    

}
