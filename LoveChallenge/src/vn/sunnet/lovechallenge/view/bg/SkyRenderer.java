package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.Resources;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Vẽ bầu trời phía sau cùng
 * 
 * @author PhamNgoc
 * 
 */
public class SkyRenderer {

	private Sprite bgSprite1;
	private Sprite bgSprite2;
	private float width;

	// biến cờ
	boolean check = true;

	public SkyRenderer() {
		bgSprite1 = Resources.getInstance().skySprite;
		bgSprite1.setPosition(0, 201);
		width = bgSprite1.getWidth();

		bgSprite2 = new Sprite(bgSprite1);
		bgSprite2.setPosition(bgSprite1.getX() + width, bgSprite1.getY());

	}

	public void render(SpriteBatch batch, float delta) {
		float deltaX = -50 * delta;
		bgSprite1.setX(bgSprite1.getX() + deltaX);
		if (bgSprite1.getX() + width < 0) {
			bgSprite1.setX(bgSprite1.getX() + width + width);
			check = false;
		}

		if (bgSprite2.getX() + width < 0) {
			check = true;
		}

		if (check) {
			bgSprite2.setX(bgSprite1.getX() + width);
		} else {
			bgSprite2.setX(bgSprite1.getX() - width);
		}

		bgSprite1.draw(batch);
		bgSprite2.draw(batch);
	}

}
