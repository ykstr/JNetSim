package de.ykstr.jnetsim.realistic.protocols.layer3.IP;

import de.ykstr.jnetsim.realistic.protocols.ByteRepresentable;

public class IPAddress implements ByteRepresentable{
    private int address = 0;

    public IPAddress(String ip){
        String[] parts = ip.split("\\.");
        for(int i = 0; i < parts.length; i++){
            address = address|Integer.parseInt(parts[i], 10);
            if(i != parts.length-1){
                address = address << 8;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int mask = 0xFF000000; //32 Bit == 4 Byte, 1 Byte == 2 Hex
        for(int i = 3; i >= 0; i--){
            int part = (address & mask) >>> (i*8);
            mask = mask >>> 8;
            sb.append(part);
            if(i > 0)sb.append(".");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof IPAddress))return false;
        IPAddress other = (IPAddress)obj;
        return other.address == this.address;
    }

    @Override
    public byte[] getByteRepresentation() {
        return new byte[0];
    }
}
