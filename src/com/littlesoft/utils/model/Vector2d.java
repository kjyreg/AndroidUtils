package com.littlesoft.utils.model;

import android.graphics.PointF;
import android.util.FloatMath;

/** 
 * <p>
 * 2 dimension Vector holding x and y.
 * </p>
 */
public class Vector2d {
	private final float RADIANS = (float)(Math.PI / 180);
	private PointF point;

	public String toString(){
		//super.toString() +
		return  "(" + point.x + ", " + point.y + ")"; 
	}
	public Vector2d(float x, float y)
	{
		point = new PointF(x, y);
	}

	public Vector2d(PointF pt)
	{
		point = new PointF();
		point.x = pt.x;
		point.y = pt.y;
	}

	public PointF GetPoint()
	{
		return this.point;
	}

	public float GetX()
	{
		return this.point.x;
	}

	public float GetY()
	{
		return this.point.y;
	}

	public void SetX(float x)
	{
		this.point.x = x;
	}

	public void SetY(float y)
	{
		this.point.y = y;
	}

	public float GetLength()
	{
		return FloatMath.sqrt((point.x*point.x) + (point.y*point.y));
	}

	public static Vector2d Add(Vector2d v1, Vector2d v2)
	{
		return new Vector2d(v1.GetX()+v2.GetX(), v1.GetY()+v2.GetY());
	}

	public Vector2d Add(Vector2d v2)
	{
		point.x += v2.GetX();
		point.y += v2.GetY();

		return this;
	}

	public static Vector2d Subtract(Vector2d v1, Vector2d v2)
	{
		return new Vector2d(v1.GetX()-v2.GetX(), v1.GetY()-v2.GetY());
	}

	public Vector2d Subract(Vector2d v2)
	{
		point.x -= v2.GetX();
		point.y -= v2.GetY();
		return this;
	}

	public float GetM()
	{
		//pretect from divide zero
		return point.y / (point.x + 0.0000001f);
	}

	public float GetAngle()
	{
		return (float)Math.atan(GetM()) / RADIANS;
	}

	public void SetAngle(float ang)
	{
		SetX((float)Math.cos(ang * RADIANS));
		SetY((float)Math.sin(ang * RADIANS));
	}	  

	public boolean equals(Vector2d v2)
	{
		if((v2.GetX() == GetX()) && (v2.GetY() == GetY())){
			return true;
		}
		return false;
	}

	public Vector2d Normalize()
	{
		float len = GetLength();
		point.x /= len;
		point.y /= len;
		return this;
	}

	public static Vector2d Normalize(Vector2d v)
	{
		float len = v.GetLength();
		return new Vector2d(v.GetX() / len, v.GetY() / len);
	}

	public static Vector2d Multiply(Vector2d v1, Vector2d v2)
	{
		return new Vector2d(v1.GetX()*v2.GetX(), v1.GetY()*v2.GetY());
	}
	public Vector2d Multiply(float s)
	{
		point.x *= s;
		point.y *= s;

		return this;
	}

	public Vector2d Multiply(Vector2d v2)
	{
		point.x *= v2.GetX();
		point.y *= v2.GetY();

		return this;
	}

	public void CopyTo(Vector2d v2)
	{
		v2.SetX(point.x);
		v2.SetY(point.y);
	}

	public static Vector2d GetAdjacentPoint(Vector2d v1, Vector2d v2, float r, boolean bCond) {
		//v1->v2
		Vector2d v12 = Subtract(v2, v1);

		//v1->v2 upright unit vector, length is r ,calculate the right and left point on bCond
		Vector2d v = new Vector2d(-v12.GetY(), v12.GetX()).Normalize();
		int i = bCond ? 1 : -1;
		v.Multiply(r*i);

		Vector2d vx = new Vector2d(v2.GetPoint());
		return vx.Add(v);
	}
}
