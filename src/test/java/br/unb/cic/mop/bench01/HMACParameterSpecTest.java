package br.unb.cic.mop.bench01;

import br.unb.cic.mop.test.Assertions;
import org.junit.Test;


import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class HMACParameterSpecTest  {

	@Test
	public void hMACParameterSpecValidTest1() {
		int outputLength = 0;

		HMACParameterSpec hMACParameterSpec0 = new HMACParameterSpec(outputLength);
		Assertions.hasEnsuredPredicate(hMACParameterSpec0);
		Assertions.mustBeInAcceptingState(hMACParameterSpec0);

	}

}