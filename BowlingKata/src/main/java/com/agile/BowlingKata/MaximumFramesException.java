package com.agile.BowlingKata;

public class MaximumFramesException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    MaximumFramesException(String str)
    {
        System.out.println(str);
        //super(str);
    }

	public static MaximumFramesException none() {
		return null;
	}
    
}
