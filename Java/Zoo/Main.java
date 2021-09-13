package Zoo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<AbstractAnimal> animals = new ArrayList<>();
        
        Scanner s = new Scanner(System.in);
        for(int i=0; i<3; i++) {
        	System.out.println("�������� � �������� �������? ("+(i+1)+"/3)");
        	String name = s.next();
        	
        	System.out.println(name+"�� �����Ҹ��� �����? ("+(i+1)+"/3)");
        	String sound = s.next();

        	animals.add(new AbstractAnimal(name) {
				
				@Override
				public void cry() {
					System.out.println(sound);
				}
			});
        }
        
        
        System.out.println("������ ���� �������� �����Ҹ�");
        
        for (AbstractAnimal animal : animals) {
            System.out.print(animal.name+"�� �����Ҹ��� ");
            animal.cry();
        }
    }
}