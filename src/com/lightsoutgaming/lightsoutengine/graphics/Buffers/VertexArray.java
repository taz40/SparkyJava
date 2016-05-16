package com.lightsoutgaming.lightsoutengine.graphics.Buffers;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
import java.nio.IntBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;

public class VertexArray {
	private int ArrayID;
	private ArrayList<Buffer> buffers = new ArrayList<Buffer>();
	
	public VertexArray(){
		
		IntBuffer id = BufferUtils.createIntBuffer(1);
		glGenVertexArrays(id);
		ArrayID = id.get(0);
		
	}
	
	public void addBuffer(Buffer buffer, int index){
		buffers.add(buffer);
		bind();
		buffer.bind();
		
		glEnableVertexAttribArray(index);
		glVertexAttribPointer(index, buffer.getComponentCount(), GL_FLOAT, false, 0, 0);
		
		buffer.unbind();
		unbind();
	}
	
	public void bind(){
		glBindVertexArray(ArrayID);
	}
	
	public void unbind(){
		glBindVertexArray(0);
	}
	
}
