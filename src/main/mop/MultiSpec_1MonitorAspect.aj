package mop;
import java.security.Key;
import javax.crypto.Cipher;
import br.unb.cic.mop.jca.eh.*;
import static br.unb.cic.mop.jca.util.CipherTransformationUtil.*;
import br.unb.cic.mop.jca.util.ExecutionContext;
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
import org.aspectj.lang.*;

aspect BaseAspect {
	pointcut notwithin() :
	!within(sun..*) &&
	!within(java..*) &&
	!within(javax..*) &&
	!within(com.sun..*) &&
	!within(org.dacapo.harness..*) &&
	!within(org.apache.commons..*) &&
	!within(org.apache.geronimo..*) &&
	!within(net.sf.cglib..*) &&
	!within(mop..*) &&
	!within(javamoprt..*) &&
	!within(rvmonitorrt..*) &&
	!within(com.runtimeverification..*);
}

public aspect MultiSpec_1MonitorAspect implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	public MultiSpec_1MonitorAspect(){
	}

	// Declarations for the Lock
	static ReentrantLock MultiSpec_1_MOPLock = new ReentrantLock();
	static Condition MultiSpec_1_MOPLock_cond = MultiSpec_1_MOPLock.newCondition();

	pointcut MOP_CommonPointCut() : !within(com.runtimeverification.rvmonitor.java.rt.RVMObject+) && !adviceexecution() && BaseAspect.notwithin();
	pointcut SecureRandomSpec_next(SecureRandom r) : ((call(public int SecureRandom.nextInt(int)) || call(public int SecureRandom.nextInt()) || call(public void SecureRandom.nextBytes(byte[]))) && target(r)) && MOP_CommonPointCut();
	before (SecureRandom r) : SecureRandomSpec_next(r) {
		MultiSpec_1RuntimeMonitor.SecureRandomSpec_nextEvent(r);
	}

	pointcut SecureRandomSpec_s2(SecureRandom r) : (call(public void SecureRandom.setSeed(byte[])) && target(r)) && MOP_CommonPointCut();
	before (SecureRandom r) : SecureRandomSpec_s2(r) {
		MultiSpec_1RuntimeMonitor.SecureRandomSpec_s2Event(r);
	}

	pointcut SecureRandomSpec_s1(SecureRandom r) : (call(public void SecureRandom.setSeed(long)) && target(r)) && MOP_CommonPointCut();
	before (SecureRandom r) : SecureRandomSpec_s1(r) {
		MultiSpec_1RuntimeMonitor.SecureRandomSpec_s1Event(r);
	}

	pointcut MessageDigestSpec_digest() : (call(* MessageDigest.digest())) && MOP_CommonPointCut();
	before () : MessageDigestSpec_digest() {
		MultiSpec_1RuntimeMonitor.MessageDigestSpec_digestEvent();
	}

	pointcut MessageDigestSpec_reset() : (call(* MessageDigest.reset(..))) && MOP_CommonPointCut();
	before () : MessageDigestSpec_reset() {
		MultiSpec_1RuntimeMonitor.MessageDigestSpec_resetEvent();
	}

	pointcut KeyGeneratorSpec_init(KeyGenerator k) : ((call(public void KeyGenerator.init(int)) || call(public void KeyGenerator.init(int, SecureRandom)) || call(public void KeyGenerator.init(AlgorithmParameterSpec)) || call(public void KeyGenerator.init(AlgorithmParameterSpec, SecureRandom)) || call(public void KeyGenerator.init(SecureRandom))) && target(k)) && MOP_CommonPointCut();
	before (KeyGenerator k) : KeyGeneratorSpec_init(k) {
		MultiSpec_1RuntimeMonitor.KeyGeneratorSpec_initEvent(k);
	}

	pointcut BlockCipherSpec_u1(byte[] plainText) : (call(public byte[] Cipher.update(byte[])) && args(plainText)) && MOP_CommonPointCut();
	before (byte[] plainText) : BlockCipherSpec_u1(plainText) {
		MultiSpec_1RuntimeMonitor.BlockCipherSpec_u1Event(plainText);
	}

	pointcut BlockCipherSpec_g1(String transformation) : (call(public static Cipher Cipher.getInstance(String)) && args(transformation)) && MOP_CommonPointCut();
	after (String transformation) : BlockCipherSpec_g1(transformation) {
		//BlockCipherSpec_g1
		MultiSpec_1RuntimeMonitor.BlockCipherSpec_g1Event(transformation);
		//BlockCipherSpec_invalidGetInstance
		MultiSpec_1RuntimeMonitor.BlockCipherSpec_invalidGetInstanceEvent(transformation);
	}

	pointcut BlockCipherSpec_i3(int mode, java.security.Key key) : (call(public void Cipher.init(int, java.security.Key)) && args(mode, key)) && MOP_CommonPointCut();
	after (int mode, java.security.Key key) : BlockCipherSpec_i3(mode, key) {
		MultiSpec_1RuntimeMonitor.BlockCipherSpec_i3Event(mode, key);
	}

	pointcut BlockCipherSpec_f1() : (call(public byte[] Cipher.doFinal()) || call(public byte[] Cipher.doFinal(byte[]))) && MOP_CommonPointCut();
	after () : BlockCipherSpec_f1() {
		MultiSpec_1RuntimeMonitor.BlockCipherSpec_f1Event();
	}

	pointcut KeyGeneratorSpec_g1(String alg) : (call(public static KeyGenerator KeyGenerator.getInstance(String)) && args(alg)) && MOP_CommonPointCut();
	after (String alg) returning (KeyGenerator k) : KeyGeneratorSpec_g1(alg) {
		//KeyGeneratorSpec_g1
		MultiSpec_1RuntimeMonitor.KeyGeneratorSpec_g1Event(alg, k);
		//KeyGeneratorSpec_unsafeAlgorithm
		MultiSpec_1RuntimeMonitor.KeyGeneratorSpec_unsafeAlgorithmEvent(alg, k);
	}

	pointcut KeyGeneratorSpec_g2(String alg, String prov) : (call(public static KeyGenerator KeyGenerator.getInstance(String, String)) && args(alg, prov)) && MOP_CommonPointCut();
	after (String alg, String prov) returning (KeyGenerator k) : KeyGeneratorSpec_g2(alg, prov) {
		MultiSpec_1RuntimeMonitor.KeyGeneratorSpec_g2Event(alg, prov, k);
	}

	pointcut KeyGeneratorSpec_gk1(KeyGenerator k) : (call(public SecretKey KeyGenerator.generateKey()) && target(k)) && MOP_CommonPointCut();
	after (KeyGenerator k) returning (SecretKey key) : KeyGeneratorSpec_gk1(k) {
		MultiSpec_1RuntimeMonitor.KeyGeneratorSpec_gk1Event(k, key);
	}

	pointcut MessageDigestSpec_g1(String alg) : (call(public static MessageDigest MessageDigest.getInstance(String)) && args(alg)) && MOP_CommonPointCut();
	after (String alg) : MessageDigestSpec_g1(alg) {
		//MessageDigestSpec_g1
		MultiSpec_1RuntimeMonitor.MessageDigestSpec_g1Event(alg);
		//MessageDigestSpec_g2
		MultiSpec_1RuntimeMonitor.MessageDigestSpec_g2Event(alg);
	}

	pointcut MessageDigestSpec_update() : (call(* MessageDigest.update(byte[]))) && MOP_CommonPointCut();
	after () : MessageDigestSpec_update() {
		MultiSpec_1RuntimeMonitor.MessageDigestSpec_updateEvent();
	}

	pointcut SecureRandomSpec_c1() : (call(public SecureRandom.new(..))) && MOP_CommonPointCut();
	after () : SecureRandomSpec_c1() {
		MultiSpec_1RuntimeMonitor.SecureRandomSpec_c1Event();
	}

	pointcut SecureRandomSpec_g1(String alg) : (call(public static SecureRandom SecureRandom.getInstance(String)) && args(alg)) && MOP_CommonPointCut();
	after (String alg) returning (SecureRandom r) : SecureRandomSpec_g1(alg) {
		//SecureRandomSpec_g1
		MultiSpec_1RuntimeMonitor.SecureRandomSpec_g1Event(alg, r);
		//SecureRandomSpec_g3
		MultiSpec_1RuntimeMonitor.SecureRandomSpec_g3Event(alg, r);
	}

	pointcut SecureRandomSpec_g2() : (call(public static SecureRandom SecureRandom.getInstanceStrong())) && MOP_CommonPointCut();
	after () returning (SecureRandom r) : SecureRandomSpec_g2() {
		MultiSpec_1RuntimeMonitor.SecureRandomSpec_g2Event(r);
	}

}
