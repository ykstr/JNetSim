package de.ykstr.jnetsim.simple.protocols.layer2;

import de.ykstr.jnetsim.simple.data.layer2.MACAddress;
import de.ykstr.jnetsim.simple.protocols.layer3.Layer3Protocol;

public class Ethernet implements Layer2Protocol {
    private MACAddress source;
    private MACAddress target;
    private Layer3Protocol payload;
}
