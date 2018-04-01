package de.ykstr.jnetsim.protocols.layer2;

import de.ykstr.jnetsim.protocols.layer3.IPFrame;

public class EthernetFrame {
    byte[] preamble = new byte[7];
    byte SOF;
    MACAddress source;
    MACAddress target;
    byte[] length = new byte[2];
    IPFrame data; //0-1500
    byte pad; //0-46
    byte[] checksum = new byte[4];


}
