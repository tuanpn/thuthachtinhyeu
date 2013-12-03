package vn.sunnet.lovechallenge.model.world;

import vn.sunnet.lovechallenge.model.bg.Background;
import vn.sunnet.lovechallenge.model.bg.BackgroundLayer2;
import vn.sunnet.lovechallenge.model.bg.House;
import vn.sunnet.lovechallenge.model.bg.Road;
import vn.sunnet.lovechallenge.model.bg.Sky;
import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.staticobjects.Box1;
import vn.sunnet.lovechallenge.model.staticobjects.Box2;
import vn.sunnet.lovechallenge.model.staticobjects.Car;
import vn.sunnet.lovechallenge.model.staticobjects.CarLong;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;
import vn.sunnet.lovechallenge.model.staticobjects.Static1;
import vn.sunnet.lovechallenge.model.staticobjects.Static2;
import vn.sunnet.lovechallenge.model.staticobjects.Static3;
import vn.sunnet.lovechallenge.model.staticobjects.Static4;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {

	// bg
	private Array<Background> backgrounds;

	public Array<Background> getBackgrounds() {
		return backgrounds;
	}

	// player
	private Player player;

	// static object
	private Array<Impediment> staticObjects;

	public Array<Impediment> getStaticObjects() {
		return staticObjects;
	}

	public void setStaticObjects(Array<Impediment> staticObjects) {
		this.staticObjects = staticObjects;
	}

	private float stateTimeObject;
	private float timeCreate = 2;

	/**
	 * 0 : sáng ; 1 : sáng sang chiều ; 2 : chiều sang tối ; 3 : tối
	 */
	private int typeSky;

	public float stateTime;

	public Player getPlayer() {
		return player;
	}

	private Sky sky1;
	private Sky sky2;

	public World() {
		// bg
		backgrounds = new Array<Background>();
		createBackground();
		// player
		player = new Player(0);

		staticObjects = new Array<Impediment>();
	}

	public boolean isStop() {
		return player.isStopUpdate();
	}

	public int getTypeSky() {
		return typeSky;
	}

	public void setTypeSky(int typeSky) {
		this.typeSky = typeSky;
	}

	public void update(float delta) {

		if (sky1.getCount() == 3) {
			typeSky = 1;
		} else if (sky1.getCount() > 3 && sky1.getCount() < 7) {
			typeSky = 2;
		} else if (sky1.getCount() == 7) {
			typeSky = 3;
		} else if (sky1.getCount() > 7) {
			typeSky = 4;
		}

		for (Background bg : backgrounds) {
			bg.update(delta);
		}
		createObject(delta);
	}

	private void createBackground() {
		//0-1
		backgrounds.add(new Sky(0, 0, 201));
		backgrounds.add(new Sky(0, 877, 201));
		sky1 = (Sky) backgrounds.get(0);
		sky1.setCount(-1);
		sky2 = (Sky) backgrounds.get(1);
		// add road 2-3
		backgrounds.add(new Road(0, 0, 0));
		backgrounds.add(new Road(0, 877, 0));
		// add layer2 4-5
		backgrounds.add(new BackgroundLayer2(0, 0, 201));
		backgrounds.add(new BackgroundLayer2(0, 843, 201));
		// add house 6-11
		backgrounds.add(new House(0, 30, 70, 295, 407));
		backgrounds.add(new House(0, 380, 80, 176, 348));
		backgrounds.add(new House(0, 700, 70, 164, 255));
		backgrounds.add(new House(0, 700, 70, 205, 419));
		backgrounds.add(new House(0, 1000, 70, 224, 343));
		backgrounds.add(new House(0, 1300, 70, 541, 495));

	}

	// sinh ra các chướng ngại vật
	private void createObject(float delta) {
		stateTimeObject += delta;

		if (stateTimeObject > timeCreate) {
			stateTimeObject = 0;
			timeCreate = MathUtils.random(3.f, 5.f);
			switch (MathUtils.random(7, 7)) {
			case 0:
				staticObjects.add(new Car(new Vector2(player.getPosition().x
						+ MathUtils.random(1000, 1200), 10)));
				break;
			case 1:
				staticObjects.add(new Box1(new Vector2(player.getPosition().x
						+ MathUtils.random(1000, 1200), 10)));
				break;
			case 2:
				staticObjects.add(new Box2(new Vector2(player.getPosition().x
						+ MathUtils.random(1000, 1200), 20)));
				break;
			case 3:
				staticObjects.add(new Static1(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						5)));
				break;
			case 4:
				staticObjects.add(new Static2(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						20)));
				break;
			case 5:
				staticObjects.add(new Static3(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						20)));
				break;
			case 6:
				staticObjects.add(new Static4(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						20)));
				break;
			case 7:
				staticObjects.add(new CarLong(new Vector2(
						player.getPosition().x + MathUtils.random(1100, 1200),
						10)));
				break;

			default:
				break;
			}

		}

		for (Impediment impediment : staticObjects) {
			impediment.update(delta);
			if (impediment.getPosition().x < -impediment.getBounds().width - 100) {
				staticObjects.removeValue(impediment, true);
				break;
			}
		}
		// System.out.println("World : " + player.getActionState());
	}

	public void reset() {
		player.resetAll();
		staticObjects.clear();
		backgrounds.clear();
	}

}
