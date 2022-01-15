import br.unb.cic.mop.test.Assertions;
import org.junit.Test;

import javax.crypto.spec.DHGenParameterSpec;

public class DHGenParameterSpecTest  {

	@Test
	public void dHGenParameterSpecValidTest1() {

		int exponentSize = 10;
		int primeSize = 20;

		DHGenParameterSpec dHGenParameterSpec0 = new DHGenParameterSpec(primeSize, exponentSize);
		Assertions.hasEnsuredPredicate(dHGenParameterSpec0);
		Assertions.mustBeInAcceptingState(dHGenParameterSpec0);

	}
}