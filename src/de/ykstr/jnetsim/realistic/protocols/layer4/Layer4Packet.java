package de.ykstr.jnetsim.realistic.protocols.layer4;

public class Layer4Packet implements Layer4{

    String payload;
    public Layer4Packet(String data){
        this.payload = data;
    }

    @Override
    public String toString() {
        return "Layer4Packet\n"+payload;
    }


    @Override
    public byte getSize() {
        return 0;
    }

    @Override
    public byte[] getByteRepresentation() {
        return new byte[0];
    }
}
