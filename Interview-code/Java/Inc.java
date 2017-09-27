public class Inc { 
    public static void main(String[] args) { 
       Inc inc = new Inc(); 
       int i = 0; 
       inc.fermin(i); 
       i= i ++;//如果这里把i= i ++替换成i++,则输出1
	   //i++;
       System.out.println(i);
	   //输出0；
	   /*
	   why?

	   
	   
	   */
    
    } 
    void fermin(int i){ 
       i++; 
    } 
}