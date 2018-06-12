package de.ykstr.jnetsim.realistic.protocols.layer3;

import de.ykstr.jnetsim.realistic.protocols.ByteRepresentable;

public interface Layer3 extends ByteRepresentable{
    public byte getSize(); //in 32 bit words
}
