package com.lightsoutgaming.lightsoutengine.graphics;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWWindowSizeCallback;

public class WindowSizeCallback extends GLFWWindowSizeCallback {
	
	Window window;
	
	public WindowSizeCallback(Window window){
		this.window = window;
	}

	@Override
	public void invoke(long window, int width, int height) {
		// TODO Auto-generated method stub
		IntBuffer widthB = BufferUtils.createIntBuffer(1);
		IntBuffer heightB = BufferUtils.createIntBuffer(1);
		glfwGetFramebufferSize(window, widthB, heightB);
		this.window.setSize(widthB.get(0), heightB.get(0));
		glViewport(0,0,this.window.getWidth(), this.window.getHeight());
	}

}
