package de.ykstr.jnetsim.realistic.protocols.layer3.IP;

import de.ykstr.jnetsim.realistic.protocols.ByteRepresentable;
import de.ykstr.jnetsim.realistic.util.ByteUtils;

public enum ProtocolType implements ByteRepresentable{
    IP(4), ICMP(1);

    public final byte type;

    ProtocolType(int i){
        type = (byte)i;
    }

    @Override
    public byte[] getByteRepresentation(){
        return ByteUtils.merge(type);
    }
}
