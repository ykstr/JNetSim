package de.ykstr.jnetsim.realistic.protocols.layer3.IP;

import de.ykstr.jnetsim.realistic.protocols.layer3.Layer3;
import de.ykstr.jnetsim.realistic.protocols.layer4.Layer4;
import de.ykstr.jnetsim.realistic.util.ByteUtils;

public class IPPacket implements Layer3{
    IPFrameHeader header;
    Layer4 payload;

    @Override
    public String toString() {
        return "IPPacket\n"+header.toString()+payload.toString();
    }

    @Override
    public byte getSize() {
        return payload.getSize();
    }

    @Override
    public byte[] getByteRepresentation() {
        return ByteUtils.merge(header.getByteRepresentation(), payload.getByteRepresentation());
    }
}
