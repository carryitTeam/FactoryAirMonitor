package com.carryit.base.fam.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class Base64UtilsTest {

    @Test
    public void hexToChar() {
        String ts = Base64Utils.HexToChar("6B000303FF108016");
        String dd = Base64Utils.base64Encode(ts);
        System.out.println(dd);
    }
}