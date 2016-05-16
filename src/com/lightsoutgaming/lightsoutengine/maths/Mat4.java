package com.lightsoutgaming.lightsoutengine.maths;

public class Mat4 {
	
	public static final int SIZE = 4*4;
	public float[] elements = new float[SIZE];
	
	public Mat4(){
		for(int i = 0; i < SIZE; i++){
			elements[i] = 0;
		}
	}
	
	public Mat4(float diagonal){
		this();
		elements[0] = diagonal;
		elements[5] = diagonal;
		elements[10] = diagonal;
		elements[15] = diagonal;
	}
	
	public static Mat4 identity(){
		return new Mat4(1);
	}
	
	public Mat4 multiply(Mat4 other){
		for(int y = 0; y < 4; y++){
			for(int x = 0; x < 4; x++){
				float sum = 0;
				for(int e = 0; e < 4; e++){
					sum += elements[x+e*4] * other.elements[e+y*4];
				}
				elements[x + y * 4] = sum;
			}
		}
		return this;
	}
	
	public static Mat4 orthographic(float left, float right, float bottom, float top, float near, float far){
		Mat4 result = new Mat4(1);
		
		result.elements[0 + 0 * 4] = 2/(right-left);
		result.elements[1 + 1 * 4] = 2/(top-bottom);
		result.elements[2 + 2 * 4] = 2/(near-far);
		
		result.elements[0 + 3 * 4] = (left+right)/(left-right);
		result.elements[1 + 3 * 4] = (bottom+top)/(bottom-top);
		result.elements[2 + 3 * 4] = (far+near)/(far-near);
		
		return result;
	}
	
	public static Mat4 perspective(float fov, float aspectRatio, float near, float far){
		Mat4 result = new Mat4(1);
		
		float q = (1/(float)Math.tan(Math.toRadians(0.5f * fov)));
		float a = q/aspectRatio;
		float b = (near+far)/(near-far);
		float c = (2*near*far)/(near-far);
		result.elements[0+0*4] = a;
		result.elements[1+1*4] = q;
		result.elements[2+2*4] = b;
		result.elements[3+2*4] = -1;
		result.elements[2+3*4] = c;
		
		return result;
	}
	
	
	public static Mat4 translation(Vec3 translation){
		Mat4 result = new Mat4(1);
		
		result.elements[0+3*4] = translation.x;
		result.elements[1+3*4] = translation.y;
		result.elements[2+3*4] = translation.z;
		
		return result;
	}
	
	public static Mat4 scale(Vec3 scale){
		Mat4 result = new Mat4(1);
		
		result.elements[0+0*4] = scale.x;
		result.elements[1+1*4] = scale.y;
		result.elements[2+2*4] = scale.z;
		
		return result;
	}
	
	public static Mat4 rotation(float angle, Vec3 axis){
		Mat4 result = new Mat4(1);
		
		float r = (float)Math.toRadians(angle);
		float c = (float)Math.cos(r);
		float s = (float)Math.sin(r);
		float omc = 1-c;
		
		float x = axis.x;
		float y = axis.y;
		float z = axis.z;
		
		result.elements[0+0*4] = x + omc + c;
		result.elements[1+0*4] = y * x * omc + z * s;
		result.elements[2+0*4] = z * x * omc - y * s;
		
		result.elements[0+1*4] = y * x * omc - z * s;
		result.elements[1+1*4] = y * omc + c;
		result.elements[2+1*4] = z * y * omc + x * s;
		
		result.elements[0+2*4] = z * x * omc + y * s;
		result.elements[1+2*4] = y * z * omc - x * s;
		result.elements[2+2*4] = z * omc + c;
		
		return result;
	}

}
