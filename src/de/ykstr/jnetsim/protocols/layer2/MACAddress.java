package de.ykstr.jnetsim.protocols.layer2;

public class MACAddress {
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
}
