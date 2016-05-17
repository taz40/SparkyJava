package com.lightsoutgaming.lightsoutengine.graphics;

import com.lightsoutgaming.lightsoutengine.graphics.Buffers.Buffer;
import com.lightsoutgaming.lightsoutengine.graphics.Buffers.IndexBuffer;
import com.lightsoutgaming.lightsoutengine.graphics.Buffers.VertexArray;
import com.lightsoutgaming.lightsoutengine.maths.Vec2;
import com.lightsoutgaming.lightsoutengine.maths.Vec3;
import com.lightsoutgaming.lightsoutengine.maths.Vec4;

public class Renderable2D {
	protected Vec2 size;
	protected Vec3 position;
	protected Vec4 color;
	
	VertexArray vertexArray;
	IndexBuffer indexBuffer;
	
	public Renderable2D(Vec3 position, Vec2 size, Vec4 color){
		this.size = size;
		this.position = position;
		this.color = color;
		
		vertexArray = new VertexArray();
		short[] indecies = {
			0, 1, 2,
			2, 3, 0
		};
		indexBuffer = new IndexBuffer(indecies);
		
		float[] vertecies = {
			0, 0, 0,
			0, size.y, 0,
			size.x, size.y, 0,
			size.x, 0, 0
		};
		
		float[] colors = {
				color.x, color.y, color.z, color.w,
				color.x, color.y, color.z, color.w,
				color.x, color.y, color.z, color.w,
				color.x, color.y, color.z, color.w
		};
		
		vertexArray.addBuffer(new Buffer(vertecies, 3), 0);
		vertexArray.addBuffer(new Buffer(colors, 4), 1);
		
	}
	
	public Vec3 getPosition(){
		return position;
	}
	
	public Vec2 getSize(){
		return size;
	}
	
	public Vec4 getColor(){
		return color;
	}
}
