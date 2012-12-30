/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.romnom.mc.flooder.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.romnom.mc.flooder.NotSupportedOperationException;

/**
 *
 * @author rom-s_000
 */
public abstract class Packet {
    
    public abstract int getId();
    public abstract int getSize();
    public abstract void read(DataInputStream s) throws IOException, NotSupportedOperationException;
    public abstract void write(DataOutputStream s) throws IOException, NotSupportedOperationException;
    
}
