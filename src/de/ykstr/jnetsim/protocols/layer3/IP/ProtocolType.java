package de.ykstr.jnetsim.protocols.layer3.IP;

public enum ProtocolType {
    IP(4), ICMP(1);

    public final byte type;

    ProtocolType(int i){
        type = (byte)i;
    }
}
