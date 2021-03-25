/**
 * 
 */
package unittests;

import static java.lang.System.out;
import static org.junit.Assert.*;
import static primitives.Util.isZero;


import org.junit.Test;

import primitives.Vector;

/**
 * @author USER
 *
 */
public class VectorTest {

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	@Test(expected =IllegalArgumentException.class)
	public void testAdd() {
		 // ============ Equivalence Partitions Tests ==============
		 Vector v1 = new Vector(1, 2, 3);
	     Vector v2 = new Vector(-2, -4, -6);	  
	     Vector v3 = new Vector(0, 3, -2);
	     assertEquals(v1.add(v2),new Vector(-1,-2,-3));
	     assertEquals(v1.add(v3),new Vector(1,5,1)); 
	     //=============== Boundary Values Tests ==================
	     v1.scale(2).add(v2);
	}

	/**
	 * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
	 */
	@Test(expected =IllegalArgumentException.class)
	public void testSubtract() {
		 // ============ Equivalence Partitions Tests ==============
		 Vector v1 = new Vector(1, 2, 3);
	     Vector v2 = new Vector(-2, -4, -6);	  
	     Vector v3 = new Vector(0, 3, -2);
	     assertEquals(v1.subtract(v2),new Vector(3,6,9));
	     assertEquals(v1.subtract(v3),new Vector(1,-1,5));
	     // =============== Boundary Values Tests ==================
	     v1.subtract(v1);
	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test(expected =IllegalArgumentException.class)
	public void testScale() {
		 // ============ Equivalence Partitions Tests ==============
		 //...
		Vector v1=new Vector(1,2,3);
		assertEquals(v1.scale(2), new Vector(2,4,6));
		assertEquals(v1.scale(-2), new Vector(-2,-4,-6));
	    // =============== Boundary Values Tests ==================
	    v1.scale(0);
	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	public void testDotProduct() {
		// ============ Equivalence Partitions Tests ==============
		 Vector v1 = new Vector(1, 2, 3);
	     Vector v2 = new Vector(-2, -4, -6);	  
	     Vector v3 = new Vector(0, 3, -2);
		assertEquals(isZero(v1.dotProduct(v3)), true);
		assertEquals(isZero(v1.dotProduct(v2) + 28),true);
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test(expected =IllegalArgumentException.class)
	public void testCrossProduct() {
		 Vector v1 = new Vector(1, 2, 3);
	     Vector v2 = new Vector(-2, -4, -6);	  
	     Vector v3 = new Vector(0, 3, -2); 
         v1.crossProduct(v2);

        Vector vr = v1.crossProduct(v3);
       assertEquals(isZero(vr.length() - v1.length() * v3.length()),true);
       assertEquals(isZero(vr.dotProduct(v1)) || !isZero(vr.dotProduct(v3)),true);
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	public void testLengthSquared() {
		Vector v1 =new 	Vector(1,2,3);
		assertEquals(isZero(v1.lengthSquared() - 14),true);
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	public void testLength() {
	assertEquals(isZero(new Vector(0, 3, 4).length() - 5),true);
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	public void testNormalize() {
	        Vector v = new Vector(1, 2, 3);
	        Vector vCopy = new Vector(v.getHead());
	        Vector vCopyNormalize = vCopy.normalize();
	        assertEquals(vCopy != vCopyNormalize,false);
	        assertEquals(isZero(vCopyNormalize.length() - 1),true);
	}

	/**
	 * Test method for {@link primitives.Vector#normalized()}.
	 */
	@Test
	public void testNormalized() {
		Vector v = new Vector(1, 2, 3);
        Vector u = v.normalized();
        assertEquals((u == v),false);
	}

}
