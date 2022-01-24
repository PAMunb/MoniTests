package br.unb.cic.mop.bench02.http;

import java.net.URL;

public class HttpProtocolCase1Corrected {
    public static void main(String[] args) throws Exception {
        String url = "https://www.google.com";
        System.out.println(new URL(url));
    }
}
