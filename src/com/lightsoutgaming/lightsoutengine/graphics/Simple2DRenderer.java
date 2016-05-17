package com.lightsoutgaming.lightsoutengine.graphics;

import static org.lwjgl.opengl.GL11.*;

import java.util.LinkedList;
import java.util.Queue;

import com.lightsoutgaming.lightsoutengine.maths.Mat4;
import com.lightsoutgaming.lightsoutengine.maths.Vec3;

public class Simple2DRenderer extends Renderer2D{
	
	Shader shader;
	Queue<Renderable2D> renderQueue = new LinkedList<Renderable2D>();
	
	public Simple2DRenderer(Shader shader){
		this.shader = shader;
	}

	@Override
	public void Submit(Renderable2D renderable) {
		// TODO Auto-generated method stub
		renderQueue.add(renderable);
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		Renderable2D renderable = renderQueue.poll();
		while(renderable != null){
			renderable.vertexArray.bind();
			renderable.indexBuffer.bind();
			shader.setUniformMat4("ml_matrix", Mat4.translation(renderable.position));
			glDrawElements(GL_TRIANGLES, renderable.indexBuffer.getCount(), GL_UNSIGNED_SHORT, 0);
			renderable.indexBuffer.unbind();
			renderable.vertexArray.unbind();
			renderable = renderQueue.poll();
		}
	}
	
}
