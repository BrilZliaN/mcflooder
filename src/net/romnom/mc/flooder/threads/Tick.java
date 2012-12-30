/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.romnom.mc.flooder.threads;

import java.lang.*;
import net.romnom.mc.flooder.engine.NetManager;

public class Tick extends Thread implements Runnable {      
    
        private String ip;
        private int port;
        private int nickLength;
        
        public Tick(String ip, int port, int nickLength) {
		this.ip = ip;
                this.port = port;
                this.nickLength = nickLength;
                
		this.setName("Tick counter thread");
		this.setDaemon(true);
	}
        
        public void run() {              
                  
        }
        
        
}
