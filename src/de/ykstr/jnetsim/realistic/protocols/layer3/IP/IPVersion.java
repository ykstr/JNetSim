package de.ykstr.jnetsim.realistic.protocols.layer3.IP;

import de.ykstr.jnetsim.realistic.protocols.ByteRepresentable;
import de.ykstr.jnetsim.realistic.util.ByteUtils;

public enum IPVersion implements ByteRepresentable{
    V4(4), V6(6);

    public final byte number;

    IPVersion(int version){
        this.number = (byte) version;
    }

    @Override
    public byte[] getByteRepresentation(){
        return ByteUtils.merge(number);
    }
}
