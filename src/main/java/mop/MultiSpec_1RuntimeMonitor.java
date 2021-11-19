package mop;
import java.security.Key;
import javax.crypto.Cipher;
import br.unb.cic.mop.jca.eh.*;
import static br.unb.cic.mop.jca.util.CipherTransformationUtil.*;
import br.unb.cic.mop.jca.util.ExecutionContext;
import javax.crypto.CipherInputStream;
import java.io.InputStream;
import javax.crypto.CipherOutputStream;
import java.io.OutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.MessageDigest;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
import java.lang.ref.*;
import com.runtimeverification.rvmonitor.java.rt.*;
import com.runtimeverification.rvmonitor.java.rt.ref.*;
import com.runtimeverification.rvmonitor.java.rt.table.*;
import com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractIndexingTree;
import com.runtimeverification.rvmonitor.java.rt.tablebase.SetEventDelegator;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple2;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple3;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IDisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IMonitor;
import com.runtimeverification.rvmonitor.java.rt.tablebase.DisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TerminatedMonitorCleaner;
import java.util.concurrent.atomic.AtomicInteger;

final class BlockCipherSpecMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<BlockCipherSpecMonitor> {

	BlockCipherSpecMonitor_Set(){
		this.size = 0;
		this.elements = new BlockCipherSpecMonitor[4];
	}
	final void event_g1(String transformation) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			BlockCipherSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final BlockCipherSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_g1(transformation);
				if(monitorfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_invalidGetInstance(String transformation) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			BlockCipherSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final BlockCipherSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_invalidGetInstance(transformation);
				if(monitorfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_i3(int mode, java.security.Key key) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			BlockCipherSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final BlockCipherSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_i3(mode, key);
				if(monitorfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_u1(byte[] plainText) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			BlockCipherSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final BlockCipherSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_u1(plainText);
				if(monitorfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_f1() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			BlockCipherSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final BlockCipherSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_f1();
				if(monitorfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}
final class CipherInputStreamSpecMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<CipherInputStreamSpecMonitor> {

	CipherInputStreamSpecMonitor_Set(){
		this.size = 0;
		this.elements = new CipherInputStreamSpecMonitor[4];
	}
	final void event_c1() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CipherInputStreamSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final CipherInputStreamSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_c1();
				if(monitorfinalMonitor.CipherInputStreamSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_r1() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CipherInputStreamSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final CipherInputStreamSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_r1();
				if(monitorfinalMonitor.CipherInputStreamSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_r2(byte[] arr, int offset, int len) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CipherInputStreamSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final CipherInputStreamSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_r2(arr, offset, len);
				if(monitorfinalMonitor.CipherInputStreamSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_cl1() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CipherInputStreamSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final CipherInputStreamSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_cl1();
				if(monitorfinalMonitor.CipherInputStreamSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}
final class CipherOutputStreamSpecMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<CipherOutputStreamSpecMonitor> {

	CipherOutputStreamSpecMonitor_Set(){
		this.size = 0;
		this.elements = new CipherOutputStreamSpecMonitor[4];
	}
	final void event_c1() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CipherOutputStreamSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final CipherOutputStreamSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_c1();
				if(monitorfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_w1() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CipherOutputStreamSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final CipherOutputStreamSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_w1();
				if(monitorfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_w2(byte[] b, int off, int len) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CipherOutputStreamSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final CipherOutputStreamSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_w2(b, off, len);
				if(monitorfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_fl() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CipherOutputStreamSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final CipherOutputStreamSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_fl();
				if(monitorfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_cl() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CipherOutputStreamSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final CipherOutputStreamSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_cl();
				if(monitorfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}
final class KeyGeneratorSpecMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<KeyGeneratorSpecMonitor> {

	KeyGeneratorSpecMonitor_Set(){
		this.size = 0;
		this.elements = new KeyGeneratorSpecMonitor[4];
	}
	final void event_g1(String alg, KeyGenerator k) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			KeyGeneratorSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final KeyGeneratorSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_g1(alg, k);
				if(monitorfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_unsafeAlgorithm(String alg, KeyGenerator k) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			KeyGeneratorSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final KeyGeneratorSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_unsafeAlgorithm(alg, k);
				if(monitorfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_g2(String alg, String prov, KeyGenerator k) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			KeyGeneratorSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final KeyGeneratorSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_g2(alg, prov, k);
				if(monitorfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_init(KeyGenerator k) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			KeyGeneratorSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final KeyGeneratorSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_init(k);
				if(monitorfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_gk1(KeyGenerator k, SecretKey key) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			KeyGeneratorSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final KeyGeneratorSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_gk1(k, key);
				if(monitorfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}
final class MessageDigestSpecMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<MessageDigestSpecMonitor> {

	MessageDigestSpecMonitor_Set(){
		this.size = 0;
		this.elements = new MessageDigestSpecMonitor[4];
	}
	final void event_g1(String alg) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			MessageDigestSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final MessageDigestSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_g1(alg);
				if(monitorfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_g2(String alg) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			MessageDigestSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final MessageDigestSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_g2(alg);
				if(monitorfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_update() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			MessageDigestSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final MessageDigestSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_update();
				if(monitorfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_reset() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			MessageDigestSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final MessageDigestSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_reset();
				if(monitorfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_digest() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			MessageDigestSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final MessageDigestSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_digest();
				if(monitorfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}
final class SecureRandomSpecMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<SecureRandomSpecMonitor> {

	SecureRandomSpecMonitor_Set(){
		this.size = 0;
		this.elements = new SecureRandomSpecMonitor[4];
	}
	final void event_c1() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			SecureRandomSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final SecureRandomSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_c1();
				if(monitorfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_g1(String alg, SecureRandom r) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			SecureRandomSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final SecureRandomSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_g1(alg, r);
				if(monitorfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_g2(SecureRandom r) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			SecureRandomSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final SecureRandomSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_g2(r);
				if(monitorfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_g3(String alg, SecureRandom r) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			SecureRandomSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final SecureRandomSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_g3(alg, r);
				if(monitorfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_s1(SecureRandom r) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			SecureRandomSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final SecureRandomSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_s1(r);
				if(monitorfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_s2(SecureRandom r) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			SecureRandomSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final SecureRandomSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_s2(r);
				if(monitorfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_next(SecureRandom r) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			SecureRandomSpecMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final SecureRandomSpecMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_next(r);
				if(monitorfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
					monitorfinalMonitor.Prop_1_handler_fail();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}

class BlockCipherSpecMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			BlockCipherSpecMonitor ret = (BlockCipherSpecMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static final int Prop_1_transition_g1[] = {1, 5, 5, 5, 5, 5};;
	static final int Prop_1_transition_invalidGetInstance[] = {5, 5, 5, 5, 5, 5};;
	static final int Prop_1_transition_i3[] = {5, 4, 5, 5, 5, 5};;
	static final int Prop_1_transition_u1[] = {5, 5, 5, 5, 2, 5};;
	static final int Prop_1_transition_f1[] = {5, 5, 3, 5, 5, 5};;

	volatile boolean BlockCipherSpecMonitor_Prop_1_Category_fail = false;

	private AtomicInteger pairValue;

	BlockCipherSpecMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0));

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get());
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get());
	}
	private final int getState(int pairValue) {
		return (pairValue & 7);
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 3);
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1)<< 3)| state);
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get();
			int oldstate = this.getState(oldpairvalue);
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate);
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue)) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_g1(String transformation) {
		{
			if ( ! (isValid(transformation)) ) {
				return false;
			}
			{
			}
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_g1);
		this.BlockCipherSpecMonitor_Prop_1_Category_fail = nextstate == 5;

		return true;
	}

	final boolean Prop_1_event_invalidGetInstance(String transformation) {
		{
			if ( ! (!isValid(transformation)) ) {
				return false;
			}
			{
				ErrorCollector.instance().addError(new ErrorDescription(ErrorType.UnsafeAlgorithm, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode(), "expecting one of {AES/CBC/PKCS5Padding, AES/PCBC/ISO10126Padding, ...} but found " + transformation + "."));
			}
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_invalidGetInstance);
		this.BlockCipherSpecMonitor_Prop_1_Category_fail = nextstate == 5;

		return true;
	}

	final boolean Prop_1_event_i3(int mode, java.security.Key key) {
		{
			if ( ! (ExecutionContext.instance().validate(ExecutionContext.Property.GENERATED_KEY, key)) ) {
				return false;
			}
			{
			}
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_i3);
		this.BlockCipherSpecMonitor_Prop_1_Category_fail = nextstate == 5;

		return true;
	}

	final boolean Prop_1_event_u1(byte[] plainText) {
		{
		}

		int nextstate = this.handleEvent(3, Prop_1_transition_u1);
		this.BlockCipherSpecMonitor_Prop_1_Category_fail = nextstate == 5;

		return true;
	}

	final boolean Prop_1_event_f1() {
		{
		}

		int nextstate = this.handleEvent(4, Prop_1_transition_f1);
		this.BlockCipherSpecMonitor_Prop_1_Category_fail = nextstate == 5;

		return true;
	}

	final void Prop_1_handler_fail (){
		{
			ErrorCollector.instance().addError(new ErrorDescription(ErrorType.InvalidSequenceOfMethodCalls, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode()));
			this.reset();
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0));

		BlockCipherSpecMonitor_Prop_1_Category_fail = false;
	}

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//g1
			return;
			case 1:
			//invalidGetInstance
			return;
			case 2:
			//i3
			return;
			case 3:
			//u1
			return;
			case 4:
			//f1
			return;
		}
		return;
	}

	public static int getNumberOfEvents() {
		return 5;
	}

	public static int getNumberOfStates() {
		return 6;
	}

}
class CipherInputStreamSpecMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			CipherInputStreamSpecMonitor ret = (CipherInputStreamSpecMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static final int Prop_1_transition_c1[] = {3, 4, 4, 4, 4};;
	static final int Prop_1_transition_r1[] = {4, 4, 2, 2, 4};;
	static final int Prop_1_transition_r2[] = {4, 4, 2, 2, 4};;
	static final int Prop_1_transition_cl1[] = {4, 4, 1, 4, 4};;

	volatile boolean CipherInputStreamSpecMonitor_Prop_1_Category_fail = false;

	private AtomicInteger pairValue;

	CipherInputStreamSpecMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0));

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get());
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get());
	}
	private final int getState(int pairValue) {
		return (pairValue & 7);
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 3);
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1)<< 3)| state);
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get();
			int oldstate = this.getState(oldpairvalue);
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate);
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue)) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_c1() {
		{
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_c1);
		this.CipherInputStreamSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_r1() {
		{
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_r1);
		this.CipherInputStreamSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_r2(byte[] arr, int offset, int len) {
		{
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_r2);
		this.CipherInputStreamSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_cl1() {
		{
		}

		int nextstate = this.handleEvent(3, Prop_1_transition_cl1);
		this.CipherInputStreamSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final void Prop_1_handler_fail (){
		{
			ErrorCollector.instance().addError(new ErrorDescription(ErrorType.InvalidSequenceOfMethodCalls, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode()));
			this.reset();
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0));

		CipherInputStreamSpecMonitor_Prop_1_Category_fail = false;
	}

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//c1
			return;
			case 1:
			//r1
			return;
			case 2:
			//r2
			return;
			case 3:
			//cl1
			return;
		}
		return;
	}

	public static int getNumberOfEvents() {
		return 4;
	}

	public static int getNumberOfStates() {
		return 5;
	}

}
class CipherOutputStreamSpecMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			CipherOutputStreamSpecMonitor ret = (CipherOutputStreamSpecMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static final int Prop_1_transition_c1[] = {3, 4, 4, 4, 4};;
	static final int Prop_1_transition_w1[] = {4, 1, 4, 1, 4};;
	static final int Prop_1_transition_w2[] = {4, 1, 4, 1, 4};;
	static final int Prop_1_transition_fl[] = {4, 1, 4, 1, 4};;
	static final int Prop_1_transition_cl[] = {4, 2, 4, 4, 4};;

	volatile boolean CipherOutputStreamSpecMonitor_Prop_1_Category_fail = false;

	private AtomicInteger pairValue;

	CipherOutputStreamSpecMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0));

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get());
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get());
	}
	private final int getState(int pairValue) {
		return (pairValue & 7);
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 3);
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1)<< 3)| state);
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get();
			int oldstate = this.getState(oldpairvalue);
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate);
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue)) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_c1() {
		{
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_c1);
		this.CipherOutputStreamSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_w1() {
		{
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_w1);
		this.CipherOutputStreamSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_w2(byte[] b, int off, int len) {
		{
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_w2);
		this.CipherOutputStreamSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_fl() {
		{
		}

		int nextstate = this.handleEvent(3, Prop_1_transition_fl);
		this.CipherOutputStreamSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_cl() {
		{
		}

		int nextstate = this.handleEvent(4, Prop_1_transition_cl);
		this.CipherOutputStreamSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final void Prop_1_handler_fail (){
		{
			ErrorCollector.instance().addError(new ErrorDescription(ErrorType.InvalidSequenceOfMethodCalls, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode()));
			this.reset();
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0));

		CipherOutputStreamSpecMonitor_Prop_1_Category_fail = false;
	}

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//c1
			return;
			case 1:
			//w1
			return;
			case 2:
			//w2
			return;
			case 3:
			//fl
			return;
			case 4:
			//cl
			return;
		}
		return;
	}

	public static int getNumberOfEvents() {
		return 5;
	}

	public static int getNumberOfStates() {
		return 5;
	}

}
class KeyGeneratorSpecMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			KeyGeneratorSpecMonitor ret = (KeyGeneratorSpecMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	List<String> algorithms = Arrays.asList("AES", "HmacSHA256", "HmacSHA384", "HmacSHA512");

	static final int Prop_1_transition_g1[] = {1, 4, 4, 4, 4};;
	static final int Prop_1_transition_unsafeAlgorithm[] = {4, 4, 4, 4, 4};;
	static final int Prop_1_transition_g2[] = {1, 4, 4, 4, 4};;
	static final int Prop_1_transition_init[] = {4, 3, 4, 4, 4};;
	static final int Prop_1_transition_gk1[] = {4, 4, 4, 2, 4};;

	volatile boolean KeyGeneratorSpecMonitor_Prop_1_Category_fail = false;

	private AtomicInteger pairValue;

	KeyGeneratorSpecMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0));

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get());
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get());
	}
	private final int getState(int pairValue) {
		return (pairValue & 7);
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 3);
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1)<< 3)| state);
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get();
			int oldstate = this.getState(oldpairvalue);
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate);
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue)) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_g1(String alg, KeyGenerator k) {
		{
			if ( ! (algorithms.contains(alg)) ) {
				return false;
			}
			{
			}
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_g1);
		this.KeyGeneratorSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_unsafeAlgorithm(String alg, KeyGenerator k) {
		{
			if ( ! (!algorithms.contains(alg)) ) {
				return false;
			}
			{
				ErrorCollector.instance().addError(new ErrorDescription(ErrorType.UnsafeAlgorithm, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode(), "one of" + String.join(",", algorithms) + " but found " + alg + "."));
			}
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_unsafeAlgorithm);
		this.KeyGeneratorSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_g2(String alg, String prov, KeyGenerator k) {
		{
			if ( ! (!algorithms.contains(alg)) ) {
				return false;
			}
			{
			}
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_g2);
		this.KeyGeneratorSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_init(KeyGenerator k) {
		{
		}

		int nextstate = this.handleEvent(3, Prop_1_transition_init);
		this.KeyGeneratorSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_gk1(KeyGenerator k, SecretKey key) {
		{
			ExecutionContext.instance().setProperty(ExecutionContext.Property.GENERATED_KEY, key);
		}

		int nextstate = this.handleEvent(4, Prop_1_transition_gk1);
		this.KeyGeneratorSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final void Prop_1_handler_fail (){
		{
			ErrorCollector.instance().addError(new ErrorDescription(ErrorType.InvalidSequenceOfMethodCalls, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode()));
			ExecutionContext.instance().remove(ExecutionContext.Property.GENERATED_KEY);
			this.reset();
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0));

		KeyGeneratorSpecMonitor_Prop_1_Category_fail = false;
	}

	// RVMRef_k was suppressed to reduce memory overhead

	//alive_parameters_0 = [KeyGenerator k]
	boolean alive_parameters_0 = true;

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
			case 0:
			alive_parameters_0 = false;
			break;
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//g1
			//alive_k
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

			case 1:
			//unsafeAlgorithm
			//alive_k
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

			case 2:
			//g2
			//alive_k
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

			case 3:
			//init
			//alive_k
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

			case 4:
			//gk1
			//alive_k
			if(!(alive_parameters_0)){
				RVM_terminated = true;
				return;
			}
			break;

		}
		return;
	}

	public static int getNumberOfEvents() {
		return 5;
	}

	public static int getNumberOfStates() {
		return 5;
	}

}
class MessageDigestSpecMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			MessageDigestSpecMonitor ret = (MessageDigestSpecMonitor) super.clone();
			ret.pairValue = new AtomicInteger(pairValue.get());
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	List<String> algorithms = Arrays.asList("SHA-256", "SHA-384", "SHA-512");

	static final int Prop_1_transition_g1[] = {1, 4, 4, 4, 4};;
	static final int Prop_1_transition_g2[] = {4, 4, 4, 4, 4};;
	static final int Prop_1_transition_update[] = {4, 3, 4, 3, 4};;
	static final int Prop_1_transition_reset[] = {4, 4, 2, 2, 4};;
	static final int Prop_1_transition_digest[] = {4, 4, 3, 3, 4};;

	volatile boolean MessageDigestSpecMonitor_Prop_1_Category_fail = false;

	private AtomicInteger pairValue;

	MessageDigestSpecMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0));

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get());
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get());
	}
	private final int getState(int pairValue) {
		return (pairValue & 7);
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 3);
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1)<< 3)| state);
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get();
			int oldstate = this.getState(oldpairvalue);
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate);
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue)) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_g1(String alg) {
		{
			if ( ! (algorithms.contains(alg.toUpperCase())) ) {
				return false;
			}
			{
			}
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_g1);
		this.MessageDigestSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_g2(String alg) {
		{
			if ( ! (!algorithms.contains(alg.toUpperCase())) ) {
				return false;
			}
			{
				ErrorCollector.instance().addError(new ErrorDescription(ErrorType.UnsafeAlgorithm, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode(), "one of {SHA-256, SHA-384, SHA-512} but found " + alg + "."));
			}
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_g2);
		this.MessageDigestSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_update() {
		{
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_update);
		this.MessageDigestSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_reset() {
		{
		}

		int nextstate = this.handleEvent(3, Prop_1_transition_reset);
		this.MessageDigestSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final boolean Prop_1_event_digest() {
		{
		}

		int nextstate = this.handleEvent(4, Prop_1_transition_digest);
		this.MessageDigestSpecMonitor_Prop_1_Category_fail = nextstate == 4;

		return true;
	}

	final void Prop_1_handler_fail (){
		{
			ErrorCollector.instance().addError(new ErrorDescription(ErrorType.InvalidSequenceOfMethodCalls, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode()));
			this.reset();
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0));

		MessageDigestSpecMonitor_Prop_1_Category_fail = false;
	}

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//g1
			return;
			case 1:
			//g2
			return;
			case 2:
			//update
			return;
			case 3:
			//reset
			return;
			case 4:
			//digest
			return;
		}
		return;
	}

	public static int getNumberOfEvents() {
		return 5;
	}

	public static int getNumberOfStates() {
		return 5;
	}

}
interface ISecureRandomSpecMonitor extends IMonitor, IDisableHolder {
}

