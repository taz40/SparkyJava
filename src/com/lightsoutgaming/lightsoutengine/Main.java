package com.lightsoutgaming.lightsoutengine;

import com.lightsoutgaming.lightsoutengine.graphics.Window;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Main {
	
	Window window;
	
	public static void main(String[] args){
		new Main().Start();
	}
	
	public void Start(){
		window = new Window("Sparky Java",800,600);
		glClearColor(0f,0f,1f, 1f);
		while(!window.closed()){
			System.out.println(window.getWidth() + ", " + window.getHeight());
			window.clear();
			glBegin(GL_TRIANGLES);
			glVertex2f(-0.5f, -0.5f);
			glVertex2f(0.0f, 0.5f);
			glVertex2f(0.5f, -0.5f);
			glEnd();
			window.update();
		}
		window.destroy();
	}
	
}
