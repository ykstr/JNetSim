package de.ykstr.jnetsim.protocols.layer3;

public class IPFrame {

    private byte versionAndHeaderLength; //4 bit each
    private byte serviceType;
    private short length;
    private short identification;
    private short fragmentInformation;
    private byte ttl;
    private byte protocol;
    private byte headerCheckSum;
    private IPAddress source;
    private IPAddress target;
    private int[] options;

    public void setVersion(IPVersion version){
        if(version == null)return;
        versionAndHeaderLength = (byte) (versionAndHeaderLength & 0b00001111); //null version part
        versionAndHeaderLength = (byte)(versionAndHeaderLength | version.number << 4);
    }

    public byte getVersion(){
        return (byte)(versionAndHeaderLength >> 4);
    }
}
