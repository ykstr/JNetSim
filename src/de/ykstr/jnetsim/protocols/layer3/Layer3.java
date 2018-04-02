package de.ykstr.jnetsim.protocols.layer3;

import de.ykstr.jnetsim.protocols.ByteRepresentable;

public interface Layer3 extends ByteRepresentable{
    public byte getSize(); //in 32 bit words
}
