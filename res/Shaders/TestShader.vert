#version 330 core

layout (location = 0) in vec4 position;
layout (location = 1) in vec4 color;

uniform mat4 pr_matrix;
uniform mat4 vw_matrix = mat4(1);
uniform mat4 ml_matrix = mat4(1);

out DATA{
	vec4 pos;
	vec4 col;
} vsOut;


void main(){
	vsOut.pos = ml_matrix * position;
	vsOut.col = color;
	gl_Position = pr_matrix * vw_matrix * ml_matrix * position;
}