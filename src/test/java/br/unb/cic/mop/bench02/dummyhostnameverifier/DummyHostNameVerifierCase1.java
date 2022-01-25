package br.unb.cic.mop.bench02.dummyhostnameverifier;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class DummyHostNameVerifierCase1 implements HostnameVerifier {
    public boolean verify(String s, SSLSession sslSession) {
        return true;
    }
}
