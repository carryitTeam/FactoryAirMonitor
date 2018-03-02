package com.carryit.base.fam.connection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;

/**
 * The class to acquire the connection to CSIF server.
 *
 * @author 10028484
 * @version 0.0.1
 */

public interface Connection extends Serializable {

    /**
     * Method to get the connection to server, acquire the connection clarified by detailed class.
     *
     * @param host The CSIF host address.
     * @param port The CSIF port.
     * @return The Connection object to use.
     * @throws IOException Connect Exception.
     */
    public Object getConnection(String host, int port) throws IOException;

    /**
     * Method to disconnect from CSIF .
     *
     * @return
     * @throws IOException Connect Exception.
     */
    public boolean disconnect() throws IOException;

    public boolean isConnected() throws IOException;

    /**
     * Method to put the byte array data to send to CSIF.
     *
     * @param data Byte array usually encoded in UTF-8.
     * @return
     * @throws IOException Connect Exception.
     */
    public boolean putData(byte[] data) throws IOException;

    /**
     * Method to get the byte array data sent from CSIF.
     *
     * @return
     * @throws IOException Connect Exception.
     */
    public byte[] getData() throws IOException;

    /**
     * Method to test if the connection is closed.
     *
     * @return The status of the connection.
     */
    public boolean isClosed();

}
