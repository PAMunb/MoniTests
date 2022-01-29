package br.unb.cic.mop.eh.logger;

import br.unb.cic.mop.eh.ErrorDescription;

public interface ILogger {

    public void logError(ErrorDescription err);

}
