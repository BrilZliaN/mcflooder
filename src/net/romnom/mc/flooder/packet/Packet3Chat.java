package net.romnom.mc.flooder.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.romnom.mc.flooder.NotSupportedOperationException;

public class Packet3Chat extends Packet {
	
	public String message;
	
	public Packet3Chat() {
		
	}
	
	public Packet3Chat(String message) {
		this.message = message;
	}

	@Override
	public int getId() {
		return 0x3;
	}

        public int getSize() {
            return message.length();
        }
        
	@Override
	public void read(DataInputStream buf) throws IOException, NotSupportedOperationException {
            int length = buf.readShort();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) sb.append(buf.readChar());
            message = sb.toString();
	}

	@Override
	public void write(DataOutputStream buf) throws IOException, NotSupportedOperationException {
            buf.writeShort(message.length());
            for(int i = 0; i < message.length(); ++i) {
                buf.writeChar(message.charAt(i));
            }
	}

}
