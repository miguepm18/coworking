/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coworking;

/**
 *
 * @author usuario
 */
public class Tarjeta {
    private boolean cogida;
    private static int count=0;
    private int id;
    
    public Tarjeta(){
        this.id=count;
        count++;
        this.cogida=false;
    }
    //Metodo que coge la tarjeta
    synchronized public void cogerTarjeta(){
        while(this.cogida){
            try{
                wait(300);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        this.cogida=true;
    }
    //Metodo que suelta la tarjeta
    public void soltarTarjeta(){
        synchronized(this){
            this.setCogida(false);
            notifyAll();            
        }
    }
    
    //Metodo getter de id
    public int getId(){
        return this.id;
    }
    
    //Metodo getter de cogida
    public boolean getCogida(){
        return this.cogida;
    }
    
    //Metodo setter de cogida
    public void setCogida(boolean cogida){
        this.cogida=cogida;
    }
}
