package com.lightsoutgaming.lightsoutengine.graphics.Buffers;

import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;

public class Buffer {

	private int bufferID;
	private int componentCount;
	
	public Buffer(float[] data, int componentCount){
		this.componentCount = componentCount;
		
		IntBuffer id = BufferUtils.createIntBuffer(1);
		glGenBuffers(id);
		bufferID = id.get(0);
		bind();
		FloatBuffer dataBuffer = BufferUtils.createFloatBuffer(data.length);
		dataBuffer.put(data);
		dataBuffer.flip();
		glBufferData(GL_ARRAY_BUFFER, dataBuffer, GL_STATIC_DRAW);
		unbind();
	}
	
	public void bind(){
		glBindBuffer(GL_ARRAY_BUFFER, bufferID);
	}
	
	public void unbind(){
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	public int getComponentCount(){
		return componentCount;
	}
	
}
