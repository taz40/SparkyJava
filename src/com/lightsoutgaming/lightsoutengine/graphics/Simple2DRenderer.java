package com.lightsoutgaming.lightsoutengine.graphics;

import static org.lwjgl.opengl.GL11.*;

import java.util.LinkedList;
import java.util.Queue;

public class Simple2DRenderer extends Renderer2D{
	
	Queue<Renderable2D> renderQueue = new LinkedList<Renderable2D>();

	@Override
	public void Submit(Renderable2D renderable) {
		// TODO Auto-generated method stub
		renderQueue.add(renderable);
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		for(Renderable2D renderable : renderQueue){
			renderable.vertexArray.bind();
			renderable.indexBuffer.bind();
			glDrawElements(GL_TRIANGLES, renderable.indexBuffer.getCount(), GL_UNSIGNED_SHORT, 0);
			
		}
	}
	
}
