/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eicon.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
@Entity
public class Pedido implements Serializable {

    @Id
    @Column(nullable = false, unique = true)
    private Long numeroControle;
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(nullable = false)
    private String produto;
    @Column(nullable = false, precision = 7, scale = 2)
    private Double valor;
    @Column(nullable = false, precision = 7, scale = 2)
    private Double valorTotal;
    private Integer percentualDesconto;
    private Integer quantidade;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente = new Cliente();

    public Long getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(Long numeroControle) {
        this.numeroControle = numeroControle;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(Integer percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void darDesconto() {
        if (this.quantidade > 5 && this.quantidade < 10) {
            this.valorTotal = (this.valor * 95) / 100;
            this.percentualDesconto = 5;
        } else if (this.quantidade >= 10) {
            this.valorTotal = (this.valor * 90) / 100;
            this.percentualDesconto = 10;
        } else {
            this.percentualDesconto = 0;
        }
    }

    public void calculaTotal() {
        this.valorTotal = this.valor * this.quantidade;
    }

}
