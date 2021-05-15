/**
 * 
 */
package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;

/**
 * @author USER
 *
 */
public interface Intersectable  {
	List<Point3D> findIntersections(Ray ray);
	/**
	 * 
	 * @author USER
	 *
	 */
	public static class GeoPoint {
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GeoPoint other = (GeoPoint) obj;
			if (geometry == null) {
				if (other.geometry != null)
					return false;
			} else if (!geometry.equals(other.geometry))
				return false;
			if (point == null) {
				if (other.point != null)
					return false;
			} else if (!point.equals(other.point))
				return false;
			return true;
		}
		public GeoPoint(Geometry geometry, Point3D point) {
			this.geometry = geometry;
			this.point = point;
		}
		public List<GeoPoint> findGeoIntersections(Ray ray)
		{
			return null;
			
		}
		public Geometry geometry;
		public Point3D point;
	}
	
}
