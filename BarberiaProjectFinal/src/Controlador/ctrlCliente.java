/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO;
import Modelo.Persona;
import Vista.DeleteClient;
import Vista.HistoryClient;
import Vista.ListClient;
import Vista.ModiClient;
import Vista.RegisterClient;
import Vista.RegisterServ;

/**
 *
 * @author jesus
 */
public class ctrlCliente {
    private Persona mod;
    private DAO dao;
    private RegisterServ rsr;
    private DeleteClient dcl;
    private ListClient lcl;
    private HistoryClient hcl;
}
