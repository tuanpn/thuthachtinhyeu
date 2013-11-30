package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.controller.LoadMap;
import vn.sunnet.lovechallenge.model.bg.Background;
import vn.sunnet.lovechallenge.model.world.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class HouseRenderer {

	private World world;

	private Sprite house1;
	private Sprite house11;
	private Sprite house2;
	private Sprite house31;
	private Sprite house32;
	private Sprite house33;
	private Sprite house34;
	private Sprite house35;
	private Sprite house36;
	private Sprite house4;
	private Sprite house5;
	private Sprite house51;
	private Sprite house52;
	private Sprite house6;
	private Sprite house7;

	private Sprite wall11;
	private Sprite wall12;
	private Sprite wall21;
	private Sprite wall22;
	private Sprite wall31;
	private Sprite wall41;
	private Sprite wall51;
	private Sprite wall61;

	// đoạn đường lặp lại của nhà
	private float widthHouse = 3000;

	Background house1Bg;

	float vx = LoadMap.player_velocity_x;

	public HouseRenderer(World world) {
		this.world = world;
		// ===1===
		house1 = Resources.getInstance().house1Sprite;
		house1.setPosition(0, 70);
		house11 = new Sprite(house1);
		house11.setPosition(MathUtils.random(0, 20) * 50, 70);
		house2 = Resources.getInstance().house2Sprite;
		house2.setPosition(300, 100);
		// ===3===
		house31 = Resources.getInstance().house3Sprite;
		house31.setPosition(50, 180);
		house32 = new Sprite(house31);
		house32.flip(true, false);
		house32.setPosition(500, house31.getY());
		house33 = new Sprite(house31);
		house33.flip(true, false);
		house33.setPosition(1000, house31.getY());
		house34 = new Sprite(house31);
		house34.setPosition(1500, house31.getY());
		house35 = new Sprite(house31);
		house35.setPosition(2100, house31.getY());
		house36 = new Sprite(house32);
		house36.setPosition(2700, house31.getY());

		house4 = Resources.getInstance().house4Sprite;
		house4.setPosition(800, 100);
		house5 = Resources.getInstance().house5Sprite;
		house5.setPosition(1300, 70);
		house51 = new Sprite(house5);
		house51.setPosition(MathUtils.random(0, 10) * 150, house51.getY());
		house52 = new Sprite(house5);
		house52.setPosition(MathUtils.random(0, 9) * 300, house52.getY());
		house6 = Resources.getInstance().house6Sprite;
		house6.setPosition(1700, 60);
		house7 = Resources.getInstance().house7Sprite;
		house7.setPosition(2350, 90);

		wall11 = Resources.getInstance().wall1Sprite;
		wall11.setPosition(house31.getX() - wall11.getWidth() + 10, 170);
		wall12 = new Sprite(wall11);
		wall12.setPosition(house31.getX() + house31.getWidth() - 10,
				wall11.getY());
		wall21 = new Sprite(wall11);
		wall21.setPosition(house32.getX() - wall21.getWidth() + 10,
				wall11.getY());
		wall22 = new Sprite(wall11);
		wall22.setPosition(house32.getX() + house32.getWidth() - 10,
				wall11.getY());
		wall31 = new Sprite(wall11);
		wall31.setPosition(house33.getX() + house33.getWidth() - 10,
				wall11.getY());
		wall41 = new Sprite(wall11);
		wall41.setPosition(house34.getX() + house34.getWidth() - 10,
				wall11.getY());
		wall51 = new Sprite(wall11);
		wall51.setPosition(house35.getX() + house35.getWidth() - 10,
				wall11.getY());
		wall61 = new Sprite(wall11);
		wall61.setPosition(house36.getX() - wall61.getWidth() + 10,
				wall11.getY());

		house1Bg = new Background(0, 200, 0, -200, 0);
	}

	public void render(SpriteBatch batch, float delta) {
		// if(house1Bg.getPosition().x < -house11.getWidth()) {
		// house1Bg.getPosition().x += 2000;
		// }
		// house1Bg.update(delta);
		// batch.draw(house1, house1Bg.getPosition().x,
		// house1Bg.getPosition().y);
		// if(house2Bg.getPosition().x < -house11.getWidth()) {
		// house2Bg.getPosition().x += 2000;
		// }
		// house2Bg.update(delta);
		// batch.draw(house1, house2Bg.getPosition().x,
		// house2Bg.getPosition().y);
		// if(house3Bg.getPosition().x < -house11.getWidth()) {
		// house3Bg.getPosition().x += 2000;
		// }
		// house3Bg.update(delta);
		// batch.draw(house1, house3Bg.getPosition().x,
		// house3Bg.getPosition().y);
		// if(house4Bg.getPosition().x < -house11.getWidth()) {
		// house4Bg.getPosition().x += 2000;
		// }
		// house4Bg.update(delta);
		// batch.draw(house1, house4Bg.getPosition().x,
		// house4Bg.getPosition().y);
		// if(house5Bg.getPosition().x < -house11.getWidth()) {
		// house5Bg.getPosition().x += 2000;
		// }
		// house5Bg.update(delta);
		// batch.draw(house1, house5Bg.getPosition().x,
		// house5Bg.getPosition().y);

		// kiểu nhà 3
		renderHouse3(batch, delta);
		// wall
		renderWall(batch, delta);
		// kieu nha 1
		renderHouse1(batch, delta);
		// kieu nha 2
		renderHouse2(batch, delta);
		// kieu nha 4
		renderHouse4(batch, delta);
		// kieu nha 5
		renderHouse5(batch, delta);
		// kieu nha 6
		renderHouse6(batch, delta);
		// kieu nha 7
		renderHouse7(batch, delta);
	}

	private void renderHouse7(SpriteBatch batch, float delta) {
		setXSprite(house7, delta, false);

		house7.draw(batch);
	}

	private void renderHouse6(SpriteBatch batch, float delta) {
		setXSprite(house6, delta, false);

		house6.draw(batch);
	}

	private void renderHouse5(SpriteBatch batch, float delta) {
		setXSprite(house5, delta, false);
		setXSprite(house51, delta, true);
		setXSprite(house52, delta, true);

		house5.draw(batch);
		house51.draw(batch);
		house52.draw(batch);
	}

	private void renderHouse4(SpriteBatch batch, float delta) {
		setXSprite(house4, delta, false);

		house4.draw(batch);
	}

	private void renderHouse2(SpriteBatch batch, float delta) {
		setXSprite(house2, delta, false);

		house2.draw(batch);

	}

	private void renderHouse1(SpriteBatch batch, float delta) {
		setXSprite(house1, delta, false);
		setXSprite(house11, delta, true);
		house1.draw(batch);
		house11.draw(batch);
	}

	/*
	 * tường tương ứng với từng loại nhà 3
	 */
	private void renderWall(SpriteBatch batch, float delta) {
		setXSprite(wall11, delta, false);
		setXSprite(wall12, delta, false);
		setXSprite(wall21, delta, false);
		setXSprite(wall22, delta, false);
		setXSprite(wall31, delta, false);
		setXSprite(wall41, delta, false);
		setXSprite(wall51, delta, false);
		setXSprite(wall61, delta, false);

		wall11.draw(batch);
		wall12.draw(batch);
		wall21.draw(batch);
		wall22.draw(batch);
		wall31.draw(batch);
		wall41.draw(batch);
		wall51.draw(batch);
		wall61.draw(batch);
	}

	private void renderHouse3(SpriteBatch batch, float delta) {
		setXSprite(house31, delta, false);
		setXSprite(house32, delta, false);
		setXSprite(house33, delta, false);
		setXSprite(house34, delta, false);
		setXSprite(house35, delta, false);
		setXSprite(house36, delta, false);
		// house1Bg.update(delta);
		// house31.setPosition(house1Bg.getPosition().x,
		// house1Bg.getPosition().y);
		house31.draw(batch);
		house32.draw(batch);
		house33.draw(batch);
		house34.draw(batch);
		house35.draw(batch);
		house36.draw(batch);
	}

	private void setXSprite(Sprite sprite, float delta, boolean random) {
		if (!world.isStop()) {
			float deltaX = -vx * delta;
			sprite.setX(sprite.getX() + deltaX);
		}

		if (0 > sprite.getX() + sprite.getWidth()) {
			if (!random)
				sprite.setX(sprite.getX() + widthHouse);
			else
				sprite.setX(sprite.getX() + MathUtils.random(-5, 5) * 100
						+ widthHouse);
		}
//		Gdx.app.error("reset sprite" + sprite.toString(), "" + sprite.getX());
	}

}
