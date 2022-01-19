package day0119;

public class Password {

public static String getTempPassword(int length) {
    int index = 0;
    char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
    'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
    'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
    'w', 'x', 'y', 'z' };
 
    StringBuffer sb = new StringBuffer();
 
    for (int i = 0; i < length; i++) {
        index = (int) (charArr.length * Math.random());
        sb.append(charArr[index]);
    }
 
    return sb.toString();
}
 
public static void main(String[] args) throws Exception{
    String password = getTempPassword(6);
    System.out.println(password);
}

}
