package de.ykstr.jnetsim.layer2;

public class MACAddress {
    private int address;

    public MACAddress(String address){
        this.address = Integer.parseInt(address,16);
    }
}
