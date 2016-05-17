package com.lightsoutgaming.lightsoutengine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import com.lightsoutgaming.lightsoutengine.Input.Input;
import com.lightsoutgaming.lightsoutengine.Input.KeyboardInput;
import com.lightsoutgaming.lightsoutengine.graphics.Shader;
import com.lightsoutgaming.lightsoutengine.graphics.Window;
import com.lightsoutgaming.lightsoutengine.graphics.Buffers.Buffer;
import com.lightsoutgaming.lightsoutengine.graphics.Buffers.IndexBuffer;
import com.lightsoutgaming.lightsoutengine.graphics.Buffers.VertexArray;
import com.lightsoutgaming.lightsoutengine.maths.Mat4;
import com.lightsoutgaming.lightsoutengine.maths.Vec2;
import com.lightsoutgaming.lightsoutengine.maths.Vec3;
import com.lightsoutgaming.lightsoutengine.maths.Vec4;

public class Main {
	
	Window window;
	
	public static void main(String[] args){
		new Main().Start();
	}
	
	public void Start(){
		
		window = new Window("Sparky Java",800,(int)((9f/16f)*800));
		glClearColor(0f,0f,0f, 1f);
		
//		float[] vertecies = {
//			0, 0, 0,
//			8, 0, 0,
//			0, 3, 0,
//			0, 3, 0,
//			8, 3, 0,
//			8, 0, 0
//			
//		};
//		IntBuffer vboBuffer = BufferUtils.createIntBuffer(1);
//		glGenBuffers(vboBuffer);
//		int vbo = vboBuffer.get(0);
//		glBindBuffer(GL_ARRAY_BUFFER, vbo);
//		FloatBuffer verteciesBuffer = BufferUtils.createFloatBuffer(18);
//		verteciesBuffer.put(vertecies);
//		verteciesBuffer.flip();
//		glBufferData(GL_ARRAY_BUFFER, verteciesBuffer, GL_STATIC_DRAW);
//		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
//		glEnableVertexAttribArray(0);
		
		float[] vertecies = {
			0, 0, 0,
			0, 3, 0,
			8, 3, 0,
			8, 0, 0
		};
		
		short[] indecies = {
			
			0, 1, 2,
			2, 3, 0
				
		};
		
		float[] colorsA = {
			1, 0, 1, 1,
			1, 0, 1, 1,
			1, 0, 1, 1,
			1, 0, 1, 1
		};
		
		float[] colorsB = {
			0, 0, 1, 1,
			1, 0, 1, 1,
			1, 0, 1, 1,
			0, 0, 1, 1
		};
		
		float[] colorsC = {
			1, 0, 1, 1,
			0, 1, 0, 1,
			0, 1, 0, 1,
			1, 0, 1, 1
		};
		
		VertexArray Sprite1 = new VertexArray();
		VertexArray Sprite2 = new VertexArray();
		VertexArray Sprite3 = new VertexArray();
		Buffer vboA = new Buffer(vertecies, 3);
		Buffer vboB = new Buffer(vertecies, 3);
		Buffer vboC = new Buffer(vertecies, 3);
		IndexBuffer ibo = new IndexBuffer(indecies);
		
		Sprite1.addBuffer(vboA, 0);
		Sprite1.addBuffer(new Buffer(colorsA, 4), 1);
		Sprite2.addBuffer(vboB, 0);
		Sprite2.addBuffer(new Buffer(colorsB, 4), 1);
		Sprite3.addBuffer(vboC, 0);
		Sprite3.addBuffer(new Buffer(colorsC, 4), 1);
		
		Mat4 ortho = Mat4.orthographic(0,  16, 0, 9, -1, 1);
		
		Shader shader = new Shader("/Shaders/TestShader.vert", "/Shaders/TestShader.frag");
		shader.enable();
		shader.setUniformMat4("pr_matrix", ortho);
		shader.setUniformMat4("ml_matrix", Mat4.translation(new Vec3(4, 3, 0)));
		shader.setUniform4f("col", new Vec4(1,0,0,1));
		
		while(!window.closed()){
			window.clear();
			shader.setUniform2f("light_pos", new Vec2((float)(Input.getMouseX()*(16f/window.getWidth())), (float)(9f-Input.getMouseY() * 9f/window.getHeight())));
//			glDrawArrays(GL_TRIANGLES, 0, 6);
			Sprite1.bind();
			ibo.bind();
			shader.setUniformMat4("ml_matrix", Mat4.translation(new Vec3(4, 3, 0)));
			glDrawElements(GL_TRIANGLES, ibo.getCount(), GL_UNSIGNED_SHORT, 0);
			ibo.unbind();
			Sprite1.unbind();
			Sprite2.bind();
			ibo.bind();
			shader.setUniformMat4("ml_matrix", Mat4.translation(new Vec3(0, 0, 0)));
			glDrawElements(GL_TRIANGLES, ibo.getCount(), GL_UNSIGNED_SHORT, 0);
			ibo.unbind();
			Sprite2.unbind();
			Sprite3.bind();
			ibo.bind();
			shader.setUniformMat4("ml_matrix", Mat4.translation(new Vec3(8, 6, 0)));
			glDrawElements(GL_TRIANGLES, ibo.getCount(), GL_UNSIGNED_SHORT, 0);
			ibo.unbind();
			Sprite3.unbind();
			
			if(KeyboardInput.getKey(GLFW_KEY_ESCAPE)){
				window.close();
			}
			window.update();
		}
		window.destroy();
	}
	
}
