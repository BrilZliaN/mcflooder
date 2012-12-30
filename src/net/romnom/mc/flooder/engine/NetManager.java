/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.romnom.mc.flooder.engine;

import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.ArrayList;
import net.romnom.mc.flooder.NotSupportedOperationException;
import net.romnom.mc.flooder.packet.Packet;
import net.romnom.mc.flooder.packet.PacketList;
import net.romnom.mc.flooder.threads.ThreadNetReader;
/**
 *
 * @author rom-s_000
 */
public class NetManager {
    private final Logger log = Logger.getLogger("flooder");
    private Socket sock;
    private DataInputStream sin;
    private DataOutputStream sout;
    
    private PacketList packets = new PacketList();
    public ArrayList<Packet> readPackets = new ArrayList();
    
    private int countPacketsGet = 0;
    private int countPacketsSent = 0;
    private int countSentData = 0;
    private int countReadData = 0;
    
    public NetManager(String ip, int port) {
        try {
            log.info("Start networking");
            try {
                this.sock = new Socket(InetAddress.getByName(ip), port);
            } catch(Exception e) {
                log.log(Level.SEVERE, "Cannot start networking, exiting");
                e.printStackTrace();
                System.exit(0);
            }
            
            this.sin = new DataInputStream(this.sock.getInputStream());
            this.sout = new DataOutputStream(this.sock.getOutputStream());
            new ThreadNetReader(this).start();
            
        } catch (IOException ex) {
            Logger.getLogger(NetManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writePacket(Packet packet) throws IOException {
        try {
            this.sout.write(packet.getId());
            packet.write(this.sout);
            log.info("Write packet " + packet.getId());
        } catch(Exception e) {
            e.printStackTrace();
        }
        ++this.countPacketsSent;
        this.countSentData += (long)packet.getSize();
    }
    
    public Packet readPacket() throws IOException, NotSupportedOperationException
    {
        Packet packet = null;
        int id;

        try
        {
            id = this.sin.read();
            System.out.println(id);
            if (id == -1) {
                return null;
            }

            packet = this.packets.list.get(id);
            if (packet == null) {
                throw new IOException("Bad packet id: " + id);
            }
            
            packet.read(this.sin);
            ++this.countPacketsGet;
            this.countReadData += (long) packet.getSize();
            log.info("Read packet " + id);
        }
        catch (EOFException e)
        {
            e.printStackTrace();
            System.out.println("Reached end of stream");
            return null;
        }

        ++this.countPacketsGet;
        this.countReadData += (long)packet.getSize();
        return packet;
    }
    
    public boolean readNetwork() {
        boolean status = false;
        try {
            Packet packet = this.readPacket();
            if(packet != null) {
                this.readPackets.add(packet);
                status = true;
            }
            return status;
        } catch (Exception e) {
            e.printStackTrace();
            return status;
        }
    }
}
