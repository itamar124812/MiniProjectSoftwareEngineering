package scene;

import java.util.LinkedList;
import java.util.List;

import elements.*;

import geometries.Geometries;
import primitives.Color;

public class Scene {
    public String name;
    public Color background;
    public AmbientLight ambientLight;
    public Geometries geometries;
    public List<LightSource> lights;
    public Scene(String Name)
    {
        name=Name;
        geometries=new Geometries(null);
        background=Color.BLACK;
        lights=new LinkedList<LightSource>();
        ambientLight=new AmbientLight();
    }
    public Scene setbackground(Color Background) {
        background = Background;
        return this;
    }
	/**
	 * @param lights the lights to set
	 */
	public Scene setLights(List<LightSource> lights) {
		this.lights = lights;
		return this;
	}
	public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }
    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }
}
