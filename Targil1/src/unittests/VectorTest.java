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
		 // Checks the result of adding three vectors. two culinary vectors v1=-2v2 and one different
		 Vector v1 = new Vector(1, 2, 3);
	     Vector v2 = new Vector(-2, -4, -6);	  
	     Vector v3 = new Vector(0, 3, -2);
	     assertEquals(v1.add(v2),new Vector(-1,-2,-3));
	     assertEquals(v1.add(v3),new Vector(1,5,1)); 
	     //=============== Boundary Values Tests ==================
	     // Checks that exception has been thrown when the result is 0
	     v1.scale(2).add(v2);
	}

	/**
	 * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
	 */
	@Test(expected =IllegalArgumentException.class)
	public void testSubtract() {
		 // ============ Equivalence Partitions Tests ==============
		 // Checks the result of subtracting three vectors. two culinary vectors v1=-2v2 and one different
		 Vector v1 = new Vector(1, 2, 3);
	     Vector v2 = new Vector(-2, -4, -6);	  
	     Vector v3 = new Vector(0, 3, -2);
	     assertEquals(v1.subtract(v2),new Vector(3,6,9));
	     assertEquals(v1.subtract(v3),new Vector(1,-1,5));
	     // =============== Boundary Values Tests ==================
	     //Vector zero exception
	     v1.subtract(v1);
	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test(expected =IllegalArgumentException.class)
	public void testScale() {
		 // ============ Equivalence Partitions Tests ==============
		 //Checks the result of multiplication some vector by positive and negative scale numbers 
		Vector v1=new Vector(1,2,3);
		assertEquals(v1.scale(2), new Vector(2,4,6));
		assertEquals(v1.scale(-2), new Vector(-2,-4,-6));
	    // =============== Boundary Values Tests ==================
		//Vector zero exception
	    v1.scale(0);
	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	public void testDotProduct() {
		// ============ Equivalence Partitions Tests ==============
		// Checks the result of dot product on three vectors.Two of them are culinary vectors v1=-2v2 and one different
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
	     //Vector zero exception
         v1.crossProduct(v2);
       //cross product on two vectors 
       Vector vr = v1.crossProduct(v3);
       assertEquals(isZero(vr.length() - v1.length() * v3.length()),true);
       assertEquals(isZero(vr.dotProduct(v1)) || !isZero(vr.dotProduct(v3)),true);
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	public void testLengthSquared() {
		//Checks the length Squared on some vector
		Vector v1 =new 	Vector(1,2,3);
		assertEquals(isZero(v1.lengthSquared() - 14),true);
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	public void testLength() {
		//Checks the length on some vector
	assertEquals(isZero(new Vector(0, 3, 4).length() - 5),true);
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	public void testNormalize() {
		//Checks the normalize function
	        Vector v = new Vector(1, 2, 3);
	        Vector vCopy = new Vector(v.getHead());
	        Vector vCopyNormalize = vCopy.normalize();
	        assertFalse(vCopy != vCopyNormalize);
	        assertTrue(isZero(vCopyNormalize.length() - 1));
	}

	/**
	 * Test method for {@link primitives.Vector#normalized()}.
	 */
	@Test
	public void testNormalized() {
		//Checks the normalized function
		Vector v = new Vector(1, 2, 3);
        Vector u = v.normalized();
        assertEquals((u == v),false);
	}

}
