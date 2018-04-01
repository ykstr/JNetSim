package de.ykstr.jnetsim.protocols.layer3.IP;

public class IPFrameHeader {

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

    private void setHeaderLength(byte l){
        versionAndHeaderLength = (byte)((versionAndHeaderLength & 0b11110000)|l);
    }

    public short calculateHeaderLength(){
        return (short)(5+options.length);
    }

    public void setPrecedence(byte p){
        p = (byte)(p<<5);
        serviceType = (byte)((serviceType & 0b00011111)|p);
    }

    //TODO: implement for other servicetype flags...
    public void setDelayFlag(boolean flag){
        byte mask = (byte)0b00010000;
        if(flag){
            serviceType = (byte)((serviceType | mask));
        }else {
            serviceType = (byte) ((serviceType & (mask^0xFF)));
        }
    }

    public void setDFFlag(boolean df){
        short mask = (short)(1<<14);
        if(df){
            fragmentInformation = (byte)(serviceType | mask);
        }else {
            serviceType = (byte) (serviceType & (mask^0xFFFF));
        }
    }

    public void setMFFlag(boolean mf){
        short mask = (short)(1<<13);
        if(mf){
            fragmentInformation = (byte)(serviceType | mask);
        }else {
            serviceType = (byte) (serviceType & (mask^0xFFFF));
        }
    }

    public void setProtocol(ProtocolType t){
        if(t == null)return;
        protocol = t.type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IPFrameHeader\n");
        sb.append("Version: "+getVersion()+"\n");
        sb.append("ttl: "+ttl+"\n");

        for(ProtocolType t : ProtocolType.values()){
            if(t.type == protocol){
                sb.append("Protocol: "+t.name()+"\n");
            }
        }
        sb.append("Source-IP: "+source+"\n");
        sb.append("Target-IP: "+target+"\n");
        return sb.toString();
    }
}
