package com.lightsoutgaming.lightsoutengine.maths;

public class Vec2 {
	public float x, y;
	
	public Vec2(){
		this(0,0);
	}
	
	public Vec2(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public Vec2 multiply(Vec2 other){
		x *= other.x;
		y *= other.y;
		return this;
	}
	
	public Vec2 add(Vec2 other){
		x += other.x;
		y += other.y;
		return this;
	}
	
	public Vec2 subtract(Vec2 other){
		x -= other.x;
		y -= other.y;
		return this;
	}
	
	public Vec2 divide(Vec2 other){
		x /= other.x;
		y /= other.y;
		return this;
	}
	
	public boolean equals(Object otherO){
		if(otherO instanceof Vec2){
			Vec2 other = (Vec2)otherO;
			return (other.x == x && other.y == y);
		}
		return false;
	}
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}

}
