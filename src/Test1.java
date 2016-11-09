
public class Test1 {

    public static void main(String[] args){
        int suma=0;
        for(int i=0;i<=args.length-1;i++){
        	try {
        		suma+= Integer.parseInt(args[i]);
			} catch (Exception e) {
				System.out.println("No macho: "+args[i]);
			}
        }
        System.out.print("La suma es:"+suma);
      }
    
}
