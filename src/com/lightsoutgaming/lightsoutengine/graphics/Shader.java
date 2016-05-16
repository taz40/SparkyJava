package com.lightsoutgaming.lightsoutengine.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;

import com.lightsoutgaming.lightsoutengine.Utils.FileUtils;
import com.lightsoutgaming.lightsoutengine.maths.Mat4;
import com.lightsoutgaming.lightsoutengine.maths.Vec2;
import com.lightsoutgaming.lightsoutengine.maths.Vec3;
import com.lightsoutgaming.lightsoutengine.maths.Vec4;

public class Shader {
	
	private int shaderID;
	private String vertPath;
	private String fragPath;
	
	public Shader(String vertPath, String fragPath){
		this.vertPath = vertPath;
		this.fragPath = fragPath;
		shaderID = load();
	}
	
	private int load(){
		int program = glCreateProgram();
		int vertex = glCreateShader(GL_VERTEX_SHADER);
		int fragment = glCreateShader(GL_FRAGMENT_SHADER);
		String vertSrc = FileUtils.readFile(vertPath);
		String fragSrc = FileUtils.readFile(fragPath);
		
		glShaderSource(vertex, vertSrc);
		glCompileShader(vertex);
		
		int result;
		IntBuffer resultBuffer = BufferUtils.createIntBuffer(1);
		glGetShaderiv(vertex, GL_COMPILE_STATUS, resultBuffer);
		result = resultBuffer.get(0);
		if(result == GL_FALSE){
			String log = glGetShaderInfoLog(vertex);
			System.out.println("Failed To Compile Vertex Shader: \n" + log);
			glDeleteShader(vertex);
			return 0;
		}
		
		glShaderSource(fragment, fragSrc);
		glCompileShader(fragment);
		
		resultBuffer = BufferUtils.createIntBuffer(1);
		glGetShaderiv(fragment, GL_COMPILE_STATUS, resultBuffer);
		result = resultBuffer.get(0);
		if(result == GL_FALSE){
			String log = glGetShaderInfoLog(fragment);
			System.out.println("Failed To Compile Fragment Shader: \n" + log);
			glDeleteShader(fragment);
			return 0;
		}
		
		glAttachShader(program, vertex);
		glAttachShader(program, fragment);
		
		glLinkProgram(program);
		glValidateProgram(program);
		
		glDeleteShader(vertex);
		glDeleteShader(fragment);
		
		return program;
	}
	
	public void enable(){
		glUseProgram(shaderID);
	}
	
	public void disable(){
		glUseProgram(0);
	}
	
	public int getUniformLocation(String name){
		return glGetUniformLocation(shaderID, name);
	}
	
	public void setUniformMat4(String name, Mat4 mat){
		FloatBuffer matBuffer = BufferUtils.createFloatBuffer(Mat4.SIZE);
		matBuffer.put(mat.elements);
		matBuffer.flip();
		glUniformMatrix4fv(getUniformLocation(name), false, matBuffer);
	}
	
	public void setUniform1f(String name, float value){
		glUniform1f(getUniformLocation(name), value);
	}
	
	public void setUniform1i(String name, int value){
		glUniform1i(getUniformLocation(name), value);
	}
	
	public void setUniform2f(String name, Vec2 value){
		glUniform2f(getUniformLocation(name), value.x, value.y);
	}
	
	public void setUniform3f(String name, Vec3 value){
		glUniform3f(getUniformLocation(name), value.x, value.y, value.z);
	}
	
	public void setUniform4f(String name, Vec4 value){
		glUniform4f(getUniformLocation(name), value.x, value.y, value.z, value.w);
	}

}
