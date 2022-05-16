/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ioTBay.dao;

import java.sql.Connection;
/**
 *
 * @author Jaydn
 */
public abstract class DB {
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String db = "iotdb";
    protected String dbuser = null;
    protected String dbpass = null;
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
}
