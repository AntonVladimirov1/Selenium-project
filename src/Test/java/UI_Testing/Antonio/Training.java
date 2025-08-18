package UI_Testing.Antonio;

public class Training {

    private static boolean hasFive(String[] arr){
        for(String str : arr){
            if(str.length() < 5){
               return true;
            }
        }
        return false;
    }
    public static boolean hasFiveCharString(String[] strings) {
        for (String str : strings) {
            if (str.length() == 5) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[] words ={"hello","sunfgh","kakashka","boofghg"};
        System.out.println(hasFive(words));
        System.out.println(hasFiveCharString(words));
    }








}


