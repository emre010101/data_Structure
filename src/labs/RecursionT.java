package labs;

public class RecursionT {
	
	public static int hiCount(String mys) {
		if(mys.length()<2) {
			return 0;
		}
		int sum =0;
		if(mys.charAt(0)==('h')) {
			if(mys.charAt(1)==('i')) {
				sum++;
			}
		}
		return sum+hiCount(mys.substring(1));
	}
	 public static int countHi(String myString){
		 //we need some base case
		 if(myString.length() < 2){//this is our base case.
			 return 0;
		 }else if(myString.substring(0,2).equals("hi")){
		 //if we have found the string hi we need to do something!!!
			 return 1 + countHi(myString.substring(2));
		 }else{
		 //we need to do something else...
			 return countHi(myString.substring(1));
		 }
	 }
	public static String xRemove(String mys) {
		if(mys.length()<2) {
			if(mys.charAt(0)=='x') {
				return "null";
			}else {
				return mys;
			}
		}else if(mys.charAt(0)=='x') {
			return xRemove(mys.substring(1));
		}else {
			return mys.charAt(0) + xRemove(mys.substring(1));
		}
	}
	
	public static boolean contains10(int[] array, int index) {
		if(index==array.length-1) {
			return false;
		}
		if((array[index]*10)==(array[index+1])) {
			return true;
		}else {
			return contains10(array, index+1);
		}
	}
	
	public static String moveX(String movingX) {
		String result="";
		char c = movingX.charAt(0);
		if(movingX.length()<=1) {
			return movingX;
		}else if(c == 'x') {
			return moveX(movingX.substring(1))+"x";
		}else {
			return c+moveX(movingX.substring(1));
		}
	}
	
	public static int sumdigits(int n) {
		if(n<10) {
			return n;
		}int last= n%10;
		return sumdigits(n/10)+last;
	}
	
	public static String xChangetoy(String passed) {

		if(passed.length()==0) {
			return passed;
		}
		char c = passed.charAt(0);
		if(c=='x') {
			return 'y' + xChangetoy(passed.substring(1));
		}else {
			return c + xChangetoy(passed.substring(1));
		}
	}
	
	public static String cleanString(String sss) {
		char c = sss.charAt(0);
		if(sss.length()<2) {
			return sss;
		}else if(c==sss.charAt(1)) {
			return cleanString(sss.substring(1));
		}else {
			return c + cleanString(sss.substring(1));
		}
	}
	
	public static void main(String[] args) {
		System.out.println(hiCount("hihihiemreemrehi"));
		System.out.println("removingX: "+xRemove("emxrexemxre"));
		int[] myarr = {1,1,2,3,30,18};
		System.out.println(contains10(myarr, 0));
		System.out.println("moving x : " + moveX("xexmxxxre"));
		System.out.println("sumdigits: " + sumdigits(1233));
		System.out.println("x changes to y: " + xChangetoy("exxxxxxxxxxxmrex"));
		System.out.println("Cleaning the string: " + cleanString("emmrerrrrrrrrree"));
	}
	
}
