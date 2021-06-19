# MiniProjectSoftwareEngineering
This project is an app to create images using a phong model.
<br>some image that we ceate:</br>

<br>![Bearpo](https://user-images.githubusercontent.com/72939664/122653109-47a9e100-d14b-11eb-983a-b6d8798aef04.png)</br>
<br>![jop](https://user-images.githubusercontent.com/72939664/122653149-8475d800-d14b-11eb-9e54-812a823b6c0b.png)</br>
<br>![HBS](https://user-images.githubusercontent.com/72939664/122653168-a8d1b480-d14b-11eb-83a7-dc2472c74734.png)</br>
<br>![r4u](https://user-images.githubusercontent.com/72939664/122653187-c010a200-d14b-11eb-9591-47651266ac36.png)</br>


<h2>Project structure:</h2>
  <br>A component that simulates our point of view towards the body (elements::camera) from which emerge the rays that create the image by pixels.</br>
<br>All the effects of lighting in an image are created by light sources (elements::pointLight ,directionalLight ,spotLight ,superSpotlight).</br>
<br>A scene class that contains all the data in the image such as: the bodies (geometries ,primitives), the light sources in the image, the background of the image, the name ...</br>
<br>A class that renders and is responsible for running the ray trace per pixel and calculates its color.</br>
<br>A component that tracks rays (render::rayTraceBasic) and calculates the points of impact on the bodies in the scene and thereby using the pong model returns the color at the point hit by the ray.</br>

<h2>Image enhancements:</h2>
<br>In order to enhance the beauty and visibility of the image we have added super sampling which takes a certain pixel range for each pixel and a muted computer for the color of the pixel and thus the edges of the image come out more realistic.</br>
<br>In order to improve the speed of the image run time used adaptive super sampling which shortened processes for pixels taking 4 random points on them which are divided into areas and the middle is equal in color and only for the different pixels kept going in depth.</br>

<h2>Bonuses:</h2>
<br>We performed all the bonuses of Exercise 2 Exercise 3 as well as the bonus of moving the camera of Exercise 4 as well as all the bonuses of Exercise 6 and 2 out of the 3 bonuses of Exercise 7.</br>
