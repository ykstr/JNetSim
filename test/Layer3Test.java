import de.ykstr.jnetsim.protocols.layer3.IP.IPAddress;
import de.ykstr.jnetsim.protocols.layer3.IP.IPFrameHeader;
import de.ykstr.jnetsim.protocols.layer3.IP.IPVersion;

public class Layer3Test {
    public static void main(String[] args) {
        IPAddress ip = new IPAddress("192.168.178.25");
        System.out.println(ip);

        IPFrameHeader frame = new IPFrameHeader();
        frame.setVersion(IPVersion.V4);
        System.out.println(frame.getVersion());
    }
}
