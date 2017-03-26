/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eicon.controller;

import br.com.eicon.bean.RequestPedidoXMLBean;
import br.com.eicon.bean.ResponseMessageBean;
import br.com.eicon.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.eicon.service.PedidoService;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import br.com.eicon.repository.PedidoRepository;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
@RestController
@RequestMapping(value = "/xml")
public class PedidoXMLController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/pedidos", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<Pedido> listarXML() {
        return pedidoRepository.findAll();
    }

    @RequestMapping(value = "/pedido/salvar", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseMessageBean salvarXML(@RequestBody RequestPedidoXMLBean pedidos) {
        return pedidoService.salvar(pedidos.getPedido());
    }

    @RequestMapping(value = "/pedido/numeroControle/{numeroControle}", method = GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Pedido pedidoNumeroControleXML(@PathVariable("numeroControle") Pedido pedido) {
        return pedido;
    }

    @RequestMapping(value = "/pedido/dataCadastro/{dataCadastro}", method = GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<Pedido> pedidoDataCadastroXML(@PathVariable("dataCadastro") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataCadastro) {
        return pedidoRepository.findByDataCadastro(dataCadastro);
    }

}