class SecureRandomSpecDisableHolder extends DisableHolder implements ISecureRandomSpecMonitor {
	SecureRandomSpecDisableHolder(long tau) {
		super(tau);
	}

	@Override
	public final boolean isTerminated() {
		return false;
	}

	@Override
	public int getLastEvent() {
		return -1;
	}

	@Override
	public int getState() {
		return -1;
	}

}

class SecureRandomSpecMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractSynchronizedMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject, ISecureRandomSpecMonitor {
	protected Object clone() {
		try {
			SecureRandomSpecMonitor ret = (SecureRandomSpecMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	List<String> algorithms = Arrays.asList("SHA1PRNG", "Windows-PRNG", "NativePRNG", "NativePRNGBlocking", "NativePRNGNonBlocking", "PKCS11");

	WeakReference Ref_r = null;
	int Prop_1_state;
	static final int Prop_1_transition_c1[] = {3, 3, 3, 3};;
	static final int Prop_1_transition_g1[] = {2, 3, 3, 3};;
	static final int Prop_1_transition_g2[] = {2, 3, 3, 3};;
	static final int Prop_1_transition_g3[] = {3, 3, 3, 3};;
	static final int Prop_1_transition_s1[] = {3, 3, 1, 3};;
	static final int Prop_1_transition_s2[] = {3, 3, 1, 3};;
	static final int Prop_1_transition_next[] = {3, 1, 3, 3};;

	boolean SecureRandomSpecMonitor_Prop_1_Category_fail = false;

	SecureRandomSpecMonitor(long tau) {
		this.tau = tau;
		Prop_1_state = 0;

	}

	@Override
	public final int getState() {
		return Prop_1_state;
	}

	private final long tau;
	private long disable = -1;

	@Override
	public final long getTau() {
		return this.tau;
	}

	@Override
	public final long getDisable() {
		return this.disable;
	}

	@Override
	public final void setDisable(long value) {
		this.disable = value;
	}

	final boolean Prop_1_event_c1() {
		SecureRandom r = null;
		if(Ref_r != null){
			r = (SecureRandom)Ref_r.get();
		}
		{
		}
		RVM_lastevent = 0;

		Prop_1_state = Prop_1_transition_c1[Prop_1_state];
		SecureRandomSpecMonitor_Prop_1_Category_fail = Prop_1_state == 3;
		return true;
	}

	final boolean Prop_1_event_g1(String alg, SecureRandom r) {
		{
			if ( ! (algorithms.contains(alg)) ) {
				return false;
			}
			{
			}
		}
		if(Ref_r == null){
			Ref_r = new WeakReference(r);
		}
		RVM_lastevent = 1;

		Prop_1_state = Prop_1_transition_g1[Prop_1_state];
		SecureRandomSpecMonitor_Prop_1_Category_fail = Prop_1_state == 3;
		return true;
	}

	final boolean Prop_1_event_g2(SecureRandom r) {
		{
		}
		if(Ref_r == null){
			Ref_r = new WeakReference(r);
		}
		RVM_lastevent = 2;

		Prop_1_state = Prop_1_transition_g2[Prop_1_state];
		SecureRandomSpecMonitor_Prop_1_Category_fail = Prop_1_state == 3;
		return true;
	}

	final boolean Prop_1_event_g3(String alg, SecureRandom r) {
		{
			if ( ! (!algorithms.contains(alg)) ) {
				return false;
			}
			{
				ErrorCollector.instance().addError(new ErrorDescription(ErrorType.UnsafeAlgorithm, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode(), "one of " + String.join(",", algorithms) + " but found " + alg + "."));
			}
		}
		if(Ref_r == null){
			Ref_r = new WeakReference(r);
		}
		RVM_lastevent = 3;

		Prop_1_state = Prop_1_transition_g3[Prop_1_state];
		SecureRandomSpecMonitor_Prop_1_Category_fail = Prop_1_state == 3;
		return true;
	}

	final boolean Prop_1_event_s1(SecureRandom r) {
		{
		}
		if(Ref_r == null){
			Ref_r = new WeakReference(r);
		}
		RVM_lastevent = 4;

		Prop_1_state = Prop_1_transition_s1[Prop_1_state];
		SecureRandomSpecMonitor_Prop_1_Category_fail = Prop_1_state == 3;
		return true;
	}

	final boolean Prop_1_event_s2(SecureRandom r) {
		{
		}
		if(Ref_r == null){
			Ref_r = new WeakReference(r);
		}
		RVM_lastevent = 5;

		Prop_1_state = Prop_1_transition_s2[Prop_1_state];
		SecureRandomSpecMonitor_Prop_1_Category_fail = Prop_1_state == 3;
		return true;
	}

	final boolean Prop_1_event_next(SecureRandom r) {
		{
		}
		if(Ref_r == null){
			Ref_r = new WeakReference(r);
		}
		RVM_lastevent = 6;

		Prop_1_state = Prop_1_transition_next[Prop_1_state];
		SecureRandomSpecMonitor_Prop_1_Category_fail = Prop_1_state == 3;
		return true;
	}

	final void Prop_1_handler_fail (){
		{
			ErrorCollector.instance().addError(new ErrorDescription(ErrorType.InvalidSequenceOfMethodCalls, "" + com.runtimeverification.rvmonitor.java.rt.ViolationRecorder.getLineOfCode()));
			this.reset();
		}

	}

	final void reset() {
		RVM_lastevent = -1;
		Prop_1_state = 0;
		SecureRandomSpecMonitor_Prop_1_Category_fail = false;
	}

	// RVMRef_r was suppressed to reduce memory overhead

	@Override
	protected final void terminateInternal(int idnum) {
		switch(idnum){
			case 0:
			break;
		}
		switch(RVM_lastevent) {
			case -1:
			return;
			case 0:
			//c1
			return;
			case 1:
			//g1
			return;
			case 2:
			//g2
			return;
			case 3:
			//g3
			return;
			case 4:
			//s1
			return;
			case 5:
			//s2
			return;
			case 6:
			//next
			return;
		}
		return;
	}

	public static int getNumberOfEvents() {
		return 7;
	}

	public static int getNumberOfStates() {
		return 4;
	}

}

public final class MultiSpec_1RuntimeMonitor implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	private static com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager MultiSpec_1MapManager;
	static {
		MultiSpec_1MapManager = new com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager();
		MultiSpec_1MapManager.start();
	}

	// Declarations for the Lock
	static final ReentrantLock MultiSpec_1_RVMLock = new ReentrantLock();
	static final Condition MultiSpec_1_RVMLock_cond = MultiSpec_1_RVMLock.newCondition();

	// Declarations for Timestamps
	private static long SecureRandomSpec_timestamp = 1;

	private static boolean BlockCipherSpec_activated = false;
	private static boolean CipherInputStreamSpec_activated = false;
	private static boolean CipherOutputStreamSpec_activated = false;
	private static boolean KeyGeneratorSpec_activated = false;
	private static boolean MessageDigestSpec_activated = false;
	private static boolean SecureRandomSpec_activated = false;

	// Declarations for Indexing Trees
	private static final BlockCipherSpecMonitor BlockCipherSpec__Map = new BlockCipherSpecMonitor();

	private static final CipherInputStreamSpecMonitor CipherInputStreamSpec__Map = new CipherInputStreamSpecMonitor();

	private static final CipherOutputStreamSpecMonitor CipherOutputStreamSpec__Map = new CipherOutputStreamSpecMonitor();

	private static Object KeyGeneratorSpec_k_Map_cachekey_k;
	private static KeyGeneratorSpecMonitor KeyGeneratorSpec_k_Map_cachevalue;
	private static final MapOfMonitor<KeyGeneratorSpecMonitor> KeyGeneratorSpec_k_Map = new MapOfMonitor<KeyGeneratorSpecMonitor>(0);

	private static final MessageDigestSpecMonitor MessageDigestSpec__Map = new MessageDigestSpecMonitor();

	private static Object SecureRandomSpec_r_Map_cachekey_r;
	private static SecureRandomSpecMonitor SecureRandomSpec_r_Map_cachevalue;
	private static final MapOfMonitor<SecureRandomSpecMonitor> SecureRandomSpec_r_Map = new MapOfMonitor<SecureRandomSpecMonitor>(0);
	private static final Tuple2<SecureRandomSpecMonitor_Set, SecureRandomSpecMonitor> SecureRandomSpec__Map = new Tuple2<SecureRandomSpecMonitor_Set, SecureRandomSpecMonitor>(new SecureRandomSpecMonitor_Set(), null);

	public static int cleanUp() {
		int collected = 0;
		// indexing trees
		collected += KeyGeneratorSpec_k_Map.cleanUpUnnecessaryMappings();
		collected += SecureRandomSpec_r_Map.cleanUpUnnecessaryMappings();
		return collected;
	}

	// Removing terminated monitors from partitioned sets
	static {
		TerminatedMonitorCleaner.start();
	}
	// Setting the behavior of the runtime library according to the compile-time option
	static {
		RuntimeOption.enableFineGrainedLock(false);
	}

	public static final void BlockCipherSpec_g1Event(String transformation) {
		BlockCipherSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		BlockCipherSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = BlockCipherSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			BlockCipherSpecMonitor created = new BlockCipherSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final BlockCipherSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_g1(transformation);
		if(matchedEntryfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void BlockCipherSpec_invalidGetInstanceEvent(String transformation) {
		BlockCipherSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		BlockCipherSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = BlockCipherSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			BlockCipherSpecMonitor created = new BlockCipherSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final BlockCipherSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_invalidGetInstance(transformation);
		if(matchedEntryfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void BlockCipherSpec_i3Event(int mode, java.security.Key key) {
		BlockCipherSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		BlockCipherSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = BlockCipherSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			BlockCipherSpecMonitor created = new BlockCipherSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final BlockCipherSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_i3(mode, key);
		if(matchedEntryfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void BlockCipherSpec_u1Event(byte[] plainText) {
		BlockCipherSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		BlockCipherSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = BlockCipherSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			BlockCipherSpecMonitor created = new BlockCipherSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final BlockCipherSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_u1(plainText);
		if(matchedEntryfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void BlockCipherSpec_f1Event() {
		BlockCipherSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		BlockCipherSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = BlockCipherSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			BlockCipherSpecMonitor created = new BlockCipherSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final BlockCipherSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_f1();
		if(matchedEntryfinalMonitor.BlockCipherSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void CipherInputStreamSpec_c1Event() {
		CipherInputStreamSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CipherInputStreamSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = CipherInputStreamSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			CipherInputStreamSpecMonitor created = new CipherInputStreamSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final CipherInputStreamSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_c1();
		if(matchedEntryfinalMonitor.CipherInputStreamSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void CipherInputStreamSpec_r1Event() {
		CipherInputStreamSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CipherInputStreamSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = CipherInputStreamSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			CipherInputStreamSpecMonitor created = new CipherInputStreamSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final CipherInputStreamSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_r1();
		if(matchedEntryfinalMonitor.CipherInputStreamSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void CipherInputStreamSpec_r2Event(byte[] arr, int offset, int len) {
		CipherInputStreamSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CipherInputStreamSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = CipherInputStreamSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			CipherInputStreamSpecMonitor created = new CipherInputStreamSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final CipherInputStreamSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_r2(arr, offset, len);
		if(matchedEntryfinalMonitor.CipherInputStreamSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void CipherInputStreamSpec_cl1Event() {
		CipherInputStreamSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CipherInputStreamSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = CipherInputStreamSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			CipherInputStreamSpecMonitor created = new CipherInputStreamSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final CipherInputStreamSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_cl1();
		if(matchedEntryfinalMonitor.CipherInputStreamSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void CipherOutputStreamSpec_c1Event() {
		CipherOutputStreamSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CipherOutputStreamSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = CipherOutputStreamSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			CipherOutputStreamSpecMonitor created = new CipherOutputStreamSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final CipherOutputStreamSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_c1();
		if(matchedEntryfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void CipherOutputStreamSpec_w1Event() {
		CipherOutputStreamSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CipherOutputStreamSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = CipherOutputStreamSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			CipherOutputStreamSpecMonitor created = new CipherOutputStreamSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final CipherOutputStreamSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_w1();
		if(matchedEntryfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void CipherOutputStreamSpec_w2Event(byte[] b, int off, int len) {
		CipherOutputStreamSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CipherOutputStreamSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = CipherOutputStreamSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			CipherOutputStreamSpecMonitor created = new CipherOutputStreamSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final CipherOutputStreamSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_w2(b, off, len);
		if(matchedEntryfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void CipherOutputStreamSpec_flEvent() {
		CipherOutputStreamSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CipherOutputStreamSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = CipherOutputStreamSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			CipherOutputStreamSpecMonitor created = new CipherOutputStreamSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final CipherOutputStreamSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_fl();
		if(matchedEntryfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void CipherOutputStreamSpec_clEvent() {
		CipherOutputStreamSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CipherOutputStreamSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = CipherOutputStreamSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			CipherOutputStreamSpecMonitor created = new CipherOutputStreamSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final CipherOutputStreamSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_cl();
		if(matchedEntryfinalMonitor.CipherOutputStreamSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void KeyGeneratorSpec_g1Event(String alg, KeyGenerator k) {
		KeyGeneratorSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_k = null;
		MapOfMonitor<KeyGeneratorSpecMonitor> matchedLastMap = null;
		KeyGeneratorSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((k == KeyGeneratorSpec_k_Map_cachekey_k)) {
			matchedEntry = KeyGeneratorSpec_k_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_k = new CachedWeakReference(k);
			{
				// FindOrCreateEntry
				MapOfMonitor<KeyGeneratorSpecMonitor> itmdMap = KeyGeneratorSpec_k_Map;
				matchedLastMap = itmdMap;
				KeyGeneratorSpecMonitor node_k = KeyGeneratorSpec_k_Map.getNodeEquivalent(wr_k);
				matchedEntry = node_k;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_k == null)) {
				wr_k = new CachedWeakReference(k);
			}
			// D(X) main:4
			KeyGeneratorSpecMonitor created = new KeyGeneratorSpecMonitor();
			matchedEntry = created;
			matchedLastMap.putNode(wr_k, created);
		}
		// D(X) main:8--9
		final KeyGeneratorSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_g1(alg, k);
		if(matchedEntryfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			KeyGeneratorSpec_k_Map_cachekey_k = k;
			KeyGeneratorSpec_k_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void KeyGeneratorSpec_unsafeAlgorithmEvent(String alg, KeyGenerator k) {
		KeyGeneratorSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_k = null;
		MapOfMonitor<KeyGeneratorSpecMonitor> matchedLastMap = null;
		KeyGeneratorSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((k == KeyGeneratorSpec_k_Map_cachekey_k)) {
			matchedEntry = KeyGeneratorSpec_k_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_k = new CachedWeakReference(k);
			{
				// FindOrCreateEntry
				MapOfMonitor<KeyGeneratorSpecMonitor> itmdMap = KeyGeneratorSpec_k_Map;
				matchedLastMap = itmdMap;
				KeyGeneratorSpecMonitor node_k = KeyGeneratorSpec_k_Map.getNodeEquivalent(wr_k);
				matchedEntry = node_k;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_k == null)) {
				wr_k = new CachedWeakReference(k);
			}
			// D(X) main:4
			KeyGeneratorSpecMonitor created = new KeyGeneratorSpecMonitor();
			matchedEntry = created;
			matchedLastMap.putNode(wr_k, created);
		}
		// D(X) main:8--9
		final KeyGeneratorSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_unsafeAlgorithm(alg, k);
		if(matchedEntryfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			KeyGeneratorSpec_k_Map_cachekey_k = k;
			KeyGeneratorSpec_k_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void KeyGeneratorSpec_g2Event(String alg, String prov, KeyGenerator k) {
		KeyGeneratorSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_k = null;
		MapOfMonitor<KeyGeneratorSpecMonitor> matchedLastMap = null;
		KeyGeneratorSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((k == KeyGeneratorSpec_k_Map_cachekey_k)) {
			matchedEntry = KeyGeneratorSpec_k_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_k = new CachedWeakReference(k);
			{
				// FindOrCreateEntry
				MapOfMonitor<KeyGeneratorSpecMonitor> itmdMap = KeyGeneratorSpec_k_Map;
				matchedLastMap = itmdMap;
				KeyGeneratorSpecMonitor node_k = KeyGeneratorSpec_k_Map.getNodeEquivalent(wr_k);
				matchedEntry = node_k;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_k == null)) {
				wr_k = new CachedWeakReference(k);
			}
			// D(X) main:4
			KeyGeneratorSpecMonitor created = new KeyGeneratorSpecMonitor();
			matchedEntry = created;
			matchedLastMap.putNode(wr_k, created);
		}
		// D(X) main:8--9
		final KeyGeneratorSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_g2(alg, prov, k);
		if(matchedEntryfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			KeyGeneratorSpec_k_Map_cachekey_k = k;
			KeyGeneratorSpec_k_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void KeyGeneratorSpec_initEvent(KeyGenerator k) {
		KeyGeneratorSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_k = null;
		MapOfMonitor<KeyGeneratorSpecMonitor> matchedLastMap = null;
		KeyGeneratorSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((k == KeyGeneratorSpec_k_Map_cachekey_k)) {
			matchedEntry = KeyGeneratorSpec_k_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_k = new CachedWeakReference(k);
			{
				// FindOrCreateEntry
				MapOfMonitor<KeyGeneratorSpecMonitor> itmdMap = KeyGeneratorSpec_k_Map;
				matchedLastMap = itmdMap;
				KeyGeneratorSpecMonitor node_k = KeyGeneratorSpec_k_Map.getNodeEquivalent(wr_k);
				matchedEntry = node_k;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_k == null)) {
				wr_k = new CachedWeakReference(k);
			}
			// D(X) main:4
			KeyGeneratorSpecMonitor created = new KeyGeneratorSpecMonitor();
			matchedEntry = created;
			matchedLastMap.putNode(wr_k, created);
		}
		// D(X) main:8--9
		final KeyGeneratorSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_init(k);
		if(matchedEntryfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			KeyGeneratorSpec_k_Map_cachekey_k = k;
			KeyGeneratorSpec_k_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void KeyGeneratorSpec_gk1Event(KeyGenerator k, SecretKey key) {
		KeyGeneratorSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_k = null;
		MapOfMonitor<KeyGeneratorSpecMonitor> matchedLastMap = null;
		KeyGeneratorSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((k == KeyGeneratorSpec_k_Map_cachekey_k)) {
			matchedEntry = KeyGeneratorSpec_k_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_k = new CachedWeakReference(k);
			{
				// FindOrCreateEntry
				MapOfMonitor<KeyGeneratorSpecMonitor> itmdMap = KeyGeneratorSpec_k_Map;
				matchedLastMap = itmdMap;
				KeyGeneratorSpecMonitor node_k = KeyGeneratorSpec_k_Map.getNodeEquivalent(wr_k);
				matchedEntry = node_k;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_k == null)) {
				wr_k = new CachedWeakReference(k);
			}
			// D(X) main:4
			KeyGeneratorSpecMonitor created = new KeyGeneratorSpecMonitor();
			matchedEntry = created;
			matchedLastMap.putNode(wr_k, created);
		}
		// D(X) main:8--9
		final KeyGeneratorSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_gk1(k, key);
		if(matchedEntryfinalMonitor.KeyGeneratorSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			KeyGeneratorSpec_k_Map_cachekey_k = k;
			KeyGeneratorSpec_k_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void MessageDigestSpec_g1Event(String alg) {
		MessageDigestSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		MessageDigestSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = MessageDigestSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			MessageDigestSpecMonitor created = new MessageDigestSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final MessageDigestSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_g1(alg);
		if(matchedEntryfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void MessageDigestSpec_g2Event(String alg) {
		MessageDigestSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		MessageDigestSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = MessageDigestSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			MessageDigestSpecMonitor created = new MessageDigestSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final MessageDigestSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_g2(alg);
		if(matchedEntryfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void MessageDigestSpec_updateEvent() {
		MessageDigestSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		MessageDigestSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = MessageDigestSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			MessageDigestSpecMonitor created = new MessageDigestSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final MessageDigestSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_update();
		if(matchedEntryfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void MessageDigestSpec_resetEvent() {
		MessageDigestSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		MessageDigestSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = MessageDigestSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			MessageDigestSpecMonitor created = new MessageDigestSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final MessageDigestSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_reset();
		if(matchedEntryfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void MessageDigestSpec_digestEvent() {
		MessageDigestSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		MessageDigestSpecMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = MessageDigestSpec__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			// D(X) main:4
			MessageDigestSpecMonitor created = new MessageDigestSpecMonitor();
			matchedEntry = created;
		}
		// D(X) main:8--9
		final MessageDigestSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_digest();
		if(matchedEntryfinalMonitor.MessageDigestSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void SecureRandomSpec_c1Event() {
		SecureRandomSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		Tuple2<SecureRandomSpecMonitor_Set, SecureRandomSpecMonitor> matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = SecureRandomSpec__Map;
		}
		// D(X) main:1
		SecureRandomSpecMonitor matchedLeaf = matchedEntry.getValue2();
		if ((matchedLeaf == null)) {
			if ((matchedLeaf == null)) {
				// D(X) main:4
				SecureRandomSpecMonitor created = new SecureRandomSpecMonitor(SecureRandomSpec_timestamp++);
				matchedEntry.setValue2(created);
				SecureRandomSpecMonitor_Set enclosingSet = matchedEntry.getValue1();
				enclosingSet.add(created);
			}
			// D(X) main:6
			SecureRandomSpecMonitor disableUpdatedLeaf = matchedEntry.getValue2();
			disableUpdatedLeaf.setDisable(SecureRandomSpec_timestamp++);
		}
		// D(X) main:8--9
		SecureRandomSpecMonitor_Set stateTransitionedSet = matchedEntry.getValue1();
		stateTransitionedSet.event_c1();

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void SecureRandomSpec_g1Event(String alg, SecureRandom r) {
		SecureRandomSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_r = null;
		MapOfMonitor<SecureRandomSpecMonitor> matchedLastMap = null;
		SecureRandomSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((r == SecureRandomSpec_r_Map_cachekey_r)) {
			matchedEntry = SecureRandomSpec_r_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_r = new CachedWeakReference(r);
			{
				// FindOrCreateEntry
				MapOfMonitor<SecureRandomSpecMonitor> itmdMap = SecureRandomSpec_r_Map;
				matchedLastMap = itmdMap;
				SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
				matchedEntry = node_r;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_r == null)) {
				wr_r = new CachedWeakReference(r);
			}
			{
				// D(X) createNewMonitorStates:4 when Dom(theta'') = <>
				SecureRandomSpecMonitor sourceLeaf = null;
				{
					// FindCode
					SecureRandomSpecMonitor itmdLeaf = SecureRandomSpec__Map.getValue2();
					sourceLeaf = itmdLeaf;
				}
				if ((sourceLeaf != null)) {
					boolean definable = true;
					// D(X) defineTo:1--5 for <r>
					if (definable) {
						// FindCode
						SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
						if ((node_r != null)) {
							if (((node_r.getDisable()> sourceLeaf.getTau())|| ((node_r.getTau()> 0)&& (node_r.getTau()< sourceLeaf.getTau())))) {
								definable = false;
							}
						}
					}
					if (definable) {
						// D(X) defineTo:6
						SecureRandomSpecMonitor created = (SecureRandomSpecMonitor)sourceLeaf.clone();
						matchedEntry = created;
						matchedLastMap.putNode(wr_r, created);
						// D(X) defineTo:7 for <>
						{
							// InsertMonitor
							SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
							targetSet.add(created);
						}
					}
				}
			}
			if ((matchedEntry == null)) {
				// D(X) main:4
				SecureRandomSpecMonitor created = new SecureRandomSpecMonitor(SecureRandomSpec_timestamp++);
				matchedEntry = created;
				matchedLastMap.putNode(wr_r, created);
				// D(X) defineNew:5 for <>
				{
					// InsertMonitor
					SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
					targetSet.add(created);
				}
			}
			// D(X) main:6
			matchedEntry.setDisable(SecureRandomSpec_timestamp++);
		}
		// D(X) main:8--9
		final SecureRandomSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_g1(alg, r);
		if(matchedEntryfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			SecureRandomSpec_r_Map_cachekey_r = r;
			SecureRandomSpec_r_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void SecureRandomSpec_g2Event(SecureRandom r) {
		SecureRandomSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_r = null;
		MapOfMonitor<SecureRandomSpecMonitor> matchedLastMap = null;
		SecureRandomSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((r == SecureRandomSpec_r_Map_cachekey_r)) {
			matchedEntry = SecureRandomSpec_r_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_r = new CachedWeakReference(r);
			{
				// FindOrCreateEntry
				MapOfMonitor<SecureRandomSpecMonitor> itmdMap = SecureRandomSpec_r_Map;
				matchedLastMap = itmdMap;
				SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
				matchedEntry = node_r;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_r == null)) {
				wr_r = new CachedWeakReference(r);
			}
			{
				// D(X) createNewMonitorStates:4 when Dom(theta'') = <>
				SecureRandomSpecMonitor sourceLeaf = null;
				{
					// FindCode
					SecureRandomSpecMonitor itmdLeaf = SecureRandomSpec__Map.getValue2();
					sourceLeaf = itmdLeaf;
				}
				if ((sourceLeaf != null)) {
					boolean definable = true;
					// D(X) defineTo:1--5 for <r>
					if (definable) {
						// FindCode
						SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
						if ((node_r != null)) {
							if (((node_r.getDisable()> sourceLeaf.getTau())|| ((node_r.getTau()> 0)&& (node_r.getTau()< sourceLeaf.getTau())))) {
								definable = false;
							}
						}
					}
					if (definable) {
						// D(X) defineTo:6
						SecureRandomSpecMonitor created = (SecureRandomSpecMonitor)sourceLeaf.clone();
						matchedEntry = created;
						matchedLastMap.putNode(wr_r, created);
						// D(X) defineTo:7 for <>
						{
							// InsertMonitor
							SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
							targetSet.add(created);
						}
					}
				}
			}
			if ((matchedEntry == null)) {
				// D(X) main:4
				SecureRandomSpecMonitor created = new SecureRandomSpecMonitor(SecureRandomSpec_timestamp++);
				matchedEntry = created;
				matchedLastMap.putNode(wr_r, created);
				// D(X) defineNew:5 for <>
				{
					// InsertMonitor
					SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
					targetSet.add(created);
				}
			}
			// D(X) main:6
			matchedEntry.setDisable(SecureRandomSpec_timestamp++);
		}
		// D(X) main:8--9
		final SecureRandomSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_g2(r);
		if(matchedEntryfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			SecureRandomSpec_r_Map_cachekey_r = r;
			SecureRandomSpec_r_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void SecureRandomSpec_g3Event(String alg, SecureRandom r) {
		SecureRandomSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_r = null;
		MapOfMonitor<SecureRandomSpecMonitor> matchedLastMap = null;
		SecureRandomSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((r == SecureRandomSpec_r_Map_cachekey_r)) {
			matchedEntry = SecureRandomSpec_r_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_r = new CachedWeakReference(r);
			{
				// FindOrCreateEntry
				MapOfMonitor<SecureRandomSpecMonitor> itmdMap = SecureRandomSpec_r_Map;
				matchedLastMap = itmdMap;
				SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
				matchedEntry = node_r;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_r == null)) {
				wr_r = new CachedWeakReference(r);
			}
			{
				// D(X) createNewMonitorStates:4 when Dom(theta'') = <>
				SecureRandomSpecMonitor sourceLeaf = null;
				{
					// FindCode
					SecureRandomSpecMonitor itmdLeaf = SecureRandomSpec__Map.getValue2();
					sourceLeaf = itmdLeaf;
				}
				if ((sourceLeaf != null)) {
					boolean definable = true;
					// D(X) defineTo:1--5 for <r>
					if (definable) {
						// FindCode
						SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
						if ((node_r != null)) {
							if (((node_r.getDisable()> sourceLeaf.getTau())|| ((node_r.getTau()> 0)&& (node_r.getTau()< sourceLeaf.getTau())))) {
								definable = false;
							}
						}
					}
					if (definable) {
						// D(X) defineTo:6
						SecureRandomSpecMonitor created = (SecureRandomSpecMonitor)sourceLeaf.clone();
						matchedEntry = created;
						matchedLastMap.putNode(wr_r, created);
						// D(X) defineTo:7 for <>
						{
							// InsertMonitor
							SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
							targetSet.add(created);
						}
					}
				}
			}
			if ((matchedEntry == null)) {
				// D(X) main:4
				SecureRandomSpecMonitor created = new SecureRandomSpecMonitor(SecureRandomSpec_timestamp++);
				matchedEntry = created;
				matchedLastMap.putNode(wr_r, created);
				// D(X) defineNew:5 for <>
				{
					// InsertMonitor
					SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
					targetSet.add(created);
				}
			}
			// D(X) main:6
			matchedEntry.setDisable(SecureRandomSpec_timestamp++);
		}
		// D(X) main:8--9
		final SecureRandomSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_g3(alg, r);
		if(matchedEntryfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			SecureRandomSpec_r_Map_cachekey_r = r;
			SecureRandomSpec_r_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void SecureRandomSpec_s1Event(SecureRandom r) {
		SecureRandomSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_r = null;
		MapOfMonitor<SecureRandomSpecMonitor> matchedLastMap = null;
		SecureRandomSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((r == SecureRandomSpec_r_Map_cachekey_r)) {
			matchedEntry = SecureRandomSpec_r_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_r = new CachedWeakReference(r);
			{
				// FindOrCreateEntry
				MapOfMonitor<SecureRandomSpecMonitor> itmdMap = SecureRandomSpec_r_Map;
				matchedLastMap = itmdMap;
				SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
				matchedEntry = node_r;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_r == null)) {
				wr_r = new CachedWeakReference(r);
			}
			{
				// D(X) createNewMonitorStates:4 when Dom(theta'') = <>
				SecureRandomSpecMonitor sourceLeaf = null;
				{
					// FindCode
					SecureRandomSpecMonitor itmdLeaf = SecureRandomSpec__Map.getValue2();
					sourceLeaf = itmdLeaf;
				}
				if ((sourceLeaf != null)) {
					boolean definable = true;
					// D(X) defineTo:1--5 for <r>
					if (definable) {
						// FindCode
						SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
						if ((node_r != null)) {
							if (((node_r.getDisable()> sourceLeaf.getTau())|| ((node_r.getTau()> 0)&& (node_r.getTau()< sourceLeaf.getTau())))) {
								definable = false;
							}
						}
					}
					if (definable) {
						// D(X) defineTo:6
						SecureRandomSpecMonitor created = (SecureRandomSpecMonitor)sourceLeaf.clone();
						matchedEntry = created;
						matchedLastMap.putNode(wr_r, created);
						// D(X) defineTo:7 for <>
						{
							// InsertMonitor
							SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
							targetSet.add(created);
						}
					}
				}
			}
			if ((matchedEntry == null)) {
				// D(X) main:4
				SecureRandomSpecMonitor created = new SecureRandomSpecMonitor(SecureRandomSpec_timestamp++);
				matchedEntry = created;
				matchedLastMap.putNode(wr_r, created);
				// D(X) defineNew:5 for <>
				{
					// InsertMonitor
					SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
					targetSet.add(created);
				}
			}
			// D(X) main:6
			matchedEntry.setDisable(SecureRandomSpec_timestamp++);
		}
		// D(X) main:8--9
		final SecureRandomSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_s1(r);
		if(matchedEntryfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			SecureRandomSpec_r_Map_cachekey_r = r;
			SecureRandomSpec_r_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void SecureRandomSpec_s2Event(SecureRandom r) {
		SecureRandomSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_r = null;
		MapOfMonitor<SecureRandomSpecMonitor> matchedLastMap = null;
		SecureRandomSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((r == SecureRandomSpec_r_Map_cachekey_r)) {
			matchedEntry = SecureRandomSpec_r_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_r = new CachedWeakReference(r);
			{
				// FindOrCreateEntry
				MapOfMonitor<SecureRandomSpecMonitor> itmdMap = SecureRandomSpec_r_Map;
				matchedLastMap = itmdMap;
				SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
				matchedEntry = node_r;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_r == null)) {
				wr_r = new CachedWeakReference(r);
			}
			{
				// D(X) createNewMonitorStates:4 when Dom(theta'') = <>
				SecureRandomSpecMonitor sourceLeaf = null;
				{
					// FindCode
					SecureRandomSpecMonitor itmdLeaf = SecureRandomSpec__Map.getValue2();
					sourceLeaf = itmdLeaf;
				}
				if ((sourceLeaf != null)) {
					boolean definable = true;
					// D(X) defineTo:1--5 for <r>
					if (definable) {
						// FindCode
						SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
						if ((node_r != null)) {
							if (((node_r.getDisable()> sourceLeaf.getTau())|| ((node_r.getTau()> 0)&& (node_r.getTau()< sourceLeaf.getTau())))) {
								definable = false;
							}
						}
					}
					if (definable) {
						// D(X) defineTo:6
						SecureRandomSpecMonitor created = (SecureRandomSpecMonitor)sourceLeaf.clone();
						matchedEntry = created;
						matchedLastMap.putNode(wr_r, created);
						// D(X) defineTo:7 for <>
						{
							// InsertMonitor
							SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
							targetSet.add(created);
						}
					}
				}
			}
			if ((matchedEntry == null)) {
				// D(X) main:4
				SecureRandomSpecMonitor created = new SecureRandomSpecMonitor(SecureRandomSpec_timestamp++);
				matchedEntry = created;
				matchedLastMap.putNode(wr_r, created);
				// D(X) defineNew:5 for <>
				{
					// InsertMonitor
					SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
					targetSet.add(created);
				}
			}
			// D(X) main:6
			matchedEntry.setDisable(SecureRandomSpec_timestamp++);
		}
		// D(X) main:8--9
		final SecureRandomSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_s2(r);
		if(matchedEntryfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			SecureRandomSpec_r_Map_cachekey_r = r;
			SecureRandomSpec_r_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void SecureRandomSpec_nextEvent(SecureRandom r) {
		SecureRandomSpec_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		CachedWeakReference wr_r = null;
		MapOfMonitor<SecureRandomSpecMonitor> matchedLastMap = null;
		SecureRandomSpecMonitor matchedEntry = null;
		boolean cachehit = false;
		if ((r == SecureRandomSpec_r_Map_cachekey_r)) {
			matchedEntry = SecureRandomSpec_r_Map_cachevalue;
			cachehit = true;
		}
		else {
			wr_r = new CachedWeakReference(r);
			{
				// FindOrCreateEntry
				MapOfMonitor<SecureRandomSpecMonitor> itmdMap = SecureRandomSpec_r_Map;
				matchedLastMap = itmdMap;
				SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
				matchedEntry = node_r;
			}
		}
		// D(X) main:1
		if ((matchedEntry == null)) {
			if ((wr_r == null)) {
				wr_r = new CachedWeakReference(r);
			}
			{
				// D(X) createNewMonitorStates:4 when Dom(theta'') = <>
				SecureRandomSpecMonitor sourceLeaf = null;
				{
					// FindCode
					SecureRandomSpecMonitor itmdLeaf = SecureRandomSpec__Map.getValue2();
					sourceLeaf = itmdLeaf;
				}
				if ((sourceLeaf != null)) {
					boolean definable = true;
					// D(X) defineTo:1--5 for <r>
					if (definable) {
						// FindCode
						SecureRandomSpecMonitor node_r = SecureRandomSpec_r_Map.getNodeEquivalent(wr_r);
						if ((node_r != null)) {
							if (((node_r.getDisable()> sourceLeaf.getTau())|| ((node_r.getTau()> 0)&& (node_r.getTau()< sourceLeaf.getTau())))) {
								definable = false;
							}
						}
					}
					if (definable) {
						// D(X) defineTo:6
						SecureRandomSpecMonitor created = (SecureRandomSpecMonitor)sourceLeaf.clone();
						matchedEntry = created;
						matchedLastMap.putNode(wr_r, created);
						// D(X) defineTo:7 for <>
						{
							// InsertMonitor
							SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
							targetSet.add(created);
						}
					}
				}
			}
			if ((matchedEntry == null)) {
				// D(X) main:4
				SecureRandomSpecMonitor created = new SecureRandomSpecMonitor(SecureRandomSpec_timestamp++);
				matchedEntry = created;
				matchedLastMap.putNode(wr_r, created);
				// D(X) defineNew:5 for <>
				{
					// InsertMonitor
					SecureRandomSpecMonitor_Set targetSet = SecureRandomSpec__Map.getValue1();
					targetSet.add(created);
				}
			}
			// D(X) main:6
			matchedEntry.setDisable(SecureRandomSpec_timestamp++);
		}
		// D(X) main:8--9
		final SecureRandomSpecMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_next(r);
		if(matchedEntryfinalMonitor.SecureRandomSpecMonitor_Prop_1_Category_fail) {
			matchedEntryfinalMonitor.Prop_1_handler_fail();
		}

		if ((cachehit == false)) {
			SecureRandomSpec_r_Map_cachekey_r = r;
			SecureRandomSpec_r_Map_cachevalue = matchedEntry;
		}

		MultiSpec_1_RVMLock.unlock();
	}

}
