package de.ykstr.jnetsim.protocols.layer3;

public enum IPVersion {
    V4(4), V6(6);

    public final int number;

    IPVersion(int version){
        this.number = version;
    }
}
