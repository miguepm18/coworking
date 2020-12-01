/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coworking;

import java.util.ArrayList;


/**
 *
 * @author usuario
 */
public class Mesa {
    static ArrayList<Persona> personas = new ArrayList();
    static Ordenador pc = new Ordenador();
    static ArrayList<Tarjeta> tarjetas = new ArrayList();    
    public static void main(String [] args){
        //Añado a las personas y las tarjetas de la mesa
        for(int i=0; i<5;i++){
            tarjetas.add(new Tarjeta());
        }
        for(int i=0; i<5;i++){
            Tarjeta tarjeta1=null;
            Tarjeta tarjeta2=null;
            for (Tarjeta tarjeta : tarjetas) {                
                if(tarjeta.getId()==i){
                    tarjeta1=tarjeta;
                }
                if(tarjeta.getId()==i+1){
                    tarjeta2=tarjeta;
                }
                personas.add(new Persona(tarjeta1, tarjeta2, i));
            }           
        }
        
        
    }
    
    //Este metodo usa el ordenador un tiempo aleatorio entre 0 y 5 segundos
    synchronized public static void usarOrdenador(){
        pc.usarOrdenador();
    }
}
