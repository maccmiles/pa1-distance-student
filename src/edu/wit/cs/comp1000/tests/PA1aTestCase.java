package edu.wit.cs.comp1000.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.Permission;

import edu.wit.cs.comp1000.PA1a;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class PA1aTestCase {
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(10);

	@SuppressWarnings("serial")
	private static class ExitException extends SecurityException {}
	
	private static class NoExitSecurityManager extends SecurityManager 
    {
        @Override
        public void checkPermission(Permission perm) {}
        
        @Override
        public void checkPermission(Permission perm, Object context) {}
        
        @Override
        public void checkExit(int status) { super.checkExit(status); throw new ExitException(); }
    }
	
	@Before
    public void setUp() throws Exception 
    {
        System.setSecurityManager(new NoExitSecurityManager());
    }
	
	@After
    public void tearDown() throws Exception 
    {
        System.setSecurityManager(null);
    }
	
	private void _test(int yards, int feet, int inches, int expected) {
		final String input = TestSuite.intInput(new int[] {yards, feet, inches});
		final String output = TestSuite.stringOutput(new String[] {
			"Enter number of yards: ",
			"Enter number of feet: ",
			"Enter number of inches: ",
			"Total number of inches: %d%n",
		}, new Object[] {expected});
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		System.setOut(new PrintStream(outContent));
		
		try {
			PA1a.main(new String[] { "foo" });
		} catch (ExitException e) {}
		assertEquals(output, outContent.toString());
		
		System.setIn(null);
		System.setOut(null);
	}
	
	@Test
	public void testInches() {
		_test(0, 0, 0, 0);
		_test(0, 0, 1, 1);
		_test(0, 0, 2, 2);
		_test(0, 0, 10, 10);
	}
	
	@Test
	public void testFeet() {
		_test(0, 1, 0, 12);
		_test(0, 2, 0, 24);
		_test(0, 10, 0, 120);
	}
	
	@Test
	public void testYards() {
		_test(1, 0, 0, 36);
		_test(2, 0, 0, 72);
		_test(10, 0, 0, 360);
	}
	
	@Test
	public void testCombo() {
		_test(0, 1, 1, 13);
		_test(1, 0, 1, 37);
		_test(1, 1, 0, 48);
		_test(1, 1, 1, 49);
		_test(1, 2, 3, 63);
		_test(3, 2, 1, 133);
	}

}
