package de.ykstr.jnetsim.realistic.protocols.layer2;

import de.ykstr.jnetsim.realistic.protocols.ByteRepresentable;

public class MACAddress implements ByteRepresentable{
    private int address;

    public MACAddress(String address){
        this.address = Integer.parseInt(address,16);
    }

    @Override
    public String toString() {
        return Integer.toHexString(address).toUpperCase();
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MACAddress))return false;
        MACAddress other = (MACAddress)obj;
        return other.address == this.address;
    }

    @Override
    public byte[] getByteRepresentation() {
        return new byte[0];
    }
}
