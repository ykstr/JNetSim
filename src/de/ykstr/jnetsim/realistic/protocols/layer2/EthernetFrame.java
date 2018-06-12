package de.ykstr.jnetsim.realistic.protocols.layer2;

import de.ykstr.jnetsim.realistic.protocols.ByteRepresentable;
import de.ykstr.jnetsim.realistic.protocols.layer3.Layer3;

public class EthernetFrame implements ByteRepresentable{
    byte[] preamble = new byte[7];
    byte SOF;
    MACAddress source;
    MACAddress target;
    byte[] length = new byte[2];
    Layer3 payload; //0-1500
    byte pad; //0-46
    byte[] checksum = new byte[4];

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EthernetFrame\n");
        sb.append("Source-MAC: "+source+"\n");
        sb.append("Target-MAC: "+target+"\n");
        sb.append(payload);
        return sb.toString();
    }

    @Override
    public byte[] getByteRepresentation() {
        return new byte[0];
    }
}
