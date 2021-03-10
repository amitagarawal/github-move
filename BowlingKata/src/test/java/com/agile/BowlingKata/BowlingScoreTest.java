package com.agile.BowlingKata;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BowlingScoreTest {

    @Test
    public void shouldReturnScoreOfSinglFrameWhenPlayingWith2Knocks() {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);

        obowlingScore.calculateFrameScore(1, 1, 4);

        assertEquals(5, obowlingScore.getFrameScore(1));
    }

    @Test
    public void shouldReturnTotalScoreWhenPlayingWithAllFramesWithValidKnockScores() {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameCount = 1;

        obowlingScore.calculateFrameScore(frameCount, 1, 4);
        obowlingScore.calculateFrameScore(++frameCount, 2, 4);
        obowlingScore.calculateFrameScore(++frameCount, 3, 4);
        obowlingScore.calculateFrameScore(++frameCount, 3, 4);
        obowlingScore.calculateFrameScore(++frameCount, 5, 4);
        obowlingScore.calculateFrameScore(++frameCount, 4, 5);
        obowlingScore.calculateFrameScore(++frameCount, 2, 3);
        obowlingScore.calculateFrameScore(++frameCount, 0, 2);
        obowlingScore.calculateFrameScore(++frameCount, 0, 6);
        obowlingScore.calculate10thFrameScore(++frameCount, 8, 1, 0);

        assertEquals(65, obowlingScore.getTotalScore());        
    }

    @Test
    public void shouldIdentifyIfaFrameIsSpare()
    {
        BowlingRules obowlingRules = new BowlingRules();
        
        String frameType = obowlingRules.checkFrameType(6, 4);
        
        assertEquals("SPARE", frameType);
    }

    @Test
    public void shouldIdentifyIfaFrameIsStrike()
    {
        BowlingRules obowlingRules = new BowlingRules();
        
        String frameType = obowlingRules.checkFrameType(10, 0);
        
        assertEquals("STRIKE", frameType);
    }

    @Test
    public void shouldReturnTotalScoreWhenPlayWith2FramesAnd1FrameIsSpare()
    {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameNum = 1;

        obowlingScore.calculateFrameScore(frameNum, 6, 4);//12
        obowlingScore.calculateFrameScore(++frameNum, 2, 4);//6

        assertEquals(18, obowlingScore.getTotalScore());
    }

    @Test
    public void shouldReturnSpareScoreWhenPlayWith3FramesAnd1FrameIsSpare()
    {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameCount = 1;

        obowlingScore.calculateFrameScore(frameCount, 1, 4);//5
        obowlingScore.calculateFrameScore(++frameCount, 6, 4);//12
        obowlingScore.calculateFrameScore(++frameCount, 2, 4);//6

        assertEquals(12, obowlingScore.getFrameScore(2));
    }
    
    @Test
    public void shouldReturnTotalScoreWhenPlayingAllFramesWith1Spare() {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameCount = 1;

        obowlingScore.calculateFrameScore(frameCount, 1, 4);//5
        obowlingScore.calculateFrameScore(++frameCount, 2, 4);//6
        obowlingScore.calculateFrameScore(++frameCount, 3, 4);//7
        obowlingScore.calculateFrameScore(++frameCount, 3, 4);//7
        obowlingScore.calculateFrameScore(++frameCount, 5, 4);//9
        obowlingScore.calculateFrameScore(++frameCount, 6, 4);//18
        obowlingScore.calculateFrameScore(++frameCount, 8, 0);//8
        obowlingScore.calculateFrameScore(++frameCount, 0, 2);//2
        obowlingScore.calculateFrameScore(++frameCount, 0, 6);//6
        obowlingScore.calculate10thFrameScore(++frameCount, 8, 1, 0);//9)

        assertEquals(77, obowlingScore.getTotalScore());        
    }

    @Test
    public void shouldReturnTotalScoreWhenPlayingAllFramesWith3Spare() {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameCount = 1;

        obowlingScore.calculateFrameScore(frameCount, 6, 4);//12
        obowlingScore.calculateFrameScore(++frameCount, 2, 4);//6
        obowlingScore.calculateFrameScore(++frameCount, 3, 4);//7
        obowlingScore.calculateFrameScore(++frameCount, 3, 4);//7
        obowlingScore.calculateFrameScore(++frameCount, 4, 6);//14
        obowlingScore.calculateFrameScore(++frameCount, 4, 5);//9
        obowlingScore.calculateFrameScore(++frameCount, 2, 3);//5
        obowlingScore.calculateFrameScore(++frameCount, 3, 7);//10
        obowlingScore.calculateFrameScore(++frameCount, 0, 6);//6
        obowlingScore.calculate10thFrameScore(++frameCount, 8, 1, 0);//9)

        assertEquals(85, obowlingScore.getTotalScore());        
    }

    @Test
    public void shouldReturnTotalScoreWhenPlayWith2FramesAnd1FrameIsStrike()
    {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameNum = 1;

        obowlingScore.calculateFrameScore(frameNum, 10, 0);//16
        obowlingScore.calculateFrameScore(++frameNum, 2, 4);//6

        assertEquals(22, obowlingScore.getTotalScore());
    }

    @Test
    public void shouldReturnSpareScoreWhenPlayWith3FramesAnd1FrameIsStike()
    {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameCount = 1;

        obowlingScore.calculateFrameScore(frameCount, 1, 4);//5
        obowlingScore.calculateFrameScore(++frameCount, 10, 0);//16
        obowlingScore.calculateFrameScore(++frameCount, 4, 4);//8

        assertEquals(18, obowlingScore.getFrameScore(2));
    }

    @Test
    public void shouldReturnTotalScoreWhenPlayingAllFramesWith3Strike() {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameCount = 1;

        obowlingScore.calculateFrameScore(frameCount, 2, 4);//6
        obowlingScore.calculateFrameScore(++frameCount, 10, 0);//17
        obowlingScore.calculateFrameScore(++frameCount, 3, 4);//7
        obowlingScore.calculateFrameScore(++frameCount, 10, 0);//18
        obowlingScore.calculateFrameScore(++frameCount, 2, 6);//8
        obowlingScore.calculateFrameScore(++frameCount, 4, 5);//9
        obowlingScore.calculateFrameScore(++frameCount, 2, 3);//5
        obowlingScore.calculateFrameScore(++frameCount, 10, 0);//16
        obowlingScore.calculateFrameScore(++frameCount, 0, 6);//6
        obowlingScore.calculate10thFrameScore(++frameCount, 8, 1, 0);//9)

        assertEquals(101, obowlingScore.getTotalScore());        
    }

    @Test
    public void shouldReturnTotalScoreWhenPlayingAllFramesWithMixOfSpareAndStrike() {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameCount = 1;

        obowlingScore.calculateFrameScore(frameCount, 1, 4);//5
        obowlingScore.calculateFrameScore(++frameCount, 4, 5);//9 (14)
        obowlingScore.calculateFrameScore(++frameCount, 6, 4);//15 (29)
        obowlingScore.calculateFrameScore(++frameCount, 5, 5);//20 (49)
        obowlingScore.calculateFrameScore(++frameCount, 10, 0);//11 (60)
        obowlingScore.calculateFrameScore(++frameCount, 0, 1);//1 (61)
        obowlingScore.calculateFrameScore(++frameCount, 7, 3);//16 (77)
        obowlingScore.calculateFrameScore(++frameCount, 6, 4);//20 (97)
        obowlingScore.calculateFrameScore(++frameCount, 10, 0);//19 (116)
        obowlingScore.calculate10thFrameScore(++frameCount, 8, 1, 0);//9 (125)

        assertEquals(125, obowlingScore.getTotalScore());        
    }

    @Test
    public void shouldReturnTotalScoreWhenPlayingAllFramesWith10thFrameAsSpare() {
        BowlingRules obowlingRules = new BowlingRules();
        BowlingScore obowlingScore = new BowlingScore(obowlingRules);
        int frameCount = 1;

        obowlingScore.calculateFrameScore(frameCount, 1, 4);//5
        obowlingScore.calculateFrameScore(++frameCount, 4, 5);//9 (14)
        obowlingScore.calculateFrameScore(++frameCount, 6, 4);//15 (29)
        obowlingScore.calculateFrameScore(++frameCount, 5, 5);//20 (49)
        obowlingScore.calculateFrameScore(++frameCount, 10, 0);//11 (60)
        obowlingScore.calculateFrameScore(++frameCount, 0, 1);//1 (61)
        obowlingScore.calculateFrameScore(++frameCount, 7, 3);//16 (77)
        obowlingScore.calculateFrameScore(++frameCount, 6, 4);//20 (97)
        obowlingScore.calculateFrameScore(++frameCount, 10, 0);//18 (117)
        obowlingScore.calculate10thFrameScore(++frameCount, 2, 8, 6);//16 (133)

        assertEquals(133, obowlingScore.getTotalScore());        
    }


}
