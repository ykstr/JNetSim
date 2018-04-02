package de.ykstr.jnetsim.protocols.layer3.IP;

import de.ykstr.jnetsim.protocols.ByteRepresentable;
import de.ykstr.jnetsim.protocols.layer3.Layer3;
import de.ykstr.jnetsim.util.ByteUtils;

public class IPFrameHeader implements ByteRepresentable{

    private IPVersion version; //4 bit

    private byte precedence; //3 bit
    private boolean delayFlag;
    private boolean throughputFlag;
    private boolean reliabilityFlag;
    private boolean costFlag;

    private short identification;

    private boolean dontFragmentFlag;
    private boolean moreFragmentsFlag;
    private short fragmentInformation;

    private byte ttl;
    private ProtocolType protocol;
    private byte headerCheckSum;
    private IPAddress source;
    private IPAddress target;
    private int[] options;

    private byte payloadSize;

    public byte mergeVersionAndHeaderLength(){
        return (byte)(version.number << 4 | getHeaderLength());
    }

    public void setVersion(IPVersion version){
        if(version == null)throw new IllegalArgumentException();
        this.version = version;
    }

    public IPVersion getVersion(){
        return version;
    }

    public byte getHeaderLength(){
        return (byte)(5+options.length);
    }

    public void setPrecedence(byte p){
        precedence = p;
    }

    public byte getPrecedence() {
        return precedence;
    }

    public boolean isDelayFlag() {
        return delayFlag;
    }

    public void setDelayFlag(boolean delayFlag) {
        this.delayFlag = delayFlag;
    }

    public boolean isThroughputFlag() {
        return throughputFlag;
    }

    public void setThroughputFlag(boolean throughputFlag) {
        this.throughputFlag = throughputFlag;
    }

    public boolean isReliabilityFlag() {
        return reliabilityFlag;
    }

    public void setReliabilityFlag(boolean reliabilityFlag) {
        this.reliabilityFlag = reliabilityFlag;
    }

    public boolean isCostFlag() {
        return costFlag;
    }

    public void setCostFlag(boolean costFlag) {
        this.costFlag = costFlag;
    }

    public byte getServiceType(){
        int result = precedence << 3;
        if(isDelayFlag()) result |= 0b10000;
        if(isThroughputFlag()) result |= 0b1000;
        if(isReliabilityFlag()) result |= 0b100;
        if(isCostFlag()) result |= 0b10;
        return (byte)result;
    }

    public short getTotalLength(){
        return (short)(getHeaderLength()+payloadSize);
    }

    public short getIdentification() {
        return identification;
    }

    public void setIdentification(short identification) {
        this.identification = identification;
    }

    public boolean isDontFragmentFlag() {
        return dontFragmentFlag;
    }

    public void setDontFragmentFlag(boolean dontFragmentFlag) {
        this.dontFragmentFlag = dontFragmentFlag;
    }

    public boolean isMoreFragmentsFlag() {
        return moreFragmentsFlag;
    }

    public void setMoreFragmentsFlag(boolean moreFragmentsFlag) {
        this.moreFragmentsFlag = moreFragmentsFlag;
    }

    public short getFragmentInformation() {
        return fragmentInformation;
    }

    public void setFragmentInformation(short fragmentInformation) {
        this.fragmentInformation = fragmentInformation;
    }

    public short mergeFragmentInformation(){
        int mask = ~(0b111 << 13);
        int result = fragmentInformation & mask;
        if(isDontFragmentFlag()) result = result | (0b1 << 14);
        if(isMoreFragmentsFlag()) result = result | (0b1 << 13);
        return (short)result;
    }

    public void setProtocol(ProtocolType t){
        if(t == null)throw new IllegalArgumentException();
        protocol = t;
    }

    public void decreaseTTL(){
        if(ttl>0)ttl--;
    }

    public byte getTTL(){
        return ttl;
    }

    public void setTTL(byte ttl){
        this.ttl = ttl;
    }

    public byte getHeaderCheckSum() {
        return headerCheckSum;
    }

    public void setHeaderCheckSum(byte headerCheckSum) {
        this.headerCheckSum = headerCheckSum;
    }

    public IPAddress getSource() {
        return source;
    }

    public void setSource(IPAddress source) {
        this.source = source;
    }

    public IPAddress getTarget() {
        return target;
    }

    public void setTarget(IPAddress target) {
        this.target = target;
    }

    public byte getPayloadSize() {
        return payloadSize;
    }

    public void setPayloadSize(byte payloadSize) {
        this.payloadSize = payloadSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IPFrameHeader\n");
        sb.append("Version: "+getVersion()+"\n");
        sb.append("ttl: "+ttl+"\n");
        sb.append("Protocol: "+protocol.name());
        sb.append("Source-IP: "+source+"\n");
        sb.append("Target-IP: "+target+"\n");
        return sb.toString();
    }

    @Override
    public byte[] getByteRepresentation() {
        byte[] result = ByteUtils.merge(mergeVersionAndHeaderLength(),getServiceType());
        result = ByteUtils.merge(result, ByteUtils.shortToByte(getTotalLength()));
        result = ByteUtils.merge(result, ByteUtils.shortToByte(identification), ByteUtils.shortToByte(mergeFragmentInformation()));
        result = ByteUtils.merge(result, ttl);
        result = ByteUtils.merge(result, protocol.getByteRepresentation(), ByteUtils.shortToByte(headerCheckSum));
        result = ByteUtils.merge(result, source.getByteRepresentation(), target.getByteRepresentation());
        result = ByteUtils.merge(result, ByteUtils.intArrayToByteArray(options));
        return result;
    }
}
