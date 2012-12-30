package net.romnom.mc.flooder.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class Packet0KeepAlive extends Packet {

	public int keepAliveId = 0;
	
	public Packet0KeepAlive() {
		
	}
	
	public Packet0KeepAlive(int keepAliveId) {
		this.keepAliveId = keepAliveId;
	}

	@Override
	public int getId() {
		return 0x0;
	}
	
        public int getSize() {
            return 4;
        }
        
	@Override
	public void read(DataInputStream buf) throws IOException {
		keepAliveId = buf.readInt();
	}
	
	@Override
	public void write(DataOutputStream buf) throws IOException {
		buf.writeInt(keepAliveId);
	}
}
