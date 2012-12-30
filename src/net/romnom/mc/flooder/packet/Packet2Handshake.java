package net.romnom.mc.flooder.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.romnom.mc.flooder.NotSupportedOperationException;

public class Packet2Handshake extends Packet{

	public int protocol;
	public String username;
	public String host;
	public int port;
        
        public Packet2Handshake() {
            
        }
        
	public Packet2Handshake(int protocol, String username, String host, int port) {
		this.protocol = protocol;
		this.username = username;
		this.host = host;
		this.port = port;
	}
	@Override
	public int getId() {
		return 2;
	}
	
        public int getSize() {
            return 9 + username.length() + host.length();
        }
        
	@Override
	public void read(DataInputStream buf) throws IOException, NotSupportedOperationException {
                throw new NotSupportedOperationException();
	}
	
	@Override
	public void write(DataOutputStream buf) throws IOException, NotSupportedOperationException {
                buf.writeByte(protocol);
		buf.writeShort(username.length());
                for(int i = 0; i < username.length(); ++i) {
                    buf.writeChar(username.charAt(i));
                }
		buf.writeShort(host.length());
		for(int i = 0; i < host.length(); ++i) {
                    buf.writeChar(host.charAt(i));
                }
		buf.writeInt(port);
	}
}
