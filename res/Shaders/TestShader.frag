#version 330 core

layout (location = 0) out vec4 color;

uniform vec4 col;
uniform vec2 light_pos;

in DATA{
	vec4 pos;
	vec4 col;
} fsIn;

void main(){
	float intensity = 1 / length(fsIn.pos.xy-light_pos);
	color = fsIn.col * intensity;
}