public class Inc { 
    public static void main(String[] args) { 
       Inc inc = new Inc(); 
       int i = 0; 
       inc.fermin(i); 
       i= i ++;//��������i= i ++�滻��i++,�����1
	   //i++;
       System.out.println(i);
	   //���0��
	   /*
	   why?

	   
	   
	   */
    
    } 
    void fermin(int i){ 
       i++; 
    } 
}