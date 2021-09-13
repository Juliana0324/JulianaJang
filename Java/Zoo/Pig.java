package Zoo;

public class Pig extends AbstractAnimal{

	public Pig(String name) {
		super(name);
	}
	
	@Override
	public void cry() {
		System.out.println("²Ü²Ü");
	}
	
}
