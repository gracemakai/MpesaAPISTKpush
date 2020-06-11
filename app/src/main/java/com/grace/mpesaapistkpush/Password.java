package com.grace.mpesaapistkpush;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Password {

    public String EncodedPassword() throws UnsupportedEncodingException {
        Constants constants = new Constants();
        String Pass = constants.getShortCode() + "+" + constants.getPassKey() +  "+" + "20180409093002";
        byte[] bytes = Pass.getBytes(StandardCharsets.ISO_8859_1);
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

}
