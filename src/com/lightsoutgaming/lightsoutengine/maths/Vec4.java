package com.lightsoutgaming.lightsoutengine.maths;

public class Vec4 {
	public float x, y, z, w;
	
	public Vec4(){
		this(0,0, 0, 0);
	}
	
	public Vec4(float x, float y, float z, float w){
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public Vec4 multiply(Vec4 other){
		x *= other.x;
		y *= other.y;
		z *= other.z;
		w *= other.w;
		return this;
	}
	
	public Vec4 add(Vec4 other){
		x += other.x;
		y += other.y;
		z += other.z;
		w += other.w;
		return this;
	}
	
	public Vec4 subtract(Vec4 other){
		x -= other.x;
		y -= other.y;
		z -= other.z;
		w -= other.w;
		return this;
	}
	
	public Vec4 divide(Vec4 other){
		x /= other.x;
		y /= other.y;
		z /= other.z;
		w /= other.w;
		return this;
	}
	
	public boolean equals(Object otherO){
		if(otherO instanceof Vec4){
			Vec4 other = (Vec4)otherO;
			return (other.x == x && other.y == y && other.z == z && other.w == w);
		}
		return false;
	}
	
	public String toString(){
		return "(" + x + "," + y + "," + z + "," + w + ")";
	}

}
