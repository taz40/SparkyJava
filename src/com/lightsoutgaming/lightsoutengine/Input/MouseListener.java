package com.lightsoutgaming.lightsoutengine.Input;

import org.lwjgl.glfw.GLFWCursorPosCallback;

public class MouseListener extends GLFWCursorPosCallback {
	
	public static double x, y;

	@Override
	public void invoke(long window, double xpos, double ypos) {
		// TODO Auto-generated method stub
		x = xpos;
		y = ypos;
	}

}
