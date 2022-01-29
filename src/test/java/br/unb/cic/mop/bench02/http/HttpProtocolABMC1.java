package br.unb.cic.mop.bench02.http;

import java.net.MalformedURLException;
import java.net.URL;

public class HttpProtocolABMC1 {
    public void go(String url) throws MalformedURLException {
        System.out.println(new URL(url));
    }
}
