/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eicon;

/**
 *
 * @author Cesar Searlini <cesar.searlini@gmail.com>
 */
public class PropertiesConfig {

    private PropertiesConfig() {
    }

    protected static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String DB_HOST = "jdbc:mysql://localhost:3306/";
    protected static final String DB_NAME = "pedido";
    protected static final String DB_USER = "root";
    protected static final String DB_PASS = "";
    protected static final String DB_HOST_NAME = DB_HOST + DB_NAME;

}



