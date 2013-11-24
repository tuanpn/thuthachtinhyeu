package vn.sunnet.lovechallenge.utils;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AnimationMove extends Sprite {

	private float startX;
	private float startY;
	private float endX;
	private float endY;
	public float getStartX() {
		return startX;
	}

	public void setStartX(float startX) {
		this.startX = startX;
	}

	public float getStartY() {
		return startY;
	}

	public void setStartY(float startY) {
		this.startY = startY;
	}

	public float getEndX() {
		return endX;
	}

	public void setEndX(float endX) {
		this.endX = endX;
	}

	public float getEndY() {
		return endY;
	}

	public void setEndY(float endY) {
		this.endY = endY;
	}

	public boolean isCheckX() {
		return checkX;
	}

	public void setCheckX(boolean checkX) {
		this.checkX = checkX;
	}

	public boolean isCheckY() {
		return checkY;
	}

	public void setCheckY(boolean checkY) {
		this.checkY = checkY;
	}

	private float duration;

	public AnimationMove(Sprite sprite, float duration) {
		super(sprite);
		this.duration = duration;
	}

	public AnimationMove(Sprite sprite, float startX, float startY,
			float endX, float endY, float duration) {
		super(sprite);
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.duration = duration;

		setPosition(startX, startY);
	}

	// check tang = true
	boolean checkX = true;
	boolean checkY = true;

	@Override
	public void draw(SpriteBatch spriteBatch) {
		if (checkX) {
			setX(getX() + duration);
			if (getX() > endX)
				checkX = false;
		} else {
			setX(getX() - duration);
			if (getX() < startX)
				checkX = true;
		}

		if (checkY) {
			setY(getY() + duration);
			if (getY() > endY)
				checkY = false;
		} else {
			setY(getY() - duration);
			if (getY() < startY)
				checkY = true;
		}

		super.draw(spriteBatch);
	}
}
