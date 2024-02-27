import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PSurface;
import processing.opengl.PShader;
import controlP5.*;



public class MySketch extends PApplet {

    ControlP5 cp5;
    int framcount = 0;
    int maxframe = 5;
    PShader shader;

    boolean mousepressed = false;
    int backgroundColor = color(100, 180, 180);
    public void setup() {
        cp5 = new ControlP5(this);
        this.getSurface().setResizable(true);
        background(backgroundColor);
        this.frameRate(60);
        noStroke();
        shader = loadShader("frag.glsl");

        cp5.addSlider("maxframe")
            .setPosition(10, 10)
            .setRange(1, 10)
            .setValue(5)
            .setSize(100, 20);
        cp5.addSlider("decay")
                .setPosition(10, 40)
                .setRange(0.001f, 0.005f)
                .setValue(5)
                .setSize(100, 20);

    }

    public void settings() {
        size(500, 500, P2D);
    }

    public void frameResized(int w, int h) {


    }
    public void decay(float value) {
        shader.set("decay", value);
    }

    public void mousePressed(){
        mousepressed = true;
    }
    public void mouseReleased(){
        mousepressed = false;
    }

    public void draw(){
        float r = random(5,20);
        framcount++;
        blendMode(BLEND);
        if( framcount > maxframe){

            for (int i = 0; i < 20; i++){
            fill( color(100, random(180, 255), random(180, 255), random(15, 150)));
            ellipse( random(r,width-r), random(r,height-r), r, r);
            framcount = 0;}
        }
        if (mousepressed){
            fill(color(100, random(180, 255), random(180, 255), random(15, 150)));
            ellipse( mouseX, mouseY, r, r);

        }

        var img = get();
        shader.set("tex", img);
        shader.set("u_BgColor", red(backgroundColor)/255f, green(backgroundColor)/255f, blue(backgroundColor)/255f,1f);
        filter(shader);


    }

}
