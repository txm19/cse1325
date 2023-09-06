public enum Color 
{
	PURPLE, 
	PINK, 
	ORANGE,
	BLUE;

	private int rgb;

	public int getRGB() 
	{
        	return rgb;
    }

	public void setRGB(int rgb) {
        this.rgb = rgb;
    }
    	
    	@Override
    	public String toString() 
    	{
        	return super.toString() + " (" + String.format("0x%06X", rgb) + ")";
    	}
}
