import java.util.ArrayList;

public class Soldiers {
    public static int getSurvivingIndex(int n, int k) {

    	ArrayList<Integer> soldiers = new ArrayList<>();
    	        ArrayList<Integer> kill = new ArrayList<>();

    	        for (int i = 1; i <= n; i++) {
    	            soldiers.add(i);
    	        }

    	        int count = 0;

    	        while (soldiers.size() > 1) {

    	            for(int i=0; i < soldiers.size(); i++) {
    	                count++;
    	                if(count == k) {
    	                    System.out.println(soldiers.get(i) + "번 군사가 죽습니다.");
    	                    kill.add(i);
    	                    count=0;
    	                }
    	            }

    	            for (int i = kill.size(); i > 0; i--) {
    	                int num = kill.get(i-1);
    	                soldiers.remove(num);
    	            }

    	            kill.clear();
    	        }
    	        return soldiers.get(0);
    	    }

    	    public static void main(String[] args) {
    	        System.out.println("김신은 " + getSurvivingIndex(20, 5) + "번 자리에 서있으면 됩니다.");
    	    }
    	}