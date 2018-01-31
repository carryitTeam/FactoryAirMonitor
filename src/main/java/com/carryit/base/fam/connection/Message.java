/**
 * 
 */
package com.carryit.base.fam.connection;

import java.io.Serializable;

/**
 * Super message class of all lora message abstraction.
 * @author 10028484
 * @version 0.0.1
 */
public class Message implements Serializable {
	/**
	 * The header of the message.
	 */
	public String header = null;
	
	/**
	 * The content of the message.
	 */
	public String content = null;

	/**
	 * Default constructor.
	 */
	public Message(){
		// TODO Auto-generated constructor stub		
	}
	
	/**
	 * Method to get header string.
	 * @return The header in string.
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * Method to set the header string.
	 * @param header The string to set in header.
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * Method to get content string.
	 * @return The content in string.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Method to set the content string.
	 * @param content The string to set in content.
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Method to transfer the body and content to a whole message byte array.
	 * @return The message byte array to put in socket.
	 */
	public byte[] trans2Byte(){
		int hlen = this.getHeader().length();
		int clen = this.getContent().length();
		byte[] result = new byte[hlen+clen];
		System.arraycopy(this.getHeader().getBytes(), 0, result, 0, hlen);
		System.arraycopy(this.getContent().getBytes(), 0, result, hlen, clen);
		return result;
	}

}
