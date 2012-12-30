/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.romnom.mc.flooder.engine;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.romnom.mc.flooder.ConsoleLogManager;
import net.romnom.mc.flooder.PropertyManager;
import net.romnom.mc.flooder.packet.Packet2Handshake;

/**
 *
 * @author rom-s_000
 */
public class MCFlooder {
    
    private final Logger log = Logger.getLogger("flooder");
    private PropertyManager settings = new PropertyManager(new File("flooder.conf"));
    public NetManager netman;
    
    private String ip;
    private int port;
    private int threads;
    private int nickLength;
    
    public MCFlooder() {
        
            ConsoleLogManager.init();
            log.info("Starting flooder...");
            log.info("Reading configuration");
            this.ip = settings.getStringProperty("ip", "0.0.0.0");
            this.port = settings.getIntProperty("port", 25565);
            this.threads = settings.getIntProperty("threads", 100);
            this.nickLength = settings.getIntProperty("nickLength", 5);
            log.info("Configuration readed:");
            log.info("  IP: "+this.ip);
            log.info("  Port: "+this.port);
            log.info("  Threads: "+this.threads);
            log.info("  Nick length: "+this.nickLength);
            
            //new Tick(this.ip, this.port, this.thread, this.nickLength, this.messageLength).start();
                this.netman = new NetManager(this.ip, this.port);
       /* try {
            this.netman.writePacket(new Packet2Handshake(49, "Admin", "localhost", 25565));
        } catch (IOException ex) {
            ex.printStackTrace();
        } */
    }
}
