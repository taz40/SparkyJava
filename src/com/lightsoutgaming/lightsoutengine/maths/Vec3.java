package com.lightsoutgaming.lightsoutengine.maths;

public class Vec3 {
	public float x, y, z;
	
	public Vec3(){
		this(0,0,0);
	}
	
	public Vec3(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vec3 multiply(Vec3 other){
		x *= other.x;
		y *= other.y;
		z *= other.z;
		return this;
	}
	
	public Vec3 add(Vec3 other){
		x += other.x;
		y += other.y;
		z += other.z;
		return this;
	}
	
	public Vec3 subtract(Vec3 other){
		x -= other.x;
		y -= other.y;
		z -= other.z;
		return this;
	}
	
	public Vec3 divide(Vec3 other){
		x /= other.x;
		y /= other.y;
		z /= other.z;
		return this;
	}
	
	public boolean equals(Object otherO){
		if(otherO instanceof Vec3){
			Vec3 other = (Vec3)otherO;
			return (other.x == x && other.y == y && other.z == z);
		}
		return false;
	}
	
	public String toString(){
		return "(" + x + "," + y + "," + z + ")";
	}

}
