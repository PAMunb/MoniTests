package br.unb.cic.mop.eh.report;

import br.unb.cic.mop.eh.ErrorDescription;

import java.util.List;
import java.util.Set;

/**
 * An interface for exporting errors in different
 * formats.
 */
public interface IErrorReport {

    public void exportErrors(Set<ErrorDescription> errors) throws Exception;

}
