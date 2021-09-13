package Zoo;

public abstract class AbstractAnimal {
	
	public abstract void cry();

	public final String name;

	public AbstractAnimal(String name){
	        this.name = name;
	    }
	
	}