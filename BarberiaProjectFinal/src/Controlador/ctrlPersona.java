/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//26:30
/**
 *
 * @author jesus
 */
public class ctrlPersona implements ActionListener{
    /*private Persona mod;
    private DAO dao;
    private RegisterClient rcl;
    private ModiClient mcl;
*/
    DAO dao =new DAO();
    Persona mod=new Persona();
    ListClient vista=new ListClient();
    RegisterClient rcl=new RegisterClient();
    ModiClient mcl = new ModiClient();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ctrlPersona(ListClient v, Persona mod, DAO dao) {  
        this.vista=v;
        this.dao = dao;
        this.mod = mod;
        //this.rcl = rcl;
        //this.mcl = mcl;
        this.vista.btnListar.addActionListener(this);
        //this.rcl.btnRegistrar.addActionListener(this);
        //this.mcl.btnModificar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
       if(e.getSource()==rcl.btnRegistrar){
           mod.setCedulaPersona(Integer.parseInt(rcl.CedulaReg.getText()));
           mod.setNombre(rcl.NombreReg.getText());
           mod.setApellido(rcl.ApellidoReg.getText());
           mod.setTelefono(rcl.TelefonoReg.getText());
           mod.setEmail(rcl.EmailReg.getText());
           System.out.println("control");
           if(dao.agregarPersona(mod)){
               JOptionPane.showMessageDialog(null,"Registro Guardado");
               limpiar();
           }
           else{
              JOptionPane.showMessageDialog(null,"Error al Registrar"); 
              limpiar();
           }
       } 
       
       
        if(e.getSource()==vista.btnListar){
            System.out.println("listar");
            Listar(vista.Tabla);
        }
        
        
    }
    
    public void Listar(JTable tabla){
     modelo = (DefaultTableModel)tabla.getModel();
     List<Persona>lista=dao.Listar();
     Object[]object=new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0]=lista.get(i).getCedulaPersona();
            object[1]=lista.get(i).getNombre();
            object[2]=lista.get(i).getApellido();
            object[3]=lista.get(i).getEmail();
            object[4]=lista.get(i).getTelefono();
            modelo.addRow(object);
        }
        System.out.println("lis");
        vista.Tabla.setModel(modelo);
    }
    
    public void limpiar(){
        rcl.CedulaReg.setText(null);
        rcl.NombreReg.setText(null);
        rcl.ApellidoReg.setText(null);
        rcl.TelefonoReg.setText(null);
        rcl.EmailReg.setText(null);
    }
    
    
    

   
    
    
}
