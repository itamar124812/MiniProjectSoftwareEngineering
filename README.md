# MiniProjectSoftwareEngineering
This project is an app to create images using a phong model.
<br>some image that we ceate:</br>

![alt text](https://github.com/[username]/[reponame]/blob/[branch]/image.jpg?raw=true)

<h2>Project structure:</h2>
  <br>A component that simulates our point of view towards the body (elements::camera) from which emerge the rays that create the image by pixels.</br>
<br>All the effects of lighting in an image are created by light sources (elements::pointLight ,directionalLight ,spotLight ,superSpotlight).</br>
<br>A scene class that contains all the data in the image such as: the bodies (geometries ,primitives), the light sources in the image, the background of the image, the name ...</br>
<br>A class that renders and is responsible for running the ray trace per pixel and calculates its color.</br>
<br>A component that tracks rays (render::rayTraceBasic) and calculates the points of impact on the bodies in the scene and thereby using the pong model returns the color at the point hit by the ray.</br>
