package com.lightsoutgaming.lightsoutengine.graphics;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL;

import com.lightsoutgaming.lightsoutengine.Input.KeyboardInput;
import com.lightsoutgaming.lightsoutengine.Input.MouseButtonListener;
import com.lightsoutgaming.lightsoutengine.Input.MouseListener;

public class Window {

	private int width, height;
	private String title;
	private long window;
	
	public Window(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		init();
	}
	
	public void update(){
		glfwPollEvents();
		
		glfwSwapBuffers(window);		
	}
	
	public void destroy(){
		glfwDestroyWindow(window);
		glfwTerminate();
	}
	
	private void init(){
		
		if(glfwInit() != GL_TRUE){
			System.out.println("Failed to Initialize GLFW");
			return;
		}
		
		window = glfwCreateWindow(width, height, title, 0, 0);
		if(window == GL_FALSE){
			glfwTerminate();
			System.out.println("Window Creation Failed");
		}
		
		glfwMakeContextCurrent(window);
		
		GL.createCapabilities();
		
		glfwSetWindowSizeCallback(window, new WindowSizeCallback(this));
		glfwSetKeyCallback(window, new KeyboardInput());
		glfwSetCursorPosCallback(window, new MouseListener());
		glfwSetMouseButtonCallback(window, new MouseButtonListener());
		
		
		System.out.println("Window Created with the following OpenGL Instance:");
    	System.out.println("GL_VENDOR: " + glGetString(GL_VENDOR));
		System.out.println("GL_RENDERER: " + glGetString(GL_RENDERER));
		System.out.println("GL_VERSION: " + glGetString(GL_VERSION));
		
	}
	
	public void close(){
		glfwSetWindowShouldClose(window, GL_TRUE);
	}
	
	public boolean closed(){
		return glfwWindowShouldClose(window) == GL_TRUE;
	}
	
	public void clear(){
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}
	
}
