package de.ykstr.jnetsim.layer2;

public class EthernetFrame {
    byte[] preamble = new byte[7];
    byte SOF;
    MACAddress source;
    MACAddress target;
    byte[] length = new byte[2];
    byte[] data; //0-1500
    byte pad; //0-46
    byte[] checksum = new byte[4];


}
