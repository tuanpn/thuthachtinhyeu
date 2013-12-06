package vn.sunnet.lovechallenge.model.world;

import vn.sunnet.lovechallenge.model.bg.Background;
import vn.sunnet.lovechallenge.model.bg.BackgroundLayer2;
import vn.sunnet.lovechallenge.model.bg.House;
import vn.sunnet.lovechallenge.model.bg.Lamppost;
import vn.sunnet.lovechallenge.model.bg.Road;
import vn.sunnet.lovechallenge.model.bg.Sky;
import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.staticobjects.Box1;
import vn.sunnet.lovechallenge.model.staticobjects.Box2;
import vn.sunnet.lovechallenge.model.staticobjects.Car;
import vn.sunnet.lovechallenge.model.staticobjects.CarLong;
import vn.sunnet.lovechallenge.model.staticobjects.CarShort;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;
import vn.sunnet.lovechallenge.model.staticobjects.Static1;
import vn.sunnet.lovechallenge.model.staticobjects.Static2;
import vn.sunnet.lovechallenge.model.staticobjects.Static3;
import vn.sunnet.lovechallenge.model.staticobjects.Static4;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {

	// bg
	private Array<Background> backgrounds;
	private Lamppost[] lampposts;

	public Array<Background> getBackgrounds() {
		return backgrounds;
	}

	public Lamppost[] getLampposts() {
		return lampposts;
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

	public OrthographicCamera cam;

	public Player getPlayer() {
		return player;
	}

	private Sky sky1;
	private Sky sky2;

	public World() {
		// bg
		backgrounds = new Array<Background>();
		lampposts = new Lamppost[6];
		createBackground();
		// player
		player = new Player(0);

		staticObjects = new Array<Impediment>();

		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		cam.position.set(400, 240, 0);
		cam.update();
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
		cam.position.x = player.getPosition().x + 400 - player.POSITION_INIT_X;

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
			if (cam.position.x > bg.getPosition().x + bg.getWidth() + 400) {
				bg.setRepeat(true);
			}

			bg.update(delta);
		}
		for (int i = 0; i < lampposts.length; i++) {
			if (cam.position.x > lampposts[i].getPosition().x
					+ lampposts[i].getWidth() + 400) {
				lampposts[i].setRepeat(true);
			}
			lampposts[i].update(delta);
		}

		createObject(delta);

		cam.update();

	}

	private void createBackground() {
		// 0-1
		backgrounds.add(new Sky(0, 0, 600));
		backgrounds.add(new Sky(0, 1000, 600));
		sky1 = (Sky) backgrounds.get(0);
		sky1.setCount(-1);
		sky2 = (Sky) backgrounds.get(1);
		// add road 2-3
		backgrounds.add(new Road(0, 0, 0));
		backgrounds.add(new Road(0, 877, 0));
		// add layer2 4-5
		backgrounds.add(new BackgroundLayer2(0, 0, 201));
		backgrounds.add(new BackgroundLayer2(0, 843, 201));
		// add house 6
		backgrounds.add(new House(0, 0, 0, 3000, 1000));
		backgrounds.add(new House(1, 3000, 0, 3000, 1000));
		// lamppost
		lampposts[0] = new Lamppost(0, 20, 120);
		lampposts[1] = new Lamppost(0, 520, 120);
		lampposts[2] = new Lamppost(0, 1020, 120);
		lampposts[3] = new Lamppost(0, 1520, 120);
		lampposts[4] = new Lamppost(0, 2020, 120);
		lampposts[5] = new Lamppost(0, 2520, 120);
	}

	// sinh ra các chướng ngại vật
	private void createObject(float delta) {
		stateTimeObject += delta;

		if (stateTimeObject > timeCreate) {
			stateTimeObject = 0;
			timeCreate = MathUtils.random(3.f, 5.f);
			switch (MathUtils.random(7, 7)) {
			case 0:
				staticObjects.add(new CarShort(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						55)));
				break;
			case 1:
				staticObjects.add(new Box1(new Vector2(player.getPosition().x
						+ MathUtils.random(1000, 1200), 75)));
				break;
			case 2:
				staticObjects.add(new Box2(new Vector2(player.getPosition().x
						+ MathUtils.random(1000, 1200), 75)));
				break;
			case 3:
				staticObjects.add(new Static1(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						60)));
				break;
			case 4:
				staticObjects.add(new Static2(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						55)));
				break;
			case 5:
				staticObjects.add(new Static3(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						75)));
				break;
			case 6:
				staticObjects.add(new Static4(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						80)));
				break;
			case 7:
				staticObjects.add(new CarLong(new Vector2(
						player.getPosition().x + MathUtils.random(1000, 1200),
						60)));
				break;

			default:
				break;
			}

		}

		for (Impediment impediment : staticObjects) {
			impediment.update(delta);
			if (player.isFlingUp()) {
				impediment.setCollisionPlayer(true);
				System.out.println("true");
			}
			if (impediment.getPosition().x < cam.position.x - 400
					- impediment.getBounds().width) {
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
