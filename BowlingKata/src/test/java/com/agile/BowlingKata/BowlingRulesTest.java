package com.agile.BowlingKata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BowlingRulesTest {

    @Test
    public void asPlayerIcanPlayForMax10Frames()
    {
        BowlingRules obowlingRules = new BowlingRules();

        int maxFramesCount = obowlingRules.playForMaximumFrames();

        assertEquals(10, maxFramesCount);
    }

    @Test
    public void asPlayerIcanPlayForMax2KnocksPerFrame()
    {
        BowlingRules obowlingRules = new BowlingRules();

        int maxKnocksPerFrame = obowlingRules.playForMaximumKnocksPerFrame();

        assertEquals(2, maxKnocksPerFrame);
    }

    @Test
    public void asPlayerIcanScoreMax10PinsPerFrame()
    {
        BowlingRules obowlingRules = new BowlingRules();

        int maxPinsPerFrame = obowlingRules.scoreMaximumPinsPerFrame();

       assertEquals(10, maxPinsPerFrame);
    }    

    @Test
    public void checkFor10thFrame()
    {
        BowlingRules obowlingRules = new BowlingRules();
        Boolean frame = obowlingRules.checkFor10thFrame(10);

        assertTrue(frame);
    }
}
