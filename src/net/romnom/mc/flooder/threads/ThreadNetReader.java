/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.romnom.mc.flooder.threads;

import java.lang.*;
import net.romnom.mc.flooder.engine.NetManager;

public class ThreadNetReader extends Thread implements Runnable {      
        
        public static boolean isRunning = true;
        private NetManager netman;
        
        public ThreadNetReader(NetManager netman) {
            this.setName("Net reader thread");
            
	}
        
        public void run() {              
            while(this.isRunning) {
                if(!netman.readNetwork()) {
                    try{ 
                        sleep(2L);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        
}
