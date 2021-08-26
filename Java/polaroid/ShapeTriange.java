package polaroid;

public class ShapeTriange {
    public void printFloydsPyramid(int height) {
        // 코드를 입력하세요.
        //숫자자리 구하기
        int length = String.valueOf(height* (height+1)/2).length();
        
        //인인쇄될 수
        int number=1;
        
        //반복문 1: 행을 바꿔주는 반복문
        for(int row =1; row<=height; row++){
            // 한행에서 인쇄될 내용을 담는 문자열 선언
            String line="";
            
            //반복문 2: 한행에서 열을 바꾸는 반반복문
            for(int col=1; col<=row; col++){
                //반복문 3: 한열, 안에서 자리수를 맞추는 반복문
                for(int i=String.valueOf(number).length(); i<length;i++){
                    line+=" ";
                }
                //실제 인쇄될 수를 문자열에 더하고 한칸띄워주기
                line += (number+" ");
                number++;
            }
            //줄바꾸기 직전 : 출력
            System.out.println(line);
        
        }
        
        
    }

}
