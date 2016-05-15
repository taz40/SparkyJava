package com.lightsoutgaming.lightsoutengine.Input;

import org.lwjgl.glfw.GLFWMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.*;

public class MouseButtonListener extends GLFWMouseButtonCallback {
	
	public static boolean[] buttons = new boolean[5];

	@Override
	public void invoke(long window, int button, int action, int mods) {
		// TODO Auto-generated method stub
		if(action != GLFW_RELEASE){
			buttons[button] = true;
		}else{
			buttons[button] = false;
		}
	}
	
	public static boolean getButton(int button){
		return buttons[button];
	}

}
