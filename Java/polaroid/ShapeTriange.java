package polaroid;

public class ShapeTriange {
    public void printFloydsPyramid(int height) {
        // �ڵ带 �Է��ϼ���.
        //�����ڸ� ���ϱ�
        int length = String.valueOf(height* (height+1)/2).length();
        
        //���μ�� ��
        int number=1;
        
        //�ݺ��� 1: ���� �ٲ��ִ� �ݺ���
        for(int row =1; row<=height; row++){
            // ���࿡�� �μ�� ������ ��� ���ڿ� ����
            String line="";
            
            //�ݺ��� 2: ���࿡�� ���� �ٲٴ� �ݹݺ���
            for(int col=1; col<=row; col++){
                //�ݺ��� 3: �ѿ�, �ȿ��� �ڸ����� ���ߴ� �ݺ���
                for(int i=String.valueOf(number).length(); i<length;i++){
                    line+=" ";
                }
                //���� �μ�� ���� ���ڿ��� ���ϰ� ��ĭ����ֱ�
                line += (number+" ");
                number++;
            }
            //�ٹٲٱ� ���� : ���
            System.out.println(line);
        
        }
        
        
    }

}
