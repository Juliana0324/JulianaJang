package Zoo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<AbstractAnimal> animals = new ArrayList<>();
        
        Scanner s = new Scanner(System.in);
        for(int i=0; i<3; i++) {
        	System.out.println("동물원에 어떤 동물들이 있을까요? ("+(i+1)+"/3)");
        	String name = s.next();
        	
        	System.out.println(name+"의 울음소리는 어떤가요? ("+(i+1)+"/3)");
        	String sound = s.next();

        	animals.add(new AbstractAnimal(name) {
				
				@Override
				public void cry() {
					System.out.println(sound);
				}
			});
        }
        
        
        System.out.println("동물원 보유 동물들의 울음소리");
        
        for (AbstractAnimal animal : animals) {
            System.out.print(animal.name+"의 울음소리는 ");
            animal.cry();
        }
    }
}