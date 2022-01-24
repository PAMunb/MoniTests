package br.unb.cic.mop.bench02.http;

import java.net.MalformedURLException;

public class HttpProtocolABMCCase1 {
    public static void main(String [] args) throws MalformedURLException {
        HttpProtocolABMC1 hp = new HttpProtocolABMC1();
        String url = "http://www.google.com";
        hp.go(url);

    }
}
