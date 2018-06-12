package de.ykstr.jnetsim.simple.data.layer2;

public class MACAddress {
    public static final String MAC_REGEX = "([0-9A-F]{2}:){5}[0-9A-F]{2}";
    private String mac;

    public MACAddress(String address){
        setMac(address);
    }

    public void setMac(String address) {
        address = address.toUpperCase();
        if(!address.matches(MAC_REGEX))throw new IllegalArgumentException("Wrong format");
        this.mac = address.toUpperCase();
    }
}
