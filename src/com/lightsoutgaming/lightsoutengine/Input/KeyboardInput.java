package com.lightsoutgaming.lightsoutengine.Input;

import org.lwjgl.glfw.GLFWKeyCallback;
import static org.lwjgl.glfw.GLFW.*;

public class KeyboardInput extends GLFWKeyCallback{
	
	public static boolean[] keys = new boolean[500];

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		// TODO Auto-generated method stub
		if(action != GLFW_RELEASE)
			keys[key] = true;
		else
			keys[key] = false;
	}
	
	public static boolean getKey(int key){
		return keys[key];
	}

}
