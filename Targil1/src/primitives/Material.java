/**
 * 
 */
package primitives;

/**
 * @author User
 *
 */
public class Material {
	public double kD;
	public double kS ;
	public int nShininess;
	
	public Material() {
		this.kD=0;
		this.kS=0;
		this.nShininess=0;
	}

	/**
	 * @param kD the kD to set
	 */
	public Material setkD(double kD) {
		this.kD = kD;
		return this;
	}

	/**
	 * @param kS the kS to set
	 */
	public Material setkS(double kS) {
		this.kS = kS;
		return this;
	}

	/**
	 * @param nShininess the nShininess to set
	 */
	public Material setnShininess(int nShininess) {
		this.nShininess = nShininess;
		return this;
	}
	
}
