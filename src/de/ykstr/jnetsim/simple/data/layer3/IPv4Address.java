package de.ykstr.jnetsim.simple.data.layer3;

public class IPv4Address {
    public static final String IPv4_REGEX = "([0-9]{1,3}\\.){3}[0-9]{1,3}";

    private String ip;
    private int ipNumber;

    public IPv4Address(String address){
        setIp(address);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        if(!ip.matches(IPv4_REGEX) || !partsInRange(ip))throw new IllegalArgumentException();
        ip.replaceAll("(?<![1-9])0(?!(\\.|$))","");
        setIpNumber(toInt(ip));
    }

    public int getIpNumber() {
        return ipNumber;
    }

    private void setIpNumber(int ipNumber) {
        this.ipNumber = ipNumber;
    }

    public static int toInt(String ip){
        if(!ip.matches(IPv4_REGEX))throw new IllegalArgumentException();
        int result = 0;
        String[] parts = ip.split("\\.");
        for(int i = 0; i < parts.length; i++){
            int part = Integer.parseInt(parts[i]);
            part = part << 8*(parts.length-1-i);
            result = result|part;
        }

        return result;
    }

    private boolean partsInRange(String ip){
        String[] parts = ip.split("\\.");
        for(String part : parts){
            if(Integer.parseInt(part)>255)return false;
        }
        return true;
    }
}
