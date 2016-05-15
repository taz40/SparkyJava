package com.lightsoutgaming.lightsoutengine.Input;

public class Input {
	
	public static boolean getKey(int key){
		return KeyboardInput.getKey(key);
	}
	
	public static boolean getButton(int button){
		return MouseButtonListener.getButton(button);
	}
	
	public static double getMouseX(){
		return MouseListener.x;
	}
	
	public static double getMouseY(){
		return MouseListener.y;
	}

}
