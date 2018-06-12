package de.ykstr.jnetsim.simple.protocols.layer3;

import de.ykstr.jnetsim.realistic.protocols.layer3.IP.IPAddress;
import de.ykstr.jnetsim.simple.protocols.layer4.Layer4Protocol;

public class IP {
    private IPAddress source;
    private IPAddress target;
    private Layer4Protocol payload;
}
