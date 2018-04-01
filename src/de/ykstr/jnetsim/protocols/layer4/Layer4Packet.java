package de.ykstr.jnetsim.protocols.layer4;

public class Layer4Packet implements Layer4{

    String payload;
    public Layer4Packet(String data){
        this.payload = data;
    }

    @Override
    public String toString() {
        return "Layer4Packet\n"+payload;
    }
}
