package com.bladecoder.ink.runtime.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ChoiceSpecTest {

	@Test
	public void noChoice() throws Exception {
		List<String> errors = new ArrayList<String>();
		
		String text = TestUtils.runStory("inkfiles/choices/no-choice-text.ink.json", null, errors);
		
		Assert.assertEquals(0, errors.size());
		Assert.assertEquals("Hello world!\nHello back!\n", text);
	}

	@Test
	public void one() throws Exception {
		List<String> errors = new ArrayList<String>();
		
		String text = TestUtils.runStory("inkfiles/choices/one.ink.json", null, errors);
		
		Assert.assertEquals(0, errors.size());
		Assert.assertEquals("Hello world!\nHello back!\nHello back!\n", text);
	}

	@Test
	public void multiChoice() throws Exception {
		List<String> errors = new ArrayList<String>();
		
		String text = TestUtils.runStory("inkfiles/choices/multi-choice.ink.json", Arrays.asList(0), errors);
		
		Assert.assertEquals(0, errors.size());
		Assert.assertEquals("Hello, world!\nHello back!\nGoodbye\nHello back!\nNice to hear from you\n", text);
		
		// Select second choice
		text = TestUtils.runStory("inkfiles/choices/multi-choice.ink.json", Arrays.asList(1), errors);
		
		Assert.assertEquals(0, errors.size());
		Assert.assertEquals("Hello, world!\nHello back!\nGoodbye\nGoodbye\nSee you later\n", text);
	}
}
