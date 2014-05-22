package BinaryCode;

/**
 * See ProblemStatement.txt for information about this problem
 * @author Ankit Patel
 */
public class BinaryCode{

	public String[] decode(String message){
		String process_FirstElementIsZero = process(message, "0");
		String process_FirstElementIsOne = process(message, "1");
			
		String[] retVal = new String[]{process_FirstElementIsZero,process_FirstElementIsOne};
		return retVal;
	}
	
	private String process(String message, String firstNum){
		String p = firstNum;
		
		//handler for when the message length is 0
		if(message.length() == 0){
			return message;
		}
		
		//handler for when the message length is 1
		if(message.length() == 1){
			if(message.substring(0,1).equals("1") || message.substring(0,1).equals("0")){
				return message;
			}
			return "NONE";			
		}
		
		//general case
		for(int i=0; i<message.length()-1;i++){
			int toAdd = -1;
			if(i==0){
				//p[i+1] = q[i] - p[i]
				toAdd = Integer.parseInt(message.substring(i,i+1)) - Integer.parseInt(p.substring(i,i+1));
			}else if(i == message.length()-2){
				//p[i+1] = q[i+1] - p[i]
				toAdd = Integer.parseInt(message.substring(i+1,i+2)) - Integer.parseInt(p.substring(i,i+1));
			}else{
				//p[i+1] = q[i] - p[i] - p[i-1]
				toAdd = Integer.parseInt(message.substring(i,i+1)) - Integer.parseInt(p.substring(i,i+1)) - Integer.parseInt(p.substring(i-1,i));	
			}
			
			if(toAdd < 0 || toAdd > 1){
				return "NONE";
			}
			p+= toAdd;
		}
		return p;
	}
	
	public static void main(String[] args){
		
		BinaryCode bc = new BinaryCode();
		String[] ret = bc.decode("123210122");
		System.out.println("Encoded: 123210122");
		System.out.println("Decoded: {"+ ret[0] + ","+ ret[1] + "}");	
	}

}