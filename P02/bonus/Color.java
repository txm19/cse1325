public enum Color 
{
	PURPLE(0x800080),
    	PINK(0xFFC0CB),
    	ORANGE(0xFFA500),
    	BLUE(0x0000FF);
    	
	private int rgb;

	private Color(int rgb)
	{
        	this.rgb = rgb;
   	}
    	
    	@Override
    	public String toString() 
    	{
        	return String.format("%6s (0x%06X)", name(), rgb);
    	}
}
