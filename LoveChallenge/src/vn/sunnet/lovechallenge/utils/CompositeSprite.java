package vn.sunnet.lovechallenge.utils;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class CompositeSprite {

	private Array<Sprite> componentSprites;

	public CompositeSprite() {
		componentSprites = new Array<Sprite>();
	}

	public CompositeSprite(Sprite... componentSprites) {
		for (int i = 0; i < componentSprites.length; i++) {
			this.componentSprites.add(componentSprites[i]);
		}
	}

	public void addComponentSprite(Sprite sprite) {
		componentSprites.add(sprite);
	}

	// draw
	public void draw(SpriteBatch batch) {
		for (Sprite sprite : componentSprites) {
			sprite.draw(batch);
		}
	}

	public Array<Sprite> getComponentSprites() {
		return componentSprites;
	}

	public void setPosition(float x, float y) {
		for (Sprite sprite : componentSprites) {
			sprite.setPosition(x, y);
		}
	}

	public void flip(boolean x, boolean y) {

	}

}
