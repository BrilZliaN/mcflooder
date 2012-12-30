/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.romnom.mc.flooder.packet;

import java.util.ArrayList;

/**
 *
 * @author rom-s_000
 */
public class PacketList {
    public ArrayList<Packet> list = new ArrayList();
    
    public PacketList() {
        this.add(new Packet0KeepAlive());
        this.add(new Packet1Login());
        this.add(new Packet2Handshake());
    }
    
    public void add(Packet packet)
    {
        if (list.contains(packet))
        {
            throw new IllegalArgumentException("Duplicate packet class:" + packet);
        }
        else
        {
            list.add(packet);
        }
    }
}
