import processing.core.PApplet;

public class MySketch extends PApplet {
    int framcount = 0;
    int maxframe = 5;
    boolean mousepressed = false;
    public void setup() {
        this.getSurface().setResizable(true);
        background(blue(100));
        this.frameRate(60);
        noStroke();

    }

    public void settings() {
        size(500, 500);
    }

    public void frameResized(int w, int h) {

    }

    public void mousePressed(){
        mousepressed = true;
    }

    public void draw(){
        float r = random(10,50);
         var i =  color(0f,0f,0f,5f);
        fill(i);
        framcount++;
        rect(0,0,width,height);
        if( framcount > maxframe){
            fill( color(random(255),random(255),random(255)));
            ellipse( random(r,width-r), random(r,height-r), r, r);
            framcount = 0;
        }
        if (mousepressed){
            fill( color(random(255),random(255),random(255)));
            ellipse( mouseX, mouseY, r, r);
            mousepressed = false;
        }

    }
}
