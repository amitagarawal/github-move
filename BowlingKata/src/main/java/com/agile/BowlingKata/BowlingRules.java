package com.agile.BowlingKata;

public class BowlingRules {

    public int playForMaximumFrames()
    {
        return 10;
    }

	public int playForMaximumKnocksPerFrame() {
		return 2;
	}

	public int scoreMaximumPinsPerFrame() {
		return 10;
	}

	public String checkFrameType(int i, int j) {
        if(i == 10)
        {
            return "STRIKE";
        }
        else if (i + j == 10)
        {
            return "SPARE";
        }
        else if (i + j < 10)
        {
            return "NORMAL_FRAME";
        }
        else
        {
            return "INVALID";
        }
	}

    public Boolean checkFor10thFrame(int i) 
    {
        Boolean frame10th = false;

        if(i == 10)
        {
            frame10th = true;
        }
        return frame10th;
	}
    
}
