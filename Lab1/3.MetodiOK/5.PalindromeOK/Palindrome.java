public class Palindrome {
    public static void main(String[] args) {
        String s = args[0]; 

        System.out.print("[ ");
        for (int i=0; i< s.length(); i++) {
            for (int j = i+1; j<s.length(); j++ ) {
                String temp = s.substring(i, j+1);
                if (Palindrome.isPalindrome(temp))
                    System.out.print(temp+" "); 
            }
        }
                System.out.print("]");
    }

    private static boolean isPalindrome (String s  ){
        for (int i =0; i<s.length()/2; i++)
            if (s.charAt(i)!=s.charAt(s.length()-i-1))
            return false;
        return true;
    }

}
