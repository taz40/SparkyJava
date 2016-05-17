package com.lightsoutgaming.lightsoutengine.graphics.Buffers;


import static org.lwjgl.opengl.GL15.*;

import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import org.lwjgl.BufferUtils;

public class IndexBuffer {

	private int bufferID;
	private int count;
	
	public IndexBuffer(short[] data){
		this.count = data.length;
		
		IntBuffer id = BufferUtils.createIntBuffer(1);
		glGenBuffers(id);
		bufferID = id.get(0);
		bind();
		ShortBuffer dataBuffer = BufferUtils.createShortBuffer(data.length);
		dataBuffer.put(data);
		dataBuffer.flip();
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, dataBuffer, GL_STATIC_DRAW);
		unbind();
	}
	
	public void bind(){
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, bufferID);
	}
	
	public void unbind(){
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
	}
	
	public int getCount(){
		return count;
	}
	
}
