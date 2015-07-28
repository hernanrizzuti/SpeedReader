package com.hernan.rizzuti.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class TimerTest {

	@Test
	public void testtimeCalcReturns1500millisWhen160WordsArepassedin() {
		assertEquals(1500,Timer.timecalc(160, 4));
	}
	
	@Test
	public void testTimeCalcReturn1200millisWhen200wordsArepassedIn(){
		assertEquals(1200,Timer.timecalc(200,4));
	}
	
	@Test
	public void testTimeCalcReturn1800millisWhen200wordsArepassedIn(){
		assertEquals(960,Timer.timecalc(250,4));
	}
}