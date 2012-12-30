package net.romnom.mc.flooder.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.romnom.mc.flooder.NotSupportedOperationException;

public class Packet1Login extends Packet {
	
	public int entityId;
	public String levelType;
	public byte gameMode;
	public byte dimension;
	public byte difficulty;
	public byte worldHeight;
	public byte maxPlayers;

	@Override
	public int getId() {
		return 0x1;
	}

        @Override
        public int getSize() {
            return 11 + levelType.length();
        }
        
	@Override
	public void read(DataInputStream buf) throws IOException, NotSupportedOperationException {
            entityId = buf.readInt();
            int length = buf.readShort();
            StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) { sb.append(buf.readChar()); }
            levelType = sb.toString();
            gameMode = buf.readByte();
            dimension = buf.readByte();
            difficulty = buf.readByte();
            worldHeight = buf.readByte();
            maxPlayers = buf.readByte();
	}

	@Override
	public void write(DataOutputStream buf) throws IOException, NotSupportedOperationException {
            throw new NotSupportedOperationException();
	}

}
