package de.ykstr.jnetsim.protocols.layer3.IP;

import de.ykstr.jnetsim.protocols.ByteRepresentable;
import de.ykstr.jnetsim.protocols.layer3.Layer3;
import de.ykstr.jnetsim.protocols.layer4.Layer4;

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
        return new byte[0];
    }
}
