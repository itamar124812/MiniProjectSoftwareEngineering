package scene;
import java.io.File;

import javax.xml.parsers.SAXParser;

import parser.SceneDescriptor;

public class SceneBuilder {
    public SceneBuilder(SceneDescriptor sceneDescriptor, Scene scene, String filePath) {
        this.sceneDescriptor = sceneDescriptor;
        this.scene = scene;
        this.filePath = filePath;
    }
    private SceneDescriptor sceneDescriptor;
    private Scene scene;
    private String filePath;
    public void loadSceneFromFile(File file){

    }
}
