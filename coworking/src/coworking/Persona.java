/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coworking;

import java.util.Random;


public class Persona implements Runnable{
    private String id;
    private Thread t;
    Random ale;
    private Tarjeta tarjeta1;
    private Tarjeta tarjeta2;
    private boolean tengoTarjeta1;
    private boolean tengoTarjeta2;
    
    public Persona(Tarjeta tarjeta1, Tarjeta tarjeta2, int id){
        this.tengoTarjeta1=false;
        this.tengoTarjeta2=false;
        this.id="F"+id;
        this.tarjeta1=tarjeta1;
        this.tarjeta2=tarjeta2;
        ale = new Random();
        t= new Thread(this, this.id);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("La persona " + this.id + " se ha sentado.");
        while(true){
            this.pensar();
            this.cogerTarjeta();
            this.intentarUsarOrdenador();
        }
        
    }
    
    //Metodo que espera un tiempo aleatorio entre 0 y 5 segundos
    public void pensar(){
        System.out.println("La persona " + this.id + " está pensando nuevas ideas.");
        try{
            Thread.sleep(this.ale.nextInt(5)*1000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    
    //Metodo que intenta coger las tarjetas de los lados
    public void cogerTarjeta(){
        if(!tarjeta1.getCogida() && !this.tengoTarjeta1){
		tarjeta1.cogerTarjeta();
		tarjeta2.cogerTarjeta();
        }else{
		tarjeta2.cogerTarjeta();
                tarjeta1.cogerTarjeta();
	}
        this.tengoTarjeta1=true;
        this.tengoTarjeta2=true;
    }
    

    private void intentarUsarOrdenador() {
        if(this.tengoTarjeta1 && this.tengoTarjeta2){
            System.out.println("La persona " + this.id + " va a usar el ordenador.");
            Mesa.usarOrdenador();
            System.out.println("La persona " + this.id + " ha dejado de usar el ordenador.");
            this.soltarTarjetas();
        }            
    }
    private void soltarTarjetas(){
        this.tarjeta1.soltarTarjeta();
        this.tarjeta2.soltarTarjeta();
        this.tengoTarjeta1=false;
        this.tengoTarjeta2=false;
    }
}
