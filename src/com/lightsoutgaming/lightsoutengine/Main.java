package com.lightsoutgaming.lightsoutengine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import com.lightsoutgaming.lightsoutengine.Input.KeyboardInput;
import com.lightsoutgaming.lightsoutengine.graphics.Window;

public class Main {
	
	Window window;
	
	public static void main(String[] args){
		new Main().Start();
	}
	
	public void Start(){
		window = new Window("Sparky Java",800,600);
		glClearColor(0f,0f,1f, 1f);
		
		while(!window.closed()){
			//System.out.println(Input.getMouseX() + ", " + Input.getMouseY());
			window.clear();
			glBegin(GL_QUADS);
			glVertex2f(-0.5f, -0.5f);
			glVertex2f(-0.5f, 0.5f);
			glVertex2f(0.5f, 0.5f);
			glVertex2f(0.5f, -0.5f);
			glEnd();
			if(KeyboardInput.getKey(GLFW_KEY_ESCAPE)){
				window.close();
			}
			window.update();
		}
		window.destroy();
	}
	
}
