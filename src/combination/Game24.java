package combination;


public class Game24 {
    
   static void caculate(int[] a, String result) {
       if (a.length == 0) return;
       if (a.length == 1) {
           if (a[0] == 24) {
               System.out.println(result);
           }
           return;
       }
       for (int i=0; i<a.length-1;i++) {
           for (int j=i+1;j<a.length;j++) {
               int[] b = new int[a.length - 1];
               for (int k=0;k<i;k++) {
                   b[k] = a[k];
               }
               for (int k=i+1;k<j;k++) {
                   b[k-1] = a[k]; 
               }
               for (int k=j+1;k<a.length;k++) {
                   b[k-2] = a[k];
               }
               
               b[a.length-2] = a[i] + a[j];
               caculate(b, result + ", " + a[i] + "+" + a[j]);
               
               b[a.length-2] = a[i] - a[j];
               caculate(b, result + ", " + a[i] + "-" + a[j]);
               
               b[a.length-2] = a[j] - a[i]; 
               caculate(b, result + ", " + a[j] + "-" + a[i]);
               
               b[a.length-2] = a[i] * a[j]; 
               caculate(b, result + ", " + a[i] + "*" + a[j]);
               
               if (a[i] != 0 && a[j] % a[i] == 0) {
                   b[a.length-2] = a[j] / a[i]; 
                   caculate(b, result + ", " + a[j] + "/" + a[i]);
               }
               
               if (a[j] != 0 && a[i] % a[j] == 0) {
                   b[a.length-2] = a[i] / a[j]; 
                   caculate(b, result + ", " + a[i] + "/" + a[j]);
               }
           }
       }
       
       
       
   }
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        caculate(a, "");
    }

}
