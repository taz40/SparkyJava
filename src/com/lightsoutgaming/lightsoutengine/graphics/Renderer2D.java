package com.lightsoutgaming.lightsoutengine.graphics;

public abstract class Renderer2D {
	
	public abstract void Submit(Renderable2D renderable);
	
	public abstract void flush();

}
