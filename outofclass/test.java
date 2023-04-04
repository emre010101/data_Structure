public class test {

			static boolean isMultiple(long n, long m){
				if(n%m==0){
					return true;
				}
				else{
					return false;
				}
			}

	public static void main (String args []) {


		System.out.println("------------R-1.1------------");
		int [] intArray = {1, 2, 3, 4, 5};
		int [] secondArray = intArray;
		intArray[2] = 45;

		for (int current : intArray){
			System.out.println(current);
		}
		for (int current : secondArray){
			System.out.println(current);
		}


		System.out.println("------------R-1.2------------");
		System.out.println(isMultiple(10, 5));


	}
}
