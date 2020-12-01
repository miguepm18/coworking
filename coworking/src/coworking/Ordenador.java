/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coworking;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ordenador {
    private boolean ocupado;
    Random ale;
    public Ordenador(){
        this.ocupado=false;
        this.ale = new Random();
    }
    
   //Este metodo usa el ordenador un tiempo aleatorio entre 0 y 5 segundos
    synchronized public void usarOrdenador(){
        while(this.ocupado){
            try {
                this.wait(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        this.ocupado=true;
        try{
            Thread.sleep(this.ale.nextInt(5)*1000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        this.ocupado=false;
        notifyAll();
    }
    
    //Metodo getter de ocupado
    public boolean getOcupado(){
        return this.ocupado;
    }
    
    //Metodo setter de ocupado
    public void setOcupado(boolean ocupado){
        this.ocupado=ocupado;
    }
}
