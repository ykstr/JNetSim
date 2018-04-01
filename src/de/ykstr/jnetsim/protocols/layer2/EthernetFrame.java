package de.ykstr.jnetsim.protocols.layer2;

import de.ykstr.jnetsim.protocols.layer3.IP.IPFrameHeader;
import de.ykstr.jnetsim.protocols.layer3.Layer3;

public class EthernetFrame {
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
}
