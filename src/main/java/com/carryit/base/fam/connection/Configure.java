package com.carryit.base.fam.connection;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the class which is configuring the whole system
 *
 * @author 10028484
 */
public class Configure {

    public final static String DEFAULT_APPEUI = "1112131415161718";

    public final static String DEFAULT_NOPNCE = "12345678";

    public final static String DEFAULT_KEY = "1234";

    public final static String DEFAULT_PAYLOAD = "XXXXX";

    public final static String DEFAULT_DEVEUI = "4a770066fffe73";

    public final static short APPEUI_LEN = 16;

    public final static short NONCE_LEN = 8;

    public final static String DEFAULT_APPKEY = "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";

    public final static int DEFAULT_CMDSEQ = 1;

    public final static int DEFAULT_PORT = 30002;

    public final static int DEFAULT_MESSAGE_PORT = 10;

    public final static String DEFAULT_HOSTIP = "139.129.216.128";

    public final static int MAX_HEADER = 5;

    public final static String DEFAULT_IOTHOST = "msp02.claaiot.com";

    public final static String DEFAULT_IOTHOSTIP = "139.129.216.128";

    public final static int DEFAULT_IOTSSLPort = 30001;

    public final static int DEFAULT_IOTPort = 30002;

    public static int cmdseq_counter = DEFAULT_CMDSEQ;

    public static String hostip = DEFAULT_HOSTIP;

    public static int port = DEFAULT_PORT;

    public static String comm_type = "TCP";

    private static InetSocketAddress ADDRESS = new InetSocketAddress(DEFAULT_HOSTIP, DEFAULT_PORT);


    /**
     * Default constructor
     */
    public Configure() {
        // TODO Auto-generated constructor stub
    }


    public boolean setSystem() {
        return false;
    }

    /**
     * Get the address transfered to InetAddress.
     *
     * @return InetAddress format.
     * @throws UnknownHostException
     */
    public static InetAddress getADDRESS() throws UnknownHostException {
        return InetAddress.getByName("139.129.216.128");
    }

    public static void setADDRESS(InetSocketAddress dEFAULT_ADDRESS) {
        ADDRESS = dEFAULT_ADDRESS;
    }

    /**
     * Method to read conf.properties to acquire the ip and port of CSIF.
     *
     * @throws IOException
     */
    public static void readConf() throws IOException {
        File file = new File("./conf.properties");
        if ((!file.exists()) || (file.isDirectory())) {
            throw new FileNotFoundException();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String tmp = null;
        tmp = br.readLine();
        Map<String, String> map = new HashMap<String, String>();
        String[] keyval = null;
        while (tmp != null) {
            keyval = tmp.split("=");
            map.put(keyval[0], keyval[1]);
            tmp = br.readLine();
        }
        if (map.get("CSIF_IP") != null) {
            Configure.hostip = map.get("CSIF_IP");
        }
        if (map.get("CSIF_PORT") != null) {
            Configure.port = Integer.parseInt(map.get("CSIF_PORT"));
        }
        if (map.get("COMM_TYPE") != null) {
            Configure.comm_type = map.get("COMM_TYPE");
        }
        ADDRESS = new InetSocketAddress(hostip, port);
    }

}
