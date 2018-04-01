import de.ykstr.jnetsim.protocols.layer3.IPAddress;
import de.ykstr.jnetsim.protocols.layer3.IPFrame;
import de.ykstr.jnetsim.protocols.layer3.IPVersion;

public class Layer3Test {
    public static void main(String[] args) {
        IPAddress ip = new IPAddress("192.168.178.25");
        System.out.println(ip);

        IPFrame frame = new IPFrame();
        frame.setVersion(IPVersion.V4);
        System.out.println(frame.getVersion());
    }
}
