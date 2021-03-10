package com.agile.BowlingKata;

//2195252e6adb286b569fcb615a58c7d37e704592
//BowlingKata SonarQube Token

public class BowlingScore {

    int totalScore;
    BowlingRules oBowlingRules;
    Frame oFrame[];

    public BowlingScore (BowlingRules aBowlingRules)
    {
        oBowlingRules = aBowlingRules;
        oFrame = new Frame[10];
        for (int i = 0; i <10; i++)
        {
            oFrame[i] = new Frame();
        }
    }

    public int getFrameScore(int frameNum)
    {
        int currframeIndex = frameNum - 1;
        return oFrame[currframeIndex].frameScore;
    }

    public int calculateFrameScore(int currframeNum, int knock1Score, int knock2Score) 
    {
        int currframeIndex = currframeNum - 1;
        int prevFrameIndex = currframeIndex - 1;

        System.out.println(currframeNum + "--->   ");

        oFrame[currframeIndex].type = oBowlingRules.checkFrameType(knock1Score, knock2Score);

        oFrame[currframeIndex].knock1Score = knock1Score;
        oFrame[currframeIndex].knock2Score = knock2Score;
        oFrame[currframeIndex].frameScore = knock1Score + knock2Score;

        updateTotalScore(oFrame[currframeIndex].frameScore);

        if(currframeNum > 1 && currframeNum <=9)
        {        
                if(oFrame[prevFrameIndex].type == "SPARE")
                {
                    updateFrameScoreWhenSpare((currframeNum - 1), oFrame[currframeIndex].knock1Score);
                }
                if(oFrame[prevFrameIndex].type == "STRIKE")
                {
                    updateFrameScoreWhenStrike((currframeNum - 1), oFrame[currframeIndex].frameScore);
                }            
        }      
        
        //System.out.println(totalScore);

        return (knock1Score + knock2Score);
    }

    private int updateTotalScore(int knockScore) 
    {
        totalScore += knockScore;
        System.out.println(totalScore);
		return (totalScore);
    }
    
    public int getTotalScore() 
    {
        return (totalScore);
	}

    private int updateFrameScoreWhenSpare(int frameNum, int knock1Score) 
    {        
        oFrame[frameNum-1].frameScore = oFrame[frameNum-1].frameScore + knock1Score;    
        updateTotalScore(knock1Score);

        return oFrame[frameNum-1].frameScore;
    }
    
    private int updateFrameScoreWhenStrike(int frameNum, int frameScore) 
    {
        oFrame[frameNum-1].frameScore = oFrame[frameNum-1].frameScore + frameScore;    
        updateTotalScore(frameScore);

        return oFrame[frameNum-1].frameScore;
    }

    public void calculate10thFrameScore(int frameNum, int knock1Score, int knock2Score, int knock3Score) 
    {
        Boolean extraKnockout = false;
        int currFrameIndex = frameNum - 1;
        int prevFrameIndex = currFrameIndex -1;

        if((knock1Score + knock2Score) < 10)
        {
            oFrame[currFrameIndex].knock1Score = knock1Score;
            oFrame[currFrameIndex].knock2Score = knock2Score;
            oFrame[currFrameIndex].frameScore = knock1Score + knock2Score;
            updateTotalScore(oFrame[currFrameIndex].frameScore);
            if(oFrame[prevFrameIndex].type == "SPARE")
            {
                updateFrameScoreWhenSpare((currFrameIndex), oFrame[currFrameIndex].knock1Score);
            }
            if(oFrame[prevFrameIndex].type == "STRIKE")
            {
                updateFrameScoreWhenStrike((currFrameIndex), oFrame[currFrameIndex].frameScore);
            }  
        }
        else if (  (knock1Score == 10) || (knock2Score == 10) || (knock1Score + knock2Score == 10) )
        {
            extraKnockout = true;
            oFrame[currFrameIndex].knock1Score = knock1Score;
            oFrame[currFrameIndex].knock2Score = knock2Score;
            oFrame[currFrameIndex].knock3Score = knock3Score;
            oFrame[currFrameIndex].frameScore = knock1Score + knock2Score + knock3Score;
            updateTotalScore(oFrame[currFrameIndex].frameScore);
            if(oFrame[prevFrameIndex].type == "SPARE")
            {
                updateFrameScoreWhenSpare((currFrameIndex), oFrame[currFrameIndex].knock1Score);
            }
            if(oFrame[prevFrameIndex].type == "STRIKE")
            {
                updateFrameScoreWhenStrike((currFrameIndex), (oFrame[currFrameIndex].frameScore) - knock3Score);
            }  
        }
        else 
        {

        }
	}
    
}
