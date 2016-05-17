package com.lightsoutgaming.lightsoutengine;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.opengl.GL11.glClearColor;

import java.util.ArrayList;
import java.util.Random;

import com.lightsoutgaming.lightsoutengine.Input.Input;
import com.lightsoutgaming.lightsoutengine.Input.KeyboardInput;
import com.lightsoutgaming.lightsoutengine.graphics.Renderable2D;
import com.lightsoutgaming.lightsoutengine.graphics.Shader;
import com.lightsoutgaming.lightsoutengine.graphics.Simple2DRenderer;
import com.lightsoutgaming.lightsoutengine.graphics.Window;
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
//		
//		float[] vertecies = {
//			0, 0, 0,
//			0, 3, 0,
//			8, 3, 0,
//			8, 0, 0
//		};
//		
//		short[] indecies = {
//			
//			0, 1, 2,
//			2, 3, 0
//				
//		};
//		
//		float[] colorsA = {
//			1, 0, 1, 1,
//			1, 0, 1, 1,
//			1, 0, 1, 1,
//			1, 0, 1, 1
//		};
//		
//		float[] colorsB = {
//			0, 0, 1, 1,
//			1, 0, 1, 1,
//			1, 0, 1, 1,
//			0, 0, 1, 1
//		};
//		
//		float[] colorsC = {
//			1, 0, 1, 1,
//			0, 1, 0, 1,
//			0, 1, 0, 1,
//			1, 0, 1, 1
//		};
//		
//		VertexArray Sprite1 = new VertexArray();
//		VertexArray Sprite2 = new VertexArray();
//		VertexArray Sprite3 = new VertexArray();
//		Buffer vboA = new Buffer(vertecies, 3);
//		Buffer vboB = new Buffer(vertecies, 3);
//		Buffer vboC = new Buffer(vertecies, 3);
//		IndexBuffer ibo = new IndexBuffer(indecies);
//		
//		Sprite1.addBuffer(vboA, 0);
//		Sprite1.addBuffer(new Buffer(colorsA, 4), 1);
//		Sprite2.addBuffer(vboB, 0);
//		Sprite2.addBuffer(new Buffer(colorsB, 4), 1);
//		Sprite3.addBuffer(vboC, 0);
//		Sprite3.addBuffer(new Buffer(colorsC, 4), 1);
		
		ArrayList<Renderable2D> renderables = new ArrayList<Renderable2D>();
		Random rand = new Random();
		float width = 16f/10f;
		float height = 9f/10f;
		for(int x = 0; x < 10; x++){
			float xPos = x*width;
			for(int y = 0; y < 10; y++){
				float yPos = y*height;
				renderables.add(new Renderable2D(new Vec3(xPos, yPos, 0), new Vec2(width, height), new Vec4(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 1)));
			}
		}
		
		Renderable2D purple = new Renderable2D(new Vec3(4,3,0), new Vec2(8,3), new Vec4(1,0,1,1));
		Renderable2D green = new Renderable2D(new Vec3(8,6,0), new Vec2(8,3), new Vec4(0,1,0,1));
		Renderable2D blue = new Renderable2D(new Vec3(0,0,0), new Vec2(8,3), new Vec4(0,0,1,1));
		
		Mat4 ortho = Mat4.orthographic(0,  16, 0, 9, -1, 1);
		
		Shader shader = new Shader("/Shaders/TestShader.vert", "/Shaders/TestShader.frag");
		shader.enable();
		shader.setUniformMat4("pr_matrix", ortho);
		shader.setUniformMat4("ml_matrix", Mat4.translation(new Vec3(4, 3, 0)));
		shader.setUniform4f("col", new Vec4(1,0,0,1));
		
		Simple2DRenderer renderer = new Simple2DRenderer(shader);
		
		while(!window.closed()){
			window.clear();
			shader.setUniform2f("light_pos", new Vec2((float)(Input.getMouseX()*(16f/window.getWidth())), (float)(9f-Input.getMouseY() * 9f/window.getHeight())));
//			glDrawArrays(GL_TRIANGLES, 0, 6);
			for(Renderable2D renderable : renderables){
				renderer.Submit(renderable);
			}
			renderer.flush();
			
			if(KeyboardInput.getKey(GLFW_KEY_ESCAPE)){
				window.close();
			}
			window.update();
			System.out.println(window.fps + " fps");
		}
		window.destroy();
	}
	
}
