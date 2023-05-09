package com.designpattern.flyweight;

import java.util.ArrayList;
import java.util.List;

public class FormattedText {
  
	private String plainText;
	private  boolean [] capitalize;
	
	public FormattedText(String plainText) {
		this.plainText =plainText;
		capitalize =new boolean[plainText.length()];
	}
	public void capitalize(int start,int end) {
		for(int i = start; i<= end;++i)
			capitalize[i]=true;
	}
	@Override
	public String toString() {
          
	 StringBuilder sb  =new StringBuilder();
	 
	 for(int i= 0;i<plainText.length();++i) {
		 char c =plainText.charAt(i);
		 sb.append(
				 capitalize[i]?Character.toUpperCase(c): c
				 );
	 }
	 return sb.toString();
	}
}

class BetterFormatedText
{
	private String plainText;
	private List<TextRange> formating =new ArrayList<>();
	
   public BetterFormatedText(String plainText) {
	// TODO Auto-generated constructor stub
	   this.plainText =plainText;
   }
    public TextRange getRange(int start,int end) {
    	TextRange range = new TextRange(start, end);
    	formating.add(range);
    	return range;
    	
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
        StringBuilder sb =new StringBuilder();
        
        for(int i=0;i<plainText.length();++i) {
        	char c =plainText.charAt(i);
        	for(TextRange range: formating)
        	if(range.covers(i) && range.capitalize)
        		c =Character.toUpperCase(c);
        	sb.append(c);
        }
        return sb.toString();
    }
	
	public class TextRange
	{
		public int start, end;
		public boolean capitalize, bold,italic;
		
		public TextRange(int start,int end) {
			this.start =start;
			this.end =end;
		}
		
		public boolean covers(int position) {
			return position >=start && position <=end;
		}
	}
}

class TextFormattingDemo{
public static void main(String[] args) {
		
		FormattedText ft =new FormattedText("This is a brave new world");
		ft.capitalize(10, 15);
		System.out.println(ft);
		
		BetterFormatedText bft =new BetterFormatedText("India is Greatest Country in the world");
		bft.getRange(19, 25).capitalize =true;
		System.out.println(bft);
		
	}
}