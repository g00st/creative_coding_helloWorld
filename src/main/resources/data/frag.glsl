#ifdef GL_ES
precision mediump float;
#endif

varying vec4 vertColor;
varying vec4 vertTexCoord;
uniform sampler2D tex;
uniform vec4 u_BgColor;
uniform float decay;

void main() {
    float speed = decay;
    vec4 color = texture2D(tex,  vec2( vertTexCoord.x ,1.0-vertTexCoord.y));
    vec4 v = vec4( 0);
    if(color.r < u_BgColor.r) {
        v.r = color.r * (1 +speed);
    }else{
        v.r = color.r * (1 -speed);
    }
    if(color.g < u_BgColor.g) {
        v.g = color.g * (1 +speed);
    } else{
        v.g = color.g * (1 -speed);
    }

    if(color.b < u_BgColor.b) {
        v.b = color.b * (1 +speed);
    } else{
        v.b = color.b * (1 -speed);
    }

     v =  clamp(v, u_BgColor, vec4(1.0, 1.0, 1.0, 1.0));
    gl_FragColor = v;
}