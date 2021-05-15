package scene;

import elements.AmbientLight;
import geometries.Geometries;
import primitives.Color;

public class Scene {
    public String name;
    public Color background;
    public AmbientLight ambientLight;
    public Geometries geometries;
    public Scene(String Name)
    {
        name=Name;
        geometries=new Geometries(null);
        background=Color.BLACK;
    }
    public Scene setbackground(Color Background) {
        background = Background;
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
