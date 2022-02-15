package day0118;

/**
 * 날라다니는 사물은 추진력과 양력이 필요하다
 * @author user
 *
 */
public interface Fly {

	
	/**
	 * 양력
	 * @return
	 */
	public abstract String upwardForce();
	
	
	/**
	 * 추진력
	 * @return
	 */
	public String drivingForce();
}
