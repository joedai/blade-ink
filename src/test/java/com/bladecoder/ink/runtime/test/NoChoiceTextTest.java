package com.bladecoder.ink.runtime.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NoChoiceTextTest {

	private static final String FILENAME = "inkfiles/choices/no-choice-text.ink.json";

	@Test
	public void test() throws Exception {
		List<String> errors = new ArrayList<String>();
		
		String text = TestUtils.runStory(FILENAME, null, errors);
		
		Assert.assertEquals(0, errors.size());
		Assert.assertEquals("Hello world!\nHello back!\n", text);
	}

}
