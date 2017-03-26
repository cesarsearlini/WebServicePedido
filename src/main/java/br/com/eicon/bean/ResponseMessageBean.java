/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eicon.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
public class ResponseMessageBean {

    private List<String> message = new ArrayList<>();

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

}
