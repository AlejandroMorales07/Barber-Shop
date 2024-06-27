/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberiaproject;
import Controlador.*;
import Modelo.*;
import Vista.*;
public class BarberiaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJFrame meth = new NewJFrame();
        Persona mod=new Persona();
       DAO dao=new DAO();
       //RegisterClient rcl=new RegisterClient();
       //ModiClient mcl=new ModiClient();
       ListClient v=new ListClient();
       ctrlPersona c=new ctrlPersona(v, mod, dao);
       
       //ctrlPersona ctrlp=new ctrlPersona(mod, dao, rcl, mcl);
       
       meth.setVisible(true);
    }
    
   
    
}
