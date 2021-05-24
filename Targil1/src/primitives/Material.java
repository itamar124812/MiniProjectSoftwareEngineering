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
	public double kT ;
	public double kR ;
	public int nShininess;
	
	public Material() {
		this.kD=0;
		this.kS=0;
		this.nShininess=0;
		this.kR=0.0;
		this.kS=0.0;
	}

	/**
	 * @return the kD
	 */
	public double getkD() {
		return kD;
	}

	/**
	 * @param kT the kT to set
	 */
	public Material setKt(double kT) {
		this.kT = kT;
		return this;
	}

	/**
	 * @param kR the kR to set
	 */
	public Material setKr(double kR) {
		this.kR = kR;
		return this;
	}

	/**
	 * @return the kS
	 */
	public double getkS() {
		return kS;
	}

	/**
	 * @return the nShininess
	 */
	public int getnShininess() {
		return nShininess;
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
	public Material setks(double ks) {
		this.kS = ks;
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
